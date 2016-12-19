package com.dronteam.adm.i_moby.scenarios.SpecialOffer;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.dronteam.adm.i_moby.R;
import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.scenarios.main.ShowCaseActivity;
import com.squareup.picasso.Picasso;

/**
 * Created by User on 13.12.2016.
 */

public class SpecialOfferPresenter {
    SpecialOffer offer;
    SpecialOfferView view;
    ViewManager viewManager = null;

    public SpecialOfferPresenter(ViewManager viewManager, SpecialOffer offer) {
        this.offer = offer;
        this.viewManager = viewManager;
        view = new SpecialOfferFragment(viewManager.getContext());
        Picasso.with(viewManager.getContext())
                .load(offer.item.getThumb_photo())
                //.placeholder(R.drawable.user_placeholder)
                //.error(R.drawable.user_placeholder_error)
                .into(offer.imageView);
        view.setEditListener(edit());
    }

    private View.OnClickListener edit() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId())
                {
                    case R.id.showcase_content:
                        Intent intent = new Intent(viewManager.getContext(), ShowCaseActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        };
    }

    public void loadImage(ViewManager viewManager, String thumb_photo) {
        Picasso.with(viewManager.getContext())
                .load(thumb_photo)
                //.placeholder(R.drawable.user_placeholder)
                //.error(R.drawable.user_placeholder_error)
                .into(offer.imageView);
    }

}
