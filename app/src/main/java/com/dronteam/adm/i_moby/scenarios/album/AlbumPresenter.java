package com.dronteam.adm.i_moby.scenarios.album;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.dronteam.adm.i_moby.R;
import com.dronteam.adm.i_moby.UIFactory;
import com.dronteam.adm.i_moby.common.adapters.ItemPresenter;
import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.model.album.Item;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

/**
 * Created by adm on 18.04.2017.
 */

public class AlbumPresenter implements ItemPresenter, View.OnClickListener {
    private AlbumView view;
    private Item item;
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

    public AlbumPresenter(ViewManager viewManager, Item item, AlbumView aLbumView) {
        this.item = item;
        this.view = aLbumView;
        this.viewManager = viewManager;
        this.view.setEditListener(this);
    }

    @Override
    public void fill() {
        Picasso.with(viewManager.getContext()).load(item.getPhoto().getPhoto_807()).into(target);
        view.setCount(String.valueOf(item.getCount()));
        view.setTitle(item.getTitle());
        if(loadedImage != null)
            view.setImage(loadedImage);
        else
            view.setImage(R.mipmap.ic_launcher);
    }

    @Override
    public AlbumView getView() {
        return view;
    }

    @Override
    public void onClick(View view) {
        viewManager.show(UIFactory.GoodsPresenter(viewManager,item));
    }
}
