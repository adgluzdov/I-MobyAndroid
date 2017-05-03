package com.dronteam.adm.i_moby.scenarios.special_offer;

import android.graphics.Bitmap;
import android.view.View;

/**
 * Created by User on 13.12.2016.
 */

public interface SpecialOfferView {
    void setDiscount(String discount);
    void setBonus(String bonus);
    void setAdditionalInfo(String additionalInfo);

    void setImage(Bitmap image);
    void setImage(int resId);
    void setTitle(String title);
    void setPrice(String price);
    void setEditListener(View.OnClickListener listener);
}
