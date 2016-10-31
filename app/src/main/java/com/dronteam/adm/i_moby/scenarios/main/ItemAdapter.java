package com.dronteam.adm.i_moby.scenarios.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dronteam.adm.i_moby.R;
import com.dronteam.adm.i_moby.model.Item;

import java.util.ArrayList;

/**
 * Created by smb on 18/10/2016.
 */
public class ItemAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Item> itemArrayList;

    ItemAdapter(Context ctx, ArrayList<Item> itemArrayList) {
        this.ctx = ctx;
        this.itemArrayList = itemArrayList;
        lInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return itemArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null)
            view = lInflater.inflate(R.layout.item, parent, false);
        Item item = (Item) getItem(position);
        ((TextView) view.findViewById(R.id.name)).setText(item.getName());
        return view;
    }
}
