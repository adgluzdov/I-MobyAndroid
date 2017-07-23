package com.dronteam.adm.i_moby.scenarios.detail_information;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;

import com.dronteam.adm.i_moby.common.CommonView;
import com.dronteam.adm.i_moby.common.fragment.with_toolbar.ViewWithToolbar;
import com.dronteam.adm.i_moby.model.product.Category;
import com.dronteam.adm.i_moby.model.product.Price;

/**
 * Created by adm on 27.04.2017.
 */

public interface DetailInfoView extends CommonView,ViewWithToolbar {
    void setImage(Bitmap image);
    void setPlaceHolder(int resId);
    void setTitle(String title);
    void setCategoty(Category category);
    void setDescription(String description);
    void setDate(Integer date);
    void setPrice(Price price);

    void setEditListener(View.OnClickListener listener);
    void informingMessageIsSent();
    void informingMessageIsNotSent();
    void informingMessageAlreadySent();
}
