package com.dronteam.adm.i_moby.scenarios.special_offer;

import android.graphics.Bitmap;
import android.view.View;

import com.dronteam.adm.i_moby.R;
import com.dronteam.adm.i_moby.UIFactory;
import com.dronteam.adm.i_moby.common.ViewManager;

/**
 * Created by User on 13.12.2016.
 */

public class SpecialOfferPresenter {
    SpecialOffer offer;
    SpecialOfferView view;
    ViewManager viewManager = null;

    Bitmap loadedImage = null;

    public SpecialOfferPresenter(ViewManager viewManager, SpecialOffer offer) {
        this.offer = offer;
        this.viewManager = viewManager;
        view = new SpecialOfferFragment(viewManager.getContext());
        /*
        Picasso.with(viewManager.getContext())
                .load(offer.item.getThumb_photo())
                //.placeholder(R.drawable.user_placeholder)
                //.error(R.drawable.user_placeholder_error)
                .into(loadedImage);
        view.setEditListener(edit());
        */
    }


    public void setDiscount(double discount){
        view.setDiscount(discount);
    }
    public void setBonus(double bonus) {
        view.setBonus(bonus);
    }
    public void setAdditionalInfo(String additionalInfo){
        view.setAdditionalInfo(additionalInfo);
    }


    public SpecialOfferView getView() {
        return view;
    }

    private View.OnClickListener edit() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                switch (v.getId())
                {
                    case R.id.showcase_content:
                        viewManager.show(UIFactory.DetailInfo(viewManager));
                    break;
                }
                */
            }
        };
    }
/*
    public void loadImage(ViewManager viewManager, String thumb_photo) {
        Picasso.with(viewManager.getContext())
                .load(thumb_photo)
                //.placeholder(R.drawable.user_placeholder)
                //.error(R.drawable.user_placeholder_error)
                .into(offer.imageView);
    }
*/
    public void fill(){
        //view.setText(item.getTitle(), item.description, item.price.text);
        view.setAdditionalInfo(offer.getAdditionalInfo());
        view.setDiscount(offer.getDiscount());
        view.setBonus(offer.getBonus());
        if(loadedImage != null)
            view.setImage(loadedImage);
        else
            view.setImage(R.mipmap.ic_launcher);
    }
}
