package com.dronteam.adm.i_moby.scenarios.search;

import android.content.Context;
import android.widget.SearchView;

/**
 * Created by adm on 22.04.2017.
 */

public class IMobySearchFragment extends SearchView implements IMobySearchView{

    public IMobySearchFragment(Context context) {
        super(context);
    }

    @Override
    public void setQueryHint(String queryHint) {
        this.setQueryHint(queryHint);
    }

    @Override
    public void setOnQueryTextListener(OnQueryTextListener listener) {
        this.setOnQueryTextListener(listener);
    }
}
