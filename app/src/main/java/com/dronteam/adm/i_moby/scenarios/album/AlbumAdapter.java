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
        setStaticItem(1);
    }

    @Override
    public ItemPresenter createItemPresenter(int position, ViewGroup parent) {
        ItemPresenter presenter;
        if(position == getCount()-1)
            presenter = new AllGoodsPresenter(new AllGoodsLinerLayout(getViewManager().getContext()),getViewManager());
        else
            presenter = new AlbumPresenter(getViewManager(),(Item) getModelList().get(position),new AlbumFragment(getViewManager().getContext(),parent));
        return presenter;
    }
}
