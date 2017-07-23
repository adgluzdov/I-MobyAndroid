package com.dronteam.adm.i_moby.scenarios.show_case;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dronteam.adm.i_moby.R;
import com.dronteam.adm.i_moby.common.ScreenInfo;
import com.dronteam.adm.i_moby.common.fragment.MainFragment;
import com.dronteam.adm.i_moby.common.progressbar.SwapProgressbarListener;

/**
 * Created by smb on 13/12/2016.
 */
public class ShowCaseFragment extends MainFragment implements ShowCaseView {
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
        return view;
    }

    @Override
    protected int getLayout() {
        return R.layout.show_case2;
    }

    @Override
    public String getTitleFragment() {
        return "Лучшее";
    }

    @Override
    public void setList(RecyclerView.Adapter adapter) {
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
    public void startTopProgressbar() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void stopTopProgressbar() {
        swipeRefreshLayout.setRefreshing(false);
    }
}
