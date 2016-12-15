package com.dronteam.adm.i_moby.scenarios.SpecialOffer;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.dronteam.adm.i_moby.R;
import com.dronteam.adm.i_moby.common.ViewManager;
import com.squareup.picasso.Picasso;

/**
 * Created by User on 13.12.2016.
 */

public class SpecialOfferPresenter implements SpecialOfferView{


    SpecialOffer offer;

    public SpecialOfferPresenter(ViewManager viewManager, SpecialOffer offer) {
        this.offer = offer;
        Picasso.with(viewManager.getContext())
                .load(offer.item.getThumb_photo())
                .placeholder(R.drawable.user_placeholder)
                .error(R.drawable.user_placeholder_error)
                .into(offer.imageView);
    }


    @Override
    public void setDiscount(double discount) {
        offer.setDiscount(discount);
    }

    @Override
    public void setBonus(double bonus) {
        offer.setBonuse(bonus);
    }

    @Override
    public void setAdditionalInfo(String additionalInfo) {
        offer.setAdditionalInfo(additionalInfo);
    }

    @Override
    public void setImage(Bitmap image) {
        offer.imageView.setImageBitmap(image);
    }

    public void loadImage(ViewManager viewManager, String thumb_photo) {
        Picasso.with(viewManager.getContext())
                .load(thumb_photo)
                .placeholder(R.drawable.user_placeholder)
                .error(R.drawable.user_placeholder_error)
                .into(offer.imageView);
    }

}
