package com.dronteam.adm.i_moby.scenarios.main;

import android.view.View;
import android.widget.ImageView;

/**
 * Created by adm on 14.11.2016.
 */
public interface ItemView {
    public void setImage(ImageView imageView);
    public void setText(String title);
    void setEditListener(View.OnClickListener listener);
}
