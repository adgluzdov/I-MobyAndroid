package com.dronteam.adm.i_moby.scenarios.search;

import android.app.Fragment;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.dronteam.adm.i_moby.R;
import com.dronteam.adm.i_moby.common.MainFragment;
import com.dronteam.adm.i_moby.common.ViewListener;

/**
 * Created by adm on 22.04.2017.
 */

public class SearchGoodsFragment extends MainFragment implements SearchGoodsView {

    public SearchGoodsFragment() {
    }

    @Override
    public void setQueryHint(String queryHint) {
        ((SearchView)getView(R.id.searchView)).setQueryHint(queryHint);
    }

    @Override
    public void setOnQueryTextListener(SearchView.OnQueryTextListener listener) {
        ((SearchView)getView(R.id.searchView)).setOnQueryTextListener(listener);
    }

    @Override
    public void setAdapter(BaseAdapter adapter) {
        ((ListView)getView(R.id.listView)).setAdapter(adapter);
    }

    @Override
    protected int getLayout() {
        return R.layout.search_goods;
    }
}
