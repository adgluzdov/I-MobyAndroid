package com.dronteam.adm.i_moby.scenarios.album;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.model.album.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adm on 18.04.2017.
 */

public class AlbumsAdapter extends BaseAdapter {
    List<AlbumPresenter> albumPresenterList = new ArrayList<AlbumPresenter>();


    @Override
    public int getCount() {
        return albumPresenterList.size();
    }

    @Override
    public Object getItem(int position) {
        return albumPresenterList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return albumFactory(position).getId();
    }

    private Item albumFactory(int position) {
        return (Item) getItem(position);
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        albumPresenterList.get(position).fill();
        return (View)albumPresenterList.get(position).getView();
    }
}
