package com.dronteam.adm.i_moby.scenarios.product;
import android.view.ViewGroup;

import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.common.adapters.ItemPresenter;
import com.dronteam.adm.i_moby.common.adapters.recycler_view_adapter.CommonRecyclerViewAdapter;
import com.dronteam.adm.i_moby.common.progressbar.ProgressbarLinerLayout;
import com.dronteam.adm.i_moby.common.progressbar.ProgressbarPresenter;
import com.dronteam.adm.i_moby.model.album.Item;
import com.dronteam.adm.i_moby.scenarios.catalog.all_goods.AllGoodsLinerLayout;
import com.dronteam.adm.i_moby.scenarios.catalog.all_goods.AllGoodsLinerLayout2;
import com.dronteam.adm.i_moby.scenarios.catalog.all_goods.AllGoodsPresenter;

/**
 * Created by adm on 13.07.2017.
 */

public class ProductAdapter extends CommonRecyclerViewAdapter{

    public ProductAdapter(ViewManager viewManager) {
        super(viewManager);
    }

    @Override
    public ItemPresenter createItemPresenter(int position, ViewGroup parent) {
        ItemPresenter presenter = null;
        Object model = getModelList().get(position);
        if(model.getClass() == String.class)
            presenter = new ProgressbarPresenter(new ProgressbarLinerLayout(getViewManager().getContext()));
        if(model.getClass() == Integer.class)
            presenter = new AllGoodsPresenter(new AllGoodsLinerLayout(getViewManager().getContext()),getViewManager());
        if(model.getClass() == Item.class)
            presenter = new AllGoodsPresenter(new AllGoodsLinerLayout2(getViewManager().getContext()),getViewManager());
        return presenter;
    }
}
