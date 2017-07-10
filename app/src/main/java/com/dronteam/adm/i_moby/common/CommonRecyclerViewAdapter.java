package com.dronteam.adm.i_moby.common;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adm on 10.07.2017.
 */

public abstract class CommonRecyclerViewAdapter<Model,View extends ItemView,Presenter extends ItemPresenter> extends RecyclerView.Adapter<CommonViewHolder<View>> implements ModelAdapter<Model>{


    private final ViewManager viewManager;
    private List<Model> modelList = new ArrayList<Model>();
    private List<Presenter> presenterList = new ArrayList<Presenter>();

    public CommonRecyclerViewAdapter(ViewManager viewManager) {
        this.viewManager = viewManager;
    }

    @Override
    public void addModel(List<Model> modelList) {
        for (Model model : modelList) {
            this.modelList.add(model);
        }
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.Adapter getViewAdapter() {
        return this;
    }

    @Override
    public CommonViewHolder<View> onCreateViewHolder(ViewGroup parent, int viewType){
        View view = createView();
        return new CommonViewHolder<View>(view);
    }

    @Override
    public void onBindViewHolder(CommonViewHolder<View> holder, int position){
        if(position < presenterList.size())
            if(getPresenterList().get(position) != null){
                Presenter presenter = getPresenterList().get(position);
                presenter.fill();
                return;
            }
        View view = holder.getView();
        Presenter presenter = createPresenter(getModelList().get(position),holder.getView());
        addPresenter(presenter);
        presenter.fill();
    }

    public abstract Presenter createPresenter(Model model,View view);

    public abstract View createView();

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public ViewManager getViewManager() {
        return viewManager;
    }

    public List<Model> getModelList() {
        return modelList;
    }

    public List<Presenter> getPresenterList() {
        return presenterList;
    }

    public void addPresenter(Presenter presenter) {
        this.presenterList.add(presenter);
    }
}
