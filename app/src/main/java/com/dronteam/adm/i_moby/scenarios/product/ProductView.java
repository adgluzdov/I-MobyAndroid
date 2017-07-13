package com.dronteam.adm.i_moby.scenarios.product;

import android.graphics.Bitmap;
import android.view.View;

import com.dronteam.adm.i_moby.common.adapters.ItemView;
import com.dronteam.adm.i_moby.model.product.Price;

/**
 * Created by adm on 14.11.2016.
 */
public interface ProductView extends ItemView{
    void setImage(Bitmap image);
    void setPlaceHolder(int resId);
    void setTitle(String title);
    void setPrice(Price price);
    void setEditListener(View.OnClickListener listener);
}
