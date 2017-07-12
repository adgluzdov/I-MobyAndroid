package com.dronteam.adm.i_moby.common.adapters.base_adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.dronteam.adm.i_moby.common.adapters.ItemPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adm on 21.04.2017.
 */

public class CommonBaseAdapter extends BaseAdapter{
    ArrayList<ItemPresenter> itemPresenterList = new ArrayList<ItemPresenter>();

    public CommonBaseAdapter(final List<ItemPresenter> itemPresenters) {
        itemPresenterList = new ArrayList<ItemPresenter>(){{
            for (ItemPresenter object: itemPresenters) {
                add(object);
            }
        }};
    }

    public CommonBaseAdapter() {

    }

    public void clear(){
        itemPresenterList.clear();
        this.notifyDataSetChanged();
    }

    public void addItemPresenter(int position, ItemPresenter itemPresenter){
        itemPresenterList.add(position,itemPresenter);
        this.notifyDataSetChanged();
    }

    public void addItemPresenters(int position, final List<ItemPresenter> itemPresenters){
        for (ItemPresenter obj :itemPresenters) {
            this.itemPresenterList.add(position,obj);
            position++;
        }
        this.notifyDataSetChanged();
    }
    public void addItemPresenters(final List<ItemPresenter> itemPresenters){
        this.addItemPresenters(itemPresenterList.size(),itemPresenters);
    }

    @Override
    public int getCount() {
        return itemPresenterList.size();
    }

    @Override
    public Object getItem(int i) {
        return itemPresenterList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return itemPresenterList.get(i).getItemId_();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        itemPresenterList.get(i).fill();
        return (View)itemPresenterList.get(i).getView();
    }
}
