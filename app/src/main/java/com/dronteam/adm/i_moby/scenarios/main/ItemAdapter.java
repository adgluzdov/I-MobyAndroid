package com.dronteam.adm.i_moby.scenarios.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dronteam.adm.i_moby.R;
import com.dronteam.adm.i_moby.model.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smb on 18/10/2016.
 */
public class ItemAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    List<Item> itemList;
    List<ItemPresenter> itemPresenterList;
    ItemAdapter(Context ctx, final List<Item> itemList) {
        this.ctx = ctx;
        this.itemList = itemList;
        lInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // Создаём презентёры для каждого Item
        itemPresenterList = new ArrayList<ItemPresenter>(){{
            for(int i=0;i<itemList.size();i++){
                add(new ItemPresenter());
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
        View view = convertView;
        if (view == null)
            view = lInflater.inflate(R.layout.item, parent, false);
        Item item = itemFactory(position);
        ((TextView) view.findViewById(R.id.name)).setText(item.getTitle());
        return view;
    }
    public Item itemFactory(int position) {
        return (Item) getItem(position);
    }
}
