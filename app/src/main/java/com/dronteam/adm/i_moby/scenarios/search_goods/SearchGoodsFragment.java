package com.dronteam.adm.i_moby.scenarios.search_goods;

import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;

import com.dronteam.adm.i_moby.R;
import com.dronteam.adm.i_moby.common.MainFragment;

/**
 * Created by adm on 22.04.2017.
 */

public class SearchGoodsFragment extends MainFragment implements SearchGoodsView {

    public SearchGoodsFragment() {
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
    public void setAdapter(BaseAdapter adapter) {
        ((ListView)getView(R.id.list_view)).setAdapter(adapter);
    }

    @Override
    protected int getLayout() {
        return R.layout.search_goods;
    }

    @Override
    public void startProgressBar() {
        ((ProgressBar)getView(R.id.progress_bar)).setVisibility(ProgressBar.VISIBLE);
    }

    @Override
    public void stopProgressBar() {
        ((ProgressBar)getView(R.id.progress_bar)).setVisibility(ProgressBar.INVISIBLE);
    }
}
