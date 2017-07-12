package com.dronteam.adm.i_moby.common.adapters;

import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by adm on 10.07.2017.
 */

public interface ModelAdapter {
    void addModel(List modelList);
    RecyclerView.Adapter getViewAdapter();
}
