package com.dronteam.adm.i_moby.scenarios.goods;


import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

public class GoodsFragment extends FragmentWithToolbarWithSearchView implements GoodsView {

    LinearLayoutManager layoutManagerPhone;
    @Override
    protected int getLayout() {
        return R.layout.goods2;
    }

    @Override
    public void startTopProgressbar() {
        //((ProgressBar)getView(R.id.progress_bar)).setVisibility(ProgressBar.VISIBLE);
    }

    @Override
    public void stopTopProgressbar() {
        //((ProgressBar)getView(R.id.progress_bar)).setVisibility(ProgressBar.INVISIBLE);
    }
    @Override
    public void setList(RecyclerView.Adapter adapter, ViewManager viewManager) {
        RecyclerView mRecyclerView = (RecyclerView)getView(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        layoutManagerPhone = new LinearLayoutManager(viewManager.getContext());
        mRecyclerView.setLayoutManager(layoutManagerPhone);
        ((RecyclerView)getView(R.id.recyclerView)).setAdapter(adapter);
    }

    @Override
    public void setOnScrollListener(final OnScrollViewListener listener) {
        RecyclerView mRecyclerView = (RecyclerView)getView(R.id.recyclerView);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int position = layoutManagerPhone.getItemCount() - layoutManagerPhone.getChildCount() - layoutManagerPhone.findFirstVisibleItemPosition();
                listener.onScroll(dy);
            }
        });
    }

    @Override
    public int getChildCount() {
        return layoutManagerPhone.getChildCount();
    }

    @Override
    public int findFirstVisibleItemPosition() {
        return layoutManagerPhone.findFirstVisibleItemPosition();
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
    public String getTitle() {
        return "Главная";
    }

    @Override
    protected int getMenuXml() {
        return R.menu.search_menu;
    }

}
