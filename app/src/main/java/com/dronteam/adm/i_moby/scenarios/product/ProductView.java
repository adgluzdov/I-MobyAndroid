package com.dronteam.adm.i_moby.scenarios.product;

import android.graphics.Bitmap;
import android.view.View;

import com.dronteam.adm.i_moby.common.adapters.ItemView;

/**
 * Created by adm on 14.11.2016.
 */
public interface ProductView extends ItemView{
    void setImage(Bitmap image);
    void setImage(int resId);
    void setTitle(String title);
    void setPrice(String price);

    void setEditListener(View.OnClickListener listener);
}
