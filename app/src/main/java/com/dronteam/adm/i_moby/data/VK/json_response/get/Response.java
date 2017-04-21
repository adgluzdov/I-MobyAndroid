
package com.dronteam.adm.i_moby.data.VK.json_response.get;

import com.dronteam.adm.i_moby.model.product.Item;

import java.util.ArrayList;
import java.util.List;

public class Response {

    public Integer count;
    public List<Item> items = new ArrayList<Item>();

    public Response(List<Item> items) {
        this.setItems(items);
    }

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
