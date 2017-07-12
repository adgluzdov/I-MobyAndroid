package com.dronteam.adm.i_moby.scenarios.album;

import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.common.adapters.ItemPresenter;
import com.dronteam.adm.i_moby.common.adapters.recycler_view_adapter.CommonRecyclerViewAdapter;
import com.dronteam.adm.i_moby.common.adapters.recycler_view_adapter.CommonViewHolder;

/**
 * Created by adm on 12.07.2017.
 */

public class AlbumAdapter extends CommonRecyclerViewAdapter {

    public AlbumAdapter(ViewManager viewManager) {
        super(viewManager);
    }

    @Override
    public ItemPresenter createItemPresenter() {
        return new AlbumPresenter(getViewManager(),null,new AlbumFragment(getViewManager().getContext()));
    }
}
