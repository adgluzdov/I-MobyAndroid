package com.dronteam.adm.i_moby.scenarios.SpecialOffer;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.dronteam.adm.i_moby.model.Item;

/**
 * Created by User on 13.12.2016.
 */

public class SpecialOffer {
    Item item;

    double discount;
    double bonuse;
    String additionalInfo;

    ImageView imageView;

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

    public double getBonuse() {
        return bonuse;
    }

    public void setBonuse(double bonuse) {
        this.bonuse = bonuse;
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
