package com.dronteam.adm.i_moby.scenarios.album;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.dronteam.adm.i_moby.R;

/**
 * Created by adm on 18.04.2017.
 */

public class AlbumFragment extends LinearLayout implements AlbumView {

    public AlbumFragment(Context context) {
        super(context);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.ll_special_offer, this);
    }

    @Override
    public void setImage(Bitmap loadedImage) {

    }

    @Override
    public void setImage(int resId) {

    }
}
