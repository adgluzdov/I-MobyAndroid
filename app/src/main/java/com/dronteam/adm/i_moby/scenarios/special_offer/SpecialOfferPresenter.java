package com.dronteam.adm.i_moby.scenarios.special_offer;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.dronteam.adm.i_moby.R;
import com.dronteam.adm.i_moby.UIFactory;
import com.dronteam.adm.i_moby.common.adapters.ItemPresenter;
import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.model.special_offer.SpecialOffer;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

/**
 * Created by User on 13.12.2016.
 */

public class SpecialOfferPresenter implements ItemPresenter {

    private static final int IMAGE_TYPE_FAILED = -2;
    private static final int IMAGE_TYPE_DEFAULT = -1;
    private static final int IMAGE_TYPE_PLACE_HOLDER = 0;
    private static final int IMAGE_TYPE_LOAD = 1;

    private int typeImage = IMAGE_TYPE_PLACE_HOLDER;

    SpecialOffer offer;
    SpecialOfferView view;
    private Bitmap loadedImage = null;
    private ViewManager viewManager;
    final Target target = new Target(){
        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
            typeImage = IMAGE_TYPE_LOAD;
            loadedImage = bitmap;
            view.setImage(loadedImage);
        }

        @Override
        public void onBitmapFailed(Drawable errorDrawable) {
            typeImage = IMAGE_TYPE_FAILED;
            view.setErrorImage();
        }

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {
        }
    };

    public SpecialOfferPresenter(final ViewManager viewManager, final SpecialOffer offer, SpecialOfferView view) {
        this.offer = offer;
        this.view = view;
        this.viewManager = viewManager;
        this.view.setOnItemViewClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewManager.show(UIFactory.DetailInfoPresenter(viewManager,offer.getItem()));
            }
        });
        Picasso.with(viewManager.getContext()).load(offer.getItem().getThumb_photo()).into(target);
    }

    @Override
    public void fill(){
        view.setTitle(offer.getItem().getTitle());
        view.setPrice(offer.getItem().getPrice());
        view.setTags(offer.getTags());
        switch (typeImage) {
            case IMAGE_TYPE_FAILED:
                view.setErrorImage();
                break;
            case IMAGE_TYPE_PLACE_HOLDER:
                view.setPlaceHolder();
                break;
            case IMAGE_TYPE_LOAD:
                view.setImage(loadedImage);
                break;
        }
    }

    @Override
    public SpecialOfferView getView() {
        return view;
    }

    @Override
    public Object getItem() {
        return offer;
    }

}
