
package com.dronteam.adm.i_moby.model;

import com.dronteam.adm.i_moby.scenarios.special_offer.SpecialOffer;

import java.util.ArrayList;
import java.util.List;

public class Response {

    public Integer count;
    public List<Item> items = new ArrayList<Item>();
    public List<SpecialOffer> specialOffers = new ArrayList<SpecialOffer>();

    public Response(List<Item> items) {
        this.setItems(items);
    }

    public Integer getCount() {
        return count;
    }

    public List<Item> getItems() {
        return items;
    }

    public List<SpecialOffer> getSpecialOffers() {
        return specialOffers;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
