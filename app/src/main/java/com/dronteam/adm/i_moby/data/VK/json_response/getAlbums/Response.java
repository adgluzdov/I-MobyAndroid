package com.dronteam.adm.i_moby.data.VK.json_response.getAlbums;

import com.dronteam.adm.i_moby.model.album.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adm on 17.04.2017.
 */
public class Response {
    public Integer count;
    public List<Item> items = new ArrayList<Item>();

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Response(Integer count, List<Item> items) {

        this.count = count;
        this.items = items;
    }



}
