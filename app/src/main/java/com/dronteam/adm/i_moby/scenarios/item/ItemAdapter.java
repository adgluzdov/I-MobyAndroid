package com.dronteam.adm.i_moby.scenarios.item;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.model.item.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smb on 18/10/2016.
 */
public class ItemAdapter extends BaseAdapter {
    private ViewManager viewManager;
    List<Item> itemList;
    List<ItemPresenter> itemPresenterList = new ArrayList<ItemPresenter>();

    ItemAdapter(ViewManager viewManager, final List<Item> itemList) {
        this.viewManager = viewManager;
        this.itemList = itemList;
        itemPresenterList = new ArrayList<ItemPresenter>(){{
            for(int i=0;i<itemList.size();i++){
                add(new ItemPresenter(ItemAdapter.this.viewManager,itemList.get(i)));
            }
        }};

    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return itemFactory(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        itemPresenterList.get(position).fill();
        return (View)itemPresenterList.get(position).view;
    }
    public Item itemFactory(int position) {
        return (Item) getItem(position);
    }
}
