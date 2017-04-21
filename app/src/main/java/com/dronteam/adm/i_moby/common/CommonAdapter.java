package com.dronteam.adm.i_moby.common;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adm on 21.04.2017.
 */

public class CommonAdapter extends BaseAdapter{
    ArrayList<ItemPresenter> itemPresenterList = new ArrayList<ItemPresenter>();

    public CommonAdapter(final List<ItemPresenter> itemPresenters) {
        itemPresenterList = new ArrayList<ItemPresenter>(){{
            for (ItemPresenter object: itemPresenters) {
                add(object);
            }
        }};
    }

    public CommonAdapter() {

    }

    public void addItemPresenter(int position, ItemPresenter itemPresenter){
        itemPresenterList.add(position,itemPresenter);
        this.notifyDataSetChanged();
    }

    public void addItemPresenters(int position, final List<ItemPresenter> itemPresenters){
        for (ItemPresenter obj :
                itemPresenters) {
            this.itemPresenterList.add(position,obj);
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
        return itemPresenterList.get(i).getItemId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        itemPresenterList.get(i).fill();
        return (View)itemPresenterList.get(i).getView();
    }
}
