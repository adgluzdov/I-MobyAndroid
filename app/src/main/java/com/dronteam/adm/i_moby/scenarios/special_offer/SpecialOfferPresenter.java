package com.dronteam.adm.i_moby.scenarios.special_offer;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.dronteam.adm.i_moby.R;
import com.dronteam.adm.i_moby.UIFactory;
import com.dronteam.adm.i_moby.common.ItemPresenter;
import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.model.special_offer.SpecialOffer;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

/**
 * Created by User on 13.12.2016.
 */

public class SpecialOfferPresenter implements ItemPresenter {
    private static final String TAG = "My";
    SpecialOffer offer;
    SpecialOfferView view;
    private Bitmap loadedImage = null;
    private ViewManager viewManager;
    final Target target = new Target(){
        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
            loadedImage = bitmap;
            view.setImage(loadedImage);
        }

        @Override
        public void onBitmapFailed(Drawable errorDrawable) {
        }

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {
        }
    };

    public SpecialOfferPresenter(ViewManager viewManager, SpecialOffer offer, SpecialOfferView view) {
        this.offer = offer;
        this.view = view;
        this.viewManager = viewManager;
        Picasso.with(viewManager.getContext()).load(offer.getItem().getThumb_photo()).into(target);
        view.setEditListener(edit());
    }
    @Override
    public SpecialOfferView getView() {
        return view;
    }

    @Override
    public Object getItem() {
        return offer;
    }

    @Override
    public int getItemId() {
        return offer.getItem().getId();
    }

    private View.OnClickListener edit() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewManager.show(UIFactory.DetailInfoPresenter(viewManager,offer.getItem()));
            }
        };
    }
    @Override
    public void fill(){
        view.setAdditionalInfo(offer.getAdditionalInfo());
        view.setDiscount(offer.getDiscount());
        view.setBonus(offer.getBonus());
        if(loadedImage != null)
            view.setImage(loadedImage);
        else
            view.setImage(R.mipmap.ic_launcher);
    }
}
