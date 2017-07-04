package com.dronteam.adm.i_moby.scenarios.goods;


import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dronteam.adm.i_moby.R;
import com.dronteam.adm.i_moby.common.MainFragment;
import com.dronteam.adm.i_moby.common.OptionsMenuListener;

import static android.content.ContentValues.TAG;

public class GoodsFragment extends MainFragment implements GoodsView {

    OptionsMenuListener optionsMenuListener = null;
    Menu menu = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater,container,savedInstanceState);
        this.setToolbar(view);
        return view;
    }

    private void setToolbar(View view){
        ((AppCompatActivity)getActivity()).setSupportActionBar(((Toolbar) view.findViewById(R.id.toolbar)));
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search_menu, menu);
        this.menu = menu;
        this.setSearchMenuItem(this.getSearchView());
        if(optionsMenuListener !=  null)
            optionsMenuListener.onCreateOptionsMenu();
        super.onCreateOptionsMenu(menu, inflater);
    }

    public void setSearchMenuItem(android.support.v7.widget.SearchView searchView) {
        SearchManager manager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(manager.getSearchableInfo(getActivity().getComponentName()));
    }


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

    public SearchView getSearchView() {
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        return searchView;
    }

    @Override
    public void setOnQueryTextListener(android.support.v7.widget.SearchView.OnQueryTextListener listener) {
        getSearchView().setOnQueryTextListener(listener);
    }

    @Override
    public void setText(String text) {
        getSearchView().setQuery(text,false);
        getSearchView().clearFocus();
    }

    @Override
    public void setOnClose(SearchView.OnCloseListener listener) {
        getSearchView().setOnCloseListener(listener);
    }

    @Override
    public Toolbar getToolbar() {
        return (Toolbar) getView(R.id.toolbar);
    }

    @Override
    public void setOnCreateOptionsMenu(OptionsMenuListener listener) {
        optionsMenuListener = listener;
    }
}
