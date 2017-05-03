package com.dronteam.adm.i_moby.scenarios.detail_information;

import android.graphics.Bitmap;
import android.view.View;

import com.dronteam.adm.i_moby.common.CommonView;

/**
 * Created by adm on 27.04.2017.
 */

public interface DetailInfoView extends CommonView {
    void setTitle(String title);
    void setDescription(String description);
    void setPrice(String price);
    void setCategorySection(String categorySection);
    void setCategoryName(String categoryName);
    void setDate(String date);
    void setBlankImage();
    void setImage(Bitmap bitmap);
    void setEditListener(View.OnClickListener listener);
}
