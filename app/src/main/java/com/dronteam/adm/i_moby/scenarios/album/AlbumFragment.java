package com.dronteam.adm.i_moby.scenarios.album;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dronteam.adm.i_moby.R;

/**
 * Created by adm on 18.04.2017.
 */

public class AlbumFragment extends LinearLayout implements AlbumView {

    CardView cardView = null;
    public AlbumFragment(Context context) {
        super(context);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_album, this);
        view.setLayoutParams(new ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
        );
        cardView = (CardView)view.findViewById(R.id.card_view);

    }

    @Override
    public void setImage(Bitmap image) {
        ((ImageView)findViewById(R.id.background_image)).setImageBitmap(image);
    }

    @Override
    public void setErrorImage() {

    }

    @Override
    public void setDefaultImage() {
        ((ImageView)findViewById(R.id.background_image)).setImageResource(R.drawable.img_pre);
    }

    @Override
    public void setPlaceHolder() {
        ((ImageView)findViewById(R.id.background_image)).setImageResource(R.drawable.img_pre);
    }

    @Override
    public void setTitle(String title) {
        ((TextView)findViewById(R.id.title)).setText(title);
    }

    @Override
    public void setCount(String count) {
    }

    @Override
    public void setOnItemViewClickListener(OnClickListener listener) {
        cardView.setOnClickListener(listener);
    }

    @Override
    public View getView() {
        return this;
    }
}
