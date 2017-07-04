package com.dronteam.adm.i_moby.common;

import android.support.v7.widget.SearchView;

/**
 * Created by adm on 05.07.2017.
 */

public interface SearchMenuItem {
    SearchView getSearchView();
    void setOnQueryTextListener(SearchView.OnQueryTextListener listener);
    void setText(String text);
    void setOnClose(SearchView.OnCloseListener listener);
}
