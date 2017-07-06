package com.dronteam.adm.i_moby.scenarios.product;

import android.graphics.Bitmap;
import android.view.View;

/**
 * Created by adm on 14.11.2016.
 */
public interface ProductView {
    void setImage(Bitmap image);
    void setImage(int resId);
    void setTitle(String title);
    void setPrice(String price);

    void setEditListener(View.OnClickListener listener);
}
