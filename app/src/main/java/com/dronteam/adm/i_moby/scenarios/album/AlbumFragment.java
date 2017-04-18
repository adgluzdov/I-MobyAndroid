package com.dronteam.adm.i_moby.scenarios.album;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dronteam.adm.i_moby.R;

/**
 * Created by adm on 18.04.2017.
 */

public class AlbumFragment extends LinearLayout implements AlbumView {

    public AlbumFragment(Context context) {
        super(context);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.album, this);
    }

    @Override
    public void setImage(Bitmap image) {
        ((ImageView)findViewById(R.id.image)).setImageBitmap(image);
    }

    @Override
    public void setImage(int resId) {
        ((ImageView)findViewById(R.id.image)).setImageResource(resId);
    }

    @Override
    public void setTitle(String title) {
        ((TextView)findViewById(R.id.title)).setText(title);
    }

    @Override
    public void setCount(String count) {
        ((TextView)findViewById(R.id.count)).setText(count);
    }

    @Override
    public void setEditListener(OnClickListener listener) {
        setOnClickListener(listener);
    }
}
