package com.dronteam.adm.i_moby.model.special_offer;

/**
 * Created by adm on 12.07.2017.
 */

public class Tags {
    public static String TAG_SALE = "#sale";
    public static String TAG_HIT = "#hit";
    boolean sale;
    boolean hit;

    public Tags(boolean sale, boolean hit) {
        this.sale = sale;
        this.hit = hit;
    }

    public boolean isSale() {
        return sale;
    }

    public boolean isHit() {
        return hit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tags tags = (Tags) o;

        if (sale != tags.sale) return false;
        return hit == tags.hit;

    }

    @Override
    public int hashCode() {
        int result = (sale ? 1 : 0);
        result = 31 * result + (hit ? 1 : 0);
        return result;
    }
}
