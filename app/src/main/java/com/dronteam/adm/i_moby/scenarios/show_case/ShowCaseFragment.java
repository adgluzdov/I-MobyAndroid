package com.dronteam.adm.i_moby.scenarios.show_case;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;

import com.dronteam.adm.i_moby.R;
import com.dronteam.adm.i_moby.common.CallBack;
import com.dronteam.adm.i_moby.common.MainFragment;
import com.dronteam.adm.i_moby.common.OptionsMenuListener;

/**
 * Created by smb on 13/12/2016.
 */
public class ShowCaseFragment extends MainFragment implements ShowCaseView {

    private static final String TAG = "My";
    Toolbar toolbar = null;
    SearchView searchView = null;
    OptionsMenuListener optionsMenuListener = null;
    Menu menu = null;

    @Override
    protected int getLayout() {
        return R.layout.show_case;
    }

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

    public void setSearchMenuItem(SearchView searchView) {
        SearchManager manager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(manager.getSearchableInfo(getActivity().getComponentName()));
        searchView.setIconifiedByDefault(false);
    }




    @Override
    public void setOnQueryTextListener(SearchView.OnQueryTextListener listener) {
        getSearchView().setOnQueryTextListener(listener);
    }

    @Override
    public void setText(String text) {

    }

    @Override
    public void setOnClose(SearchView.OnCloseListener listener) {

    }

    @Override
    public void setOnButtonCatalogClick(final CallBack callBack) {
        getButton(R.id.button_open_catalog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBack.call();
            }
        });
    }

    @Override
    public void setList(BaseAdapter adapter)  {
        getListView(R.id.list_view).setAdapter(adapter);
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

    }

    @Override
    public void stopUnderProgressBar() {

    }

    @Override
    public SearchView getSearchView() {
        return (SearchView) menu.findItem(R.id.action_search).getActionView();
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
