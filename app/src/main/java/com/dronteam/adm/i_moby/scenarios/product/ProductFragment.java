package com.dronteam.adm.i_moby.scenarios.product;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dronteam.adm.i_moby.R;

/**
 * Created by adm on 14.11.2016.
 */
public class ProductFragment extends LinearLayout implements ProductView {

    Context context;

    public ProductFragment(Context context) {
        super(context);
        this.context = context;
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.product, this);
    }

    @Override
    public void setImage(Bitmap image) {
        ((ImageView)findViewById(R.id.image_view)).setImageBitmap(image);
    }

    @Override
    public void setImage(int resId) {
        ((ImageView)findViewById(R.id.image_view)).setImageResource(resId);
    }

    @Override
    public void setTitle(String title) {
        ((TextView)findViewById(R.id.text_view_title)).setText(title);
    }

    @Override
    public void setPrice(String price) {
        ((TextView)findViewById(R.id.text_view_price)).setText(price);
    }

    @Override
    public void setEditListener(View.OnClickListener listener) {
        setOnClickListener(listener);
    }
}
