package com.dronteam.adm.i_moby.common.adapters.recycler_view_adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.common.adapters.ItemPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adm on 10.07.2017.
 */

public abstract class CommonRecyclerViewAdapter extends RecyclerView.Adapter<CommonViewHolder> {


    private final ViewManager viewManager;
    private List<Object> modelList = new ArrayList<Object>();
    public CommonRecyclerViewAdapter(ViewManager viewManager) {
        this.viewManager = viewManager;
    }

    OnLoadMoreListener loadMoreListener = null;
    boolean isLoading = false, isMoreDataAvailable = true;

    public void addListModel(List modelList) {
        int startPosition = getCount();
        for (Object model : modelList) {
            this.modelList.add(model);
        }
        notifyItemRangeInserted(startPosition,modelList.size());
    }

    public void addModel(Object model, int position) {
        modelList.add(position,model);
        notifyItemInserted(position);
    }

    public void removeModel(int position) {
        modelList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,getCount());
    }

    public int getCount() {
        return getItemCount();
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int position){
        ItemPresenter itemPresenter = createItemPresenter(position);
        return new CommonViewHolder(itemPresenter);
    }

    @Override
    public void onBindViewHolder(CommonViewHolder holder, int position){
        if(position>=getItemCount()-1 && isMoreDataAvailable && !isLoading && loadMoreListener!=null){
            isLoading = true;
            loadMoreListener.onLoadMore();
        }
        holder.fill();
    }

    public void setMoreDataAvailable(boolean moreDataAvailable) {
        isMoreDataAvailable = moreDataAvailable;
    }

    public interface OnLoadMoreListener{
        void onLoadMore();
    }

    public void setLoadMoreListener(OnLoadMoreListener loadMoreListener) {
        this.loadMoreListener = loadMoreListener;
    }

    public void setLoading(boolean loading) {
        isLoading = loading;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public abstract ItemPresenter createItemPresenter(int position);

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    @Override
    public void onViewAttachedToWindow(CommonViewHolder holder) {
        int position = holder.getAdapterPosition();
        View view = holder.getItemPresenter().getView().getView();
        Object model = holder.getItemPresenter().getItem();
        if(position > modelList.size()-1)
            ((ViewGroup) view.getParent()).removeView(view);
        else
            if(model != modelList.get(position))
                ((ViewGroup) view.getParent()).removeView(view);

        super.onViewAttachedToWindow(holder);
    }

    public ViewManager getViewManager() {
        return viewManager;
    }

    public List getModelList() {
        return modelList;
    }


}
