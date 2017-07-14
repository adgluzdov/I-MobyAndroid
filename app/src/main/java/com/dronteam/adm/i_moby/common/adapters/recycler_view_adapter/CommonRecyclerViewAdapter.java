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
    private List<Object> modelList = new ArrayList<Object>();
    private int staticItem = 0;

    public void setStaticItem(int staticItem) {
        this.staticItem = staticItem;
    }

    public CommonRecyclerViewAdapter(ViewManager viewManager) {
        this.viewManager = viewManager;
    }


    @Override
    public void addListModel(List modelList) {
        for (Object model : modelList) {
            this.modelList.add(model);
        }
        notifyDataSetChanged();
    }

    @Override
    public void addModel(Object model) {
        modelList.add(model);
        notifyItemInserted(getCount());
    }

    @Override
    public void removeModel(int position) {
        modelList.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public void removeAll() {
        int range = modelList.size();
        modelList.clear();
        this.notifyItemRangeRemoved(0, range);
    }

    @Override
    public RecyclerView.Adapter getViewAdapter() {
        return this;
    }

    @Override
    public int getCount() {
        return getItemCount();
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int position){
        return new CommonViewHolder(createItemPresenter(position,parent));
    }

    @Override
    public void onBindViewHolder(CommonViewHolder holder, int position){
        holder.fill();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public abstract ItemPresenter createItemPresenter(int position, ViewGroup parent);

    @Override
    public int getItemCount() {
        return modelList.size()+staticItem;
    }

    public ViewManager getViewManager() {
        return viewManager;
    }

    public List getModelList() {
        return modelList;
    }
}
