package com.dronteam.adm.i_moby.scenarios.album;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.dronteam.adm.i_moby.R;
import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.model.album.Item;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

/**
 * Created by adm on 18.04.2017.
 */

public class AlbumPresenter {
    private AlbumView view;
    private Item item;
    private Bitmap loadedImage = null;
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

    public AlbumPresenter(ViewManager viewManager, Item item, AlbumFragment albumFragment) {
        this.item = item;
        this.view = albumFragment;
        Picasso.with(viewManager.getContext()).load(item.getPhoto().getPhoto_807()).into(target);
    }

    public void fill() {
        view.setCount(String.valueOf(item.getCount()));
        view.setTitle(item.getTitle());
        if(loadedImage != null)
            view.setImage(loadedImage);
        else
            view.setImage(R.mipmap.ic_launcher);
    }

    public AlbumView getView() {
        return view;
    }

}
