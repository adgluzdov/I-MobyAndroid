package com.dronteam.adm.i_moby.scenarios.detail_information;

import android.graphics.Bitmap;

import com.dronteam.adm.i_moby.common.CommonView;

/**
 * Created by adm on 27.04.2017.
 */

public interface DetailInfoView extends CommonView {
    public void setTitle(String title);
    public void setDescription(String description);
    public void setPrice(String price);
    public void setCategory(String category);
    public void setDate(String date);
    public void setBlankImage();
    public void setImage(Bitmap bitmap);
}
