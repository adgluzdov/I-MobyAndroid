package com.dronteam.adm.i_moby.scenarios.album;

import android.view.ViewGroup;

import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.common.adapters.ItemPresenter;
import com.dronteam.adm.i_moby.common.adapters.recycler_view_adapter.CommonRecyclerViewAdapter;
import com.dronteam.adm.i_moby.common.adapters.recycler_view_adapter.CommonViewHolder;
import com.dronteam.adm.i_moby.model.album.Item;
import com.dronteam.adm.i_moby.scenarios.catalog.all_goods.AllGoodsLinerLayout;
import com.dronteam.adm.i_moby.scenarios.catalog.all_goods.AllGoodsPresenter;

/**
 * Created by adm on 12.07.2017.
 */

public class AlbumAdapter extends CommonRecyclerViewAdapter {

    public AlbumAdapter(ViewManager viewManager) {
        super(viewManager);
    }

    @Override
    public ItemPresenter createItemPresenter(int position) {
        ItemPresenter presenter = null;
        Object model = getModelList().get(position);
        if(model.getClass() == AllGoodsPresenter.MODEL.getClass())
            presenter = new AllGoodsPresenter(new AllGoodsLinerLayout(getViewManager().getContext()),getViewManager());
        if(model.getClass() == Item.class)
            presenter = new AlbumPresenter(getViewManager(), (Item)model,new AlbumFragment(getViewManager().getContext()));
        return presenter;
    }
}
