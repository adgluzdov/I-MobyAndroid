package com.dronteam.adm.i_moby.common.fragment.with_toolbar.with_menu.with_search_view;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;

import com.dronteam.adm.i_moby.common.CallBack;
import com.dronteam.adm.i_moby.common.CallBack2;
import com.dronteam.adm.i_moby.common.fragment.with_toolbar.with_menu.FragmentWithToolbarWithMenu;

/**
 * Created by adm on 08.07.2017.
 */

public abstract class FragmentWithToolbarWithSearchView extends FragmentWithToolbarWithMenu implements ViewWithToolbarWithSearchView {

    protected SearchView getSearchView(){
        return (SearchView) MenuItemCompat.getActionView(getMenu().findItem(getIdSearchView()));
    }

    protected abstract int getIdSearchView();

    @Override
    public void setQuery(String query,Boolean bool) {
        getSearchView().setQuery(query,bool);
    }

    @Override
    public void setActive() {
        getSearchView().setIconifiedByDefault(true);
        getSearchView().setFocusable(true);
        getSearchView().setIconified(false);
        getSearchView().clearFocus();
    }

    @Override
    public void setOnSubmit(final CallBack2<String> callBack) {
        getSearchView().setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                callBack.call(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    @Override
    public void setOnClose(final CallBack callBack) {
        getSearchView().setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                callBack.call();
                return false;
            }
        });
    }
}
