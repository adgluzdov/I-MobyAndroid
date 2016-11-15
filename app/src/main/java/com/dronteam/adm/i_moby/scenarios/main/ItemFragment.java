package com.dronteam.adm.i_moby.scenarios.main;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dronteam.adm.i_moby.R;

/**
 * Created by adm on 14.11.2016.
 */
public class ItemFragment extends LinearLayout implements ItemView{

    public ItemFragment(Context context) {
        super(context);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.item, this);
    }


    @Override
    public void setImage(ImageView imageView) {

    }

    @Override
    public void setText(String title) {
        ((TextView)findViewById(R.id.name)).setText(title);
    }

    @Override
    public void setEditListener(View.OnClickListener listener) {
        setOnClickListener(listener);
    }
}
