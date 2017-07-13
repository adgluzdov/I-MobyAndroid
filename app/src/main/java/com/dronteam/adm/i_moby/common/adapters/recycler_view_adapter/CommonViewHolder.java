package com.dronteam.adm.i_moby.common.adapters.recycler_view_adapter;

import android.support.v7.widget.RecyclerView;

import com.dronteam.adm.i_moby.common.adapters.ItemPresenter;
import com.dronteam.adm.i_moby.common.adapters.ItemView;

/**
 * Created by adm on 10.07.2017.
 */

public class CommonViewHolder extends RecyclerView.ViewHolder {
    private ItemPresenter itemPresenter;

    public CommonViewHolder(ItemPresenter itemPresenter) {
        super(itemPresenter.getView().getView());
        this.itemPresenter = itemPresenter;
    }

    public void fill(){
        itemPresenter.fill();
    }
}
