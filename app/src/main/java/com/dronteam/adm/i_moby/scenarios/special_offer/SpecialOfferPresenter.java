package com.dronteam.adm.i_moby.scenarios.special_offer;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;

import com.dronteam.adm.i_moby.R;
import com.dronteam.adm.i_moby.UIFactory;
import com.dronteam.adm.i_moby.common.ViewManager;
import com.squareup.picasso.Picasso;

/**
 * Created by User on 13.12.2016.
 */

public class SpecialOfferPresenter {
    private static final String TAG = "My";
    SpecialOffer offer;
    SpecialOfferView view;

    public SpecialOfferPresenter(/*ViewManager viewManager, */SpecialOffer offer, SpecialOfferView view) {
        this.offer = offer;
        this.view = view;
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

    public void fill(){
        view.setAdditionalInfo(offer.getAdditionalInfo());
        view.setDiscount(offer.getDiscount());
        view.setBonus(offer.getBonus());
        if(offer.getImage() != null)
            view.setImage(offer.getImage());
        else {
            view.setImage(R.mipmap.ic_launcher);
            Log.d(TAG, "Can't load image. SpecialOfferPresenter");
        }
    }
}
