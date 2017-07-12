package com.dronteam.adm.i_moby.common.adapters.recycler_view_adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.common.adapters.ItemPresenter;
import com.dronteam.adm.i_moby.common.adapters.ItemView;
import com.dronteam.adm.i_moby.common.adapters.ModelAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adm on 10.07.2017.
 */

public abstract class CommonRecyclerViewAdapter extends RecyclerView.Adapter<CommonViewHolder> implements ModelAdapter {


    private final ViewManager viewManager;
    private List<ItemPresenter> presenterList = new ArrayList<ItemPresenter>();
    private List<Object> modelList = new ArrayList<Object>();

    public CommonRecyclerViewAdapter(ViewManager viewManager) {
        this.viewManager = viewManager;
    }

    @Override
    public void addModel(List modelList) {
        for (Object model : modelList) {
            this.modelList.add(model);
        }
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.Adapter getViewAdapter() {
        return this;
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        ItemPresenter presenter = createItemPresenter();
        presenterList.add(presenter);
        return new CommonViewHolder(presenter);
    }

    @Override
    public void onBindViewHolder(CommonViewHolder holder, int position){
        holder.fill(modelList.get(position));
    }

    public abstract ItemPresenter createItemPresenter();

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public ViewManager getViewManager() {
        return viewManager;
    }

    public List getModelList() {
        return modelList;
    }

    public List getPresenterList() {
        return presenterList;
    }

    public void addPresenter(ItemPresenter presenter) {
        this.presenterList.add(presenter);
    }
}
