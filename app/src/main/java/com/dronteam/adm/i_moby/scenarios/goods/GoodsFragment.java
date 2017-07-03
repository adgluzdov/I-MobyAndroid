package com.dronteam.adm.i_moby.scenarios.goods;


import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;

import com.dronteam.adm.i_moby.R;
import com.dronteam.adm.i_moby.common.MainFragment;

import static android.content.ContentValues.TAG;

public class GoodsFragment extends MainFragment implements GoodsView {

    private ListView getList(){
        return getListView(R.id.list_view);
    }
    @Override
    public void setList(BaseAdapter adapter) {
        getList().setAdapter(adapter);
    }

    @Override
    public void setOnScrollListener(AbsListView.OnScrollListener listener) {
        getList().setOnScrollListener(listener);
    }

    @Override
    public int listViewGetLastVisiblePosition() {
        return getList().getLastVisiblePosition();
    }

    @Override
    public int listViewGetHeaderViewsCount() {
        return getList().getHeaderViewsCount();
    }

    @Override
    public int listViewGetFooterViewsCount() {
        return getList().getFooterViewsCount();
    }

    @Override
    public void setOnCloseListener(SearchView.OnCloseListener listener) {
        ((SearchView)getView(R.id.search_view)).setOnCloseListener(listener);
    }

    @Override
    public void setQueryHint(String queryHint) {
        ((SearchView)getView(R.id.search_view)).setQueryHint(queryHint);
    }

    @Override
    public void setOnQueryTextListener(SearchView.OnQueryTextListener listener) {
        ((SearchView)getView(R.id.search_view)).setOnQueryTextListener(listener);
    }

    @Override
    protected int getLayout() {
        return R.layout.goods;
    }

    @Override
    public void startProgressBar() {
        ((ProgressBar)getView(R.id.progress_bar)).setVisibility(ProgressBar.VISIBLE);
    }

    @Override
    public void stopProgressBar() {
        ((ProgressBar)getView(R.id.progress_bar)).setVisibility(ProgressBar.INVISIBLE);
    }

    @Override
    public void startUnderProgressBar() {
        ((ProgressBar)getView(R.id.under_progress_bar)).setVisibility(ProgressBar.VISIBLE);
    }

    @Override
    public void stopUnderProgressBar() {
        ((ProgressBar)getView(R.id.under_progress_bar)).setVisibility(ProgressBar.INVISIBLE);
    }
}
