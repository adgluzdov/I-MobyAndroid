package com.dronteam.adm.i_moby.common;

import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by adm on 10.07.2017.
 */

public interface ModelAdapter<Model> {
    void addModel(List<Model> modelList);
    RecyclerView.Adapter getViewAdapter();
}
