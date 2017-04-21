package com.dronteam.adm.i_moby.scenarios.product;

import android.graphics.Bitmap;
import android.view.View;

/**
 * Created by adm on 14.11.2016.
 */
public interface ProductView {
    public void setImage(Bitmap image);
    public void setImage(int resId);
    public void setText(String title, String description, String price);
    void setEditListener(View.OnClickListener listener);
}
