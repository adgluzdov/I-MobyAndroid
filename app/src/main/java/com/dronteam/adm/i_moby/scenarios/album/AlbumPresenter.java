package com.dronteam.adm.i_moby.scenarios.album;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;

import com.dronteam.adm.i_moby.R;
import com.dronteam.adm.i_moby.UIFactory;
import com.dronteam.adm.i_moby.common.adapters.ItemPresenter;
import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.model.album.Item;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import static com.dronteam.adm.i_moby.model.special_offer.SpecialOffer.TAG;

/**
 * Created by adm on 18.04.2017.
 */

public class AlbumPresenter implements ItemPresenter{

    private static final int IMAGE_TYPE_FAILED = -2;
    private static final int IMAGE_TYPE_DEFAULT = -1;
    private static final int IMAGE_TYPE_PLACE_HOLDER = 0;
    private static final int IMAGE_TYPE_LOAD = 1;

    private int typeImage = IMAGE_TYPE_PLACE_HOLDER;

    private AlbumView view;
    private Item item;
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

    public AlbumPresenter(final ViewManager viewManager, final Item item, AlbumView aLbumView) {
        this.item = item;
        this.view = aLbumView;
        this.viewManager = viewManager;
        this.view.setOnItemViewClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewManager.show(UIFactory.GoodsPresenter(viewManager,item));
            }
        });
        if(item.getPhoto() != null)
            Picasso.with(viewManager.getContext()).load(item.getPhoto().getPhoto_604()).into(target);
        else
            typeImage = IMAGE_TYPE_DEFAULT;
    }

    @Override
    public void fill() {
        view.setCount(String.valueOf(item.getCount()));
        view.setTitle(item.getTitle());
        switch (typeImage) {
            case IMAGE_TYPE_FAILED:
                view.setErrorImage();
                break;
            case IMAGE_TYPE_DEFAULT:
                view.setDefaultImage();
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
    public AlbumView getView() {
        return view;
    }

    @Override
    public Object getItem() {
        return item;
    }
}
