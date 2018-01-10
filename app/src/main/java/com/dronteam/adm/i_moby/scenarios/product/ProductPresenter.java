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

    private static final int IMAGE_TYPE_FAILED = -2;
    private static final int IMAGE_TYPE_PLACE_HOLDER = 0;
    private static final int IMAGE_TYPE_LOAD = 1;

    private int typeImage = IMAGE_TYPE_PLACE_HOLDER;

    ProductView view;
    Item item;
    ViewManager viewManager;
    private Bitmap loadedImage = null;
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

    public ProductPresenter(final ViewManager viewManager, final Item item, ProductView view) {
        this.view = view;
        this.item = item;
        this.viewManager = viewManager;
        this.view.setOnItemViewClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewManager.show(UIFactory.DetailInfoPresenter(viewManager,item));
            }
        });
        Picasso.with(viewManager.getContext()).load(item.getThumb_photo()).into(target);
    }
    @Override
    public void fill(){
        view.setPrice(item.getPrice());
        view.setTitle(item.getTitle());
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
    public ProductView getView() {
        return view;
    }

    @Override
    public Object getItem() {
        return item;
    }

}
