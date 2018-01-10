package com.dronteam.adm.i_moby.model.special_offer;

import com.dronteam.adm.i_moby.model.product.Item;

/**
 * Created by User on 13.12.2016.
 */
// Todo: Необходимо доработать parseStr(). Продумать ключевые слова для поиска discount, bonus, additionalInfo.

public class SpecialOffer {

    public static String TAG = "#special";
    private Tags tags;
    private Item item;


    public SpecialOffer(Item item) {
        this.item = item;
        String description = item.getDescription();
        this.tags = new Tags(description.contains(Tags.TAG_SALE),description.contains(Tags.TAG_HIT));
        description = description
                .replace(TAG+"\n","")
                .replace(TAG,"")
                .replace(Tags.TAG_SALE+"\n","")
                .replace(Tags.TAG_SALE,"")
                .replace(Tags.TAG_HIT+"\n","")
                .replace(Tags.TAG_HIT,"");
        item.setDescription(description);
    }

    public Item getItem() {
        return item;
    }

    public Tags getTags() {
        return tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpecialOffer that = (SpecialOffer) o;

        if (tags != null ? !tags.equals(that.tags) : that.tags != null) return false;
        return item != null ? item.equals(that.item) : that.item == null;

    }

    @Override
    public int hashCode() {
        int result = tags != null ? tags.hashCode() : 0;
        result = 31 * result + (item != null ? item.hashCode() : 0);
        return result;
    }
}
