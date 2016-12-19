package com.dronteam.adm.i_moby.scenarios.SpecialOffer;

import android.graphics.Bitmap;
import android.view.View;

/**
 * Created by User on 13.12.2016.
 */

public interface SpecialOfferView {
    void setDiscount(double discount);
    void setBonus(double bonus);
    void setAdditionalInfo(String additionalInfo);

    void setImage(Bitmap image);

    void setEditListener(View.OnClickListener listener);
}
