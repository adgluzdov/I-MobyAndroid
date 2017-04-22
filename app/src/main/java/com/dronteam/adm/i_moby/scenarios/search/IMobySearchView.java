package com.dronteam.adm.i_moby.scenarios.search;

import android.widget.SearchView;

/**
 * Created by adm on 22.04.2017.
 */

public interface IMobySearchView {
    void setQueryHint(String queryHint);
    void setOnQueryTextListener(SearchView.OnQueryTextListener listener);
}
