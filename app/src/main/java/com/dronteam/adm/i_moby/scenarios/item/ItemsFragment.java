package com.dronteam.adm.i_moby.scenarios.item;


import com.dronteam.adm.i_moby.R;
import com.dronteam.adm.i_moby.common.MainFragment;

public class ItemsFragment extends MainFragment implements ItemsView {

    @Override
    public void setList(ItemAdapter adapter) {
        getListView(R.id.ListViewMain).setAdapter(adapter);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_item;
    }
}
