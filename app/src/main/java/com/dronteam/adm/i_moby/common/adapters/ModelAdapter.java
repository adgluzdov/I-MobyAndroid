package com.dronteam.adm.i_moby.common.adapters;

import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by adm on 10.07.2017.
 */

public interface ModelAdapter {
    void addListModel(List modelList);
    void addModel(Object model);
    void removeModel(int position);
    void removeAll();
    int getCount();
    RecyclerView.Adapter getViewAdapter();
}
