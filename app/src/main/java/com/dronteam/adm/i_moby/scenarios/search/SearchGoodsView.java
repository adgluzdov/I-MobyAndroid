package com.dronteam.adm.i_moby.scenarios.search;

import android.widget.BaseAdapter;
import android.widget.SearchView;

import com.dronteam.adm.i_moby.common.CommonView;

/**
 * Created by adm on 22.04.2017.
 */

public interface SearchGoodsView extends CommonView {
    void setQueryHint(String queryHint);
    void setOnQueryTextListener(SearchView.OnQueryTextListener listener);
    void setAdapter(BaseAdapter adapter);
}
