
package com.dronteam.adm.i_moby.model;

import java.util.ArrayList;
import java.util.List;

public class Response {

    public Integer count;

    public Response(List<Item> items) {
        this.setItems(items);
    }

    public List<Item> items = new ArrayList<Item>();

    public Integer getCount() {
        return count;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
