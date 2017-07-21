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

public class GoodsFragment extends MainFragment implements GoodsView {

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
        //((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return view;
    }
    @Override
    protected int getLayout() {
        return R.layout.goods2;
    }

    @Override
    public void setList(RecyclerView.Adapter adapter, ViewManager viewManager) {
        mRecyclerView.setHasFixedSize(true);
        if(ScreenInfo.sizes(viewManager.getContext()).x<600) {
            COLUMNS_COUNT = 2;
            layoutManagerTablet = new GridLayoutManager(viewManager.getContext(), 2);
            mRecyclerView.setLayoutManager(layoutManagerTablet);
        }
        else {
            COLUMNS_COUNT = 3;
            layoutManagerTablet = new GridLayoutManager(viewManager.getContext(), 3);
            mRecyclerView.setLayoutManager(layoutManagerTablet);
        }
        ((RecyclerView)getView(R.id.recyclerView)).setAdapter(adapter);
    }

}
