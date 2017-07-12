package com.dronteam.adm.i_moby.scenarios.catalog;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.dronteam.adm.i_moby.R;
import com.dronteam.adm.i_moby.common.CallBack;
import com.dronteam.adm.i_moby.common.fragment.MainFragment;

/**
 * Created by adm on 04.07.2017.
 */

public class CatalogFragment extends MainFragment implements CatalogView {
    private ListView getList(){
        return getListView(R.id.list_view);
    }

    @Override
    protected int getLayout() {
        return R.layout.catalog;
    }

    @Override
    public void startTopProgressbar() {
        ((ProgressBar)getView(R.id.progress_bar)).setVisibility(ProgressBar.VISIBLE);
    }

    @Override
    public void stopTopProgressbar() {
        ((ProgressBar)getView(R.id.progress_bar)).setVisibility(ProgressBar.INVISIBLE);
    }

    @Override
    public String getTitleFragment() {
        return "dssdsd";
    }

    @Override
    public void setList(RecyclerView.Adapter adapter) {

    }
}
