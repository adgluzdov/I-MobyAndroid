package com.dronteam.adm.i_moby.scenarios.special_offer;

import com.dronteam.adm.i_moby.model.Item;

/**
 * Created by User on 13.12.2016.
 */

public class SpecialOffer {
    Item item;

    double discount;
    double bonus;
    String additionalInfo;

    public SpecialOffer(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public String getAdditionalInfo() {
        if (additionalInfo == null)
            additionalInfo = "No additional info";
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}
