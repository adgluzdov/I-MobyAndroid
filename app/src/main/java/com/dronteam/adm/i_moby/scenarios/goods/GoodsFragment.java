package com.dronteam.adm.i_moby.scenarios.goods;


import android.widget.BaseAdapter;
import android.widget.ProgressBar;

import com.dronteam.adm.i_moby.R;
import com.dronteam.adm.i_moby.common.MainFragment;

public class GoodsFragment extends MainFragment implements GoodsView {

    @Override
    public void setList(BaseAdapter adapter) {
        getListView(R.id.list_view).setAdapter(adapter);
    }

    @Override
    protected int getLayout() {
        return R.layout.goods;
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
