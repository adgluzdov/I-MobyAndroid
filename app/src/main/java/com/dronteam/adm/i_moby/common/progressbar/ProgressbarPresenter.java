package com.dronteam.adm.i_moby.common.progressbar;

import com.dronteam.adm.i_moby.common.adapters.ItemPresenter;
import com.dronteam.adm.i_moby.common.adapters.ItemView;

/**
 * Created by adm on 14.07.2017.
 */

public class ProgressbarPresenter implements ItemPresenter {
    ItemView itemView;
    public ProgressbarPresenter(ItemView itemView) {
        this.itemView = itemView;
    }

    @Override
    public void fill() {

    }

    @Override
    public ItemView getView() {
        return itemView;
    }
}
