package com.dronteam.adm.i_moby.model.special_offer;

/**
 * Created by adm on 12.07.2017.
 */

public class Tags {
    static String TAG_SALE = "#sale";
    static String TAG_HIT = "#hit";
    boolean sale;
    boolean hit;

    public Tags(boolean sale, boolean hit) {
        this.sale = sale;
        this.hit = hit;
    }
}
