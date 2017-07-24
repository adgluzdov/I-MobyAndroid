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
    private AlbumView view;
    private Item item;
    private Bitmap loadedImage = null;
    private ViewManager viewManager;
    private boolean noPhoto = false;
    final Target target = new Target(){
        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
            loadedImage = bitmap;
            view.setImage(loadedImage);
        }

        @Override
        public void onBitmapFailed(Drawable errorDrawable) {
            Log.d(TAG, "onBitmapFailed: ");
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
            Picasso.with(viewManager.getContext()).load(item.getPhoto().getPhoto_807()).into(target);
        else {
            noPhoto = true;
        }
    }

    @Override
    public void fill() {
        view.setCount(String.valueOf(item.getCount()));
        view.setTitle(item.getTitle());
        if(noPhoto){
            view.setDefaultImage();
        } else {
            if(loadedImage != null)
                view.setImage(loadedImage);
            else
                view.setPlaceHolder();
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
