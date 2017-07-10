package com.dronteam.adm.i_moby.common.adapters.recycler_view_adapter;

import android.support.v7.widget.RecyclerView;

import com.dronteam.adm.i_moby.common.adapters.ItemView;

/**
 * Created by adm on 10.07.2017.
 */

public class CommonViewHolder<View extends ItemView> extends RecyclerView.ViewHolder {
    private View view;

    public CommonViewHolder(View view) {
        super(view.getView());
        this.view = view;
    }

    public View getView(){
        return view;
    }
}
