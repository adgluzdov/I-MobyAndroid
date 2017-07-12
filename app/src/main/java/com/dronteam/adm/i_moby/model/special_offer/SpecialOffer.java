package com.dronteam.adm.i_moby.model.special_offer;

import com.dronteam.adm.i_moby.model.product.Item;

/**
 * Created by User on 13.12.2016.
 */
// Todo: Необходимо доработать parseStr(). Продумать ключевые слова для поиска discount, bonus, additionalInfo.

public class SpecialOffer {

    private Tags tags;
    private Item item;


    public SpecialOffer(Item item) {
        this.item = item;
        String description = item.getDescription();
        this.tags = new Tags(description.contains(Tags.TAG_SALE),description.contains(Tags.TAG_HIT));
    }

    public Item getItem() {
        return item;
    }

    public Tags getTags() {
        return tags;
    }
}
