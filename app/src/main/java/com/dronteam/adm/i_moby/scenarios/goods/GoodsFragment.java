package com.dronteam.adm.i_moby.scenarios.goods;


import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.dronteam.adm.i_moby.R;
import com.dronteam.adm.i_moby.common.CallBack;
import com.dronteam.adm.i_moby.common.CallBack2;
import com.dronteam.adm.i_moby.common.OnScrollViewListener;
import com.dronteam.adm.i_moby.common.ScreenInfo;
import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.common.fragment.MainFragment;
import com.dronteam.adm.i_moby.common.fragment.with_toolbar.with_menu.OptionsMenuListener;
import com.dronteam.adm.i_moby.common.fragment.with_toolbar.with_menu.with_search_view.FragmentWithToolbarWithSearchView;
import com.dronteam.adm.i_moby.common.progressbar.SwapProgressbarListener;

public class GoodsFragment extends FragmentWithToolbarWithSearchView implements GoodsView {

    private int COLUMNS_COUNT = 0;
    private SwipeRefreshLayout swipeRefreshLayout = null;
    private  RecyclerView mRecyclerView = null;
    private LinearLayoutManager layoutManagerPhone = null;
    private GridLayoutManager layoutManagerTablet = null;
    private View no_goods = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater,container,savedInstanceState);
        swipeRefreshLayout = (SwipeRefreshLayout)getView(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mRecyclerView = (RecyclerView)getView(R.id.recyclerView);
        no_goods = getView(R.id.no_goods);
        no_goods.setVisibility(View.GONE);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return view;
    }
    @Override
    protected int getLayout() {
        return R.layout.goods2;
    }

    @Override
    public void startTopProgressbar() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void stopTopProgressbar() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void setSwapProgressbarListener(final SwapProgressbarListener listener) {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                listener.onSwap();
            }
        });
    }

    @Override
    public void setList(RecyclerView.Adapter adapter) {
        mRecyclerView.setVisibility(View.VISIBLE);
        no_goods.setVisibility(View.GONE);
        mRecyclerView.setHasFixedSize(true);
        if(ScreenInfo.sizes(getActivity()).x<600) {
            COLUMNS_COUNT = 2;
            layoutManagerTablet = new GridLayoutManager(getActivity(), 2);
            mRecyclerView.setLayoutManager(layoutManagerTablet);
        }
        else {
            COLUMNS_COUNT = 3;
            layoutManagerTablet = new GridLayoutManager(getActivity(), 3);
            mRecyclerView.setLayoutManager(layoutManagerTablet);
        }
        ((RecyclerView)getView(R.id.recyclerView)).setAdapter(adapter);
    }

    @Override
    public void notifyNoGoods() {
        mRecyclerView.setVisibility(View.GONE);
        no_goods.setVisibility(View.VISIBLE);
    }

    @Override
    public void setOnScrollListener(final OnScrollViewListener listener) {
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                 listener.onScroll(dy);
            }
        });
    }

    @Override
    public int getChildCount() {
        if(COLUMNS_COUNT == 1)
            return layoutManagerPhone.getChildCount();
        else
            return layoutManagerTablet.getChildCount();
    }

    @Override
    public int findFirstVisibleItemPosition() {
        if(COLUMNS_COUNT == 1)
            return layoutManagerPhone.findFirstVisibleItemPosition();
        else
            return layoutManagerTablet.findFirstVisibleItemPosition();
    }

    @Override
    public void informingFailedToConnect() {
        informing(getResources().getString(R.string.error_connection));
    }

    @Override
    protected int getIdSearchView() {
        return R.id.action_search;
    }

    @Override
    protected int getIdToolbar() {
        return R.id.toolbar;
    }

    @Override
    protected int getMenuXml() {
        return R.menu.search_menu;
    }

}
