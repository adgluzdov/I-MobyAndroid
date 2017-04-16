package com.dronteam.adm.i_moby.scenarios.special_offer;

import android.graphics.Bitmap;

import com.dronteam.adm.i_moby.model.Category;
import com.dronteam.adm.i_moby.model.Item;
import com.dronteam.adm.i_moby.model.Price;

/**
 * Created by User on 13.12.2016.
 */
// Todo: Необходимо доработать parseStr(). Продумать ключевые слова для поиска discount, bonus, additionalInfo.

public class SpecialOffer {

    private String discount;
    private String bonus;
    private String additionalInfo;
    private Item item;


    public SpecialOffer(Item item) {
        this.item = item;
        String description = item.getDescription();
        this.setDiscount(parseStr(description,"Скидка: ","%"));
        this.setBonus(parseStr(description,"Бонус: ","!"));
        this.setAdditionalInfo(parseStr(description,"Дополнительная информация: ","!"));
    }

    private String parseStr(String str,String start,String end){
        String string = "";
        int startindex = str.indexOf(start)+start.length();
        int endindex = str.indexOf(end,startindex-1);
        if(endindex>0)
            string = str.substring(startindex, endindex);
        return string;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
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
    public Item getItem() {
        return item;
    }

}
