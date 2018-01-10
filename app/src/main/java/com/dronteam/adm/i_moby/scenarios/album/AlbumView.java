package com.dronteam.adm.i_moby.scenarios.album;

import android.graphics.Bitmap;
import android.view.View;

import com.dronteam.adm.i_moby.common.adapters.ItemView;

/**
 * Created by adm on 18.04.2017.
 */

public interface AlbumView extends ItemView {
    void setImage(Bitmap image);
    void setErrorImage();
    void setDefaultImage();
    void setPlaceHolder();
    void setTitle(String title);
    void setCount(String count);

    void setOnItemViewClickListener(View.OnClickListener listener);
}
