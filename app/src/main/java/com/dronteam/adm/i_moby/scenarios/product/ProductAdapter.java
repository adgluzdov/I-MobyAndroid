package com.dronteam.adm.i_moby.scenarios.product;
import android.view.ViewGroup;

import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.common.adapters.ItemPresenter;
import com.dronteam.adm.i_moby.common.adapters.recycler_view_adapter.CommonRecyclerViewAdapter;
import com.dronteam.adm.i_moby.model.product.Item;
import com.dronteam.adm.i_moby.scenarios.catalog.all_goods.AllGoodsLinerLayout;
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
        Object model = getModelList().get(position);
        ItemPresenter presenter = null;
        if(model.getClass() == Item.class)
            presenter = new ProductPresenter(getViewManager(),(Item) getModelList().get(position),new ProductFragment(getViewManager().getContext()));
        return presenter;
    }
}