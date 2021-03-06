package com.dronteam.adm.i_moby.scenarios.catalog;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.dronteam.adm.i_moby.R;
import com.dronteam.adm.i_moby.common.CallBack;
import com.dronteam.adm.i_moby.common.ScreenInfo;
import com.dronteam.adm.i_moby.common.fragment.MainFragment;
import com.dronteam.adm.i_moby.common.progressbar.SwapProgressbarListener;

/**
 * Created by adm on 04.07.2017.
 */

public class CatalogFragment extends MainFragment implements CatalogView {
    private int COLUMNS_COUNT = 0;
    private SwipeRefreshLayout swipeRefreshLayout = null;
    private  RecyclerView mRecyclerView = null;
    private LinearLayoutManager layoutManagerPhone = null;
    private GridLayoutManager layoutManagerTablet = null;
    private View no_albums = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater,container,savedInstanceState);
        swipeRefreshLayout = (SwipeRefreshLayout)getView(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mRecyclerView = (RecyclerView)getView(R.id.recyclerView);
        no_albums = getView(R.id.no_albums);
        no_albums.setVisibility(View.GONE);
        return view;
    }

    @Override
    public int getLayout() {
        return R.layout.catalog2;
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
        mRecyclerView.setHasFixedSize(true);
        if(ScreenInfo.sizes(getActivity()).x<600) {
            COLUMNS_COUNT = 1;
            layoutManagerPhone = new LinearLayoutManager(getActivity());
            mRecyclerView.setLayoutManager(layoutManagerPhone);
        }
        else {
            COLUMNS_COUNT = 2;
            layoutManagerTablet = new GridLayoutManager(getActivity(), 2);
            mRecyclerView.setLayoutManager(layoutManagerTablet);
        }
        ((RecyclerView)getView(R.id.recyclerView)).setAdapter(adapter);
    }

    @Override
    public void informingFailedToConnect() {
        informing(getResources().getString(R.string.error_connection));
    }
}
