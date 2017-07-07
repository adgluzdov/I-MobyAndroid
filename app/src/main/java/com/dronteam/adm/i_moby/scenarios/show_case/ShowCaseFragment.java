package com.dronteam.adm.i_moby.scenarios.show_case;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
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
public class ShowCaseFragment extends MainFragment implements ShowCase {

    OptionsMenuListener optionsMenuListener = null;

    @Override
    protected int getLayout() {
        return R.layout.show_case;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater,container,savedInstanceState);
        this.setToolbar();
        return view;
    }

    private void setToolbar(){
        Toolbar toolbar = (Toolbar) getView(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search_menu, menu);
        if(optionsMenuListener !=  null)
            optionsMenuListener.onCreateOptionsMenu();
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void setQuery(String query) {
        getSearchView().setQuery(query,false);
    }

    @Override
    public void setActive() {
        getSearchView().setIconifiedByDefault(true);
        getSearchView().setFocusable(true);
        getSearchView().setIconified(false);
        getSearchView().clearFocus();
    }

    @Override
    public void setOnQueryTextListener(SearchView.OnQueryTextListener listener) {
        getSearchView().setOnQueryTextListener(listener);
    }



    public SearchView getSearchView() {
        return (SearchView)MenuItemCompat.getActionView(getToolbar().getMenu().findItem(R.id.action_search));
    }

    public Toolbar getToolbar() {
        return (Toolbar) getView(R.id.toolbar);
    }

    @Override
    public void setOnClose(SearchView.OnCloseListener listener) {
        getSearchView().setOnCloseListener(listener);
    }

    @Override
    public void setOnCreateOptionsMenu(OptionsMenuListener listener) {
        optionsMenuListener = listener;
    }

    @Override
    public void setTitle(String title) {
        getToolbar().setTitle(title);
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

}
