package com.dronteam.adm.i_moby.model;

import java.math.BigDecimal;

/**
 * Created by smb on 18/10/2016.
 */

public class Item {
    private String name;
    private BigDecimal price;
    private String description;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
