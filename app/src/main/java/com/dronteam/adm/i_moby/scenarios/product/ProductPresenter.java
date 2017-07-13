package com.dronteam.adm.i_moby.scenarios.product;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.dronteam.adm.i_moby.R;
import com.dronteam.adm.i_moby.UIFactory;
import com.dronteam.adm.i_moby.common.adapters.ItemPresenter;
import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.model.product.Item;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

/**
 * Created by adm on 14.11.2016.
 */
public class ProductPresenter implements ItemPresenter {
    ProductView view;
    Item item;
    ViewManager viewManager;
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

    public ProductPresenter(ViewManager viewManager, Item item, ProductView view) {
        this.view = view;
        this.item = item;
        this.viewManager = viewManager;
        this.view.setEditListener(edit());
    }

    private View.OnClickListener edit() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewManager.show(UIFactory.DetailInfoPresenter(viewManager,item));
            }
        };
    }

    @Override
    public void fill(){
        Picasso.with(viewManager.getContext()).load(item.getThumb_photo()).into(target);
        view.setPrice(item.getPrice());
        view.setTitle(item.getTitle());
        if(loadedImage != null)
            view.setImage(loadedImage);
        else
            view.setPlaceHolder(R.mipmap.ic_launcher);
    }

    @Override
    public ProductView getView() {
        return view;
    }

    @Override
    public Item getItem() {
        return item;
    }

    @Override
    public int getItemId_() {
        return item.getId();
    }

}
