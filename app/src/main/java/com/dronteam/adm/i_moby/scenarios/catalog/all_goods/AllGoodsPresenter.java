package com.dronteam.adm.i_moby.scenarios.catalog.all_goods;

import android.view.View;

import com.dronteam.adm.i_moby.UIFactory;
import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.common.adapters.ItemPresenter;
import com.dronteam.adm.i_moby.common.adapters.ItemView;
import com.dronteam.adm.i_moby.model.album.Item;

/**
 * Created by adm on 12.07.2017.
 */

public class AllGoodsPresenter implements ItemPresenter {

    AllGoodsView view;
    ViewManager viewManager;
    public AllGoodsPresenter(AllGoodsView view, final ViewManager viewManager) {
        this.view = view;
        this.viewManager = viewManager;
        view.setOnButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewManager.show(UIFactory.GoodsPresenter(viewManager, Item.ALL_GOODS));
            }
        });
    }

    @Override
    public void fill() {

    }

    @Override
    public ItemView getView() {
        return view;
    }

    @Override
    public Object getItem() {
        return null;
    }

    @Override
    public int getItemId_() {
        return 0;
    }
}
