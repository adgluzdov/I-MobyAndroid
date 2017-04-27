package com.dronteam.adm.i_moby.scenarios.detail_information;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.dronteam.adm.i_moby.common.CommonView;
import com.dronteam.adm.i_moby.common.Presenter;
import com.dronteam.adm.i_moby.common.ViewListener;
import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.model.product.Item;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.Date;

/**
 * Created by User on 20.12.2016.
 */
public class DetailInfoPresenter implements Presenter, ViewListener {
    DetailInfoView view;
    ViewManager viewManager;
    Item product;
    Bitmap loadedImage;
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

    public DetailInfoPresenter(ViewManager viewManager, Item product, DetailInfoView view) {
        this.view = view;
        this.viewManager = viewManager;
        this.product = product;
        view.setOnCreateViewListener(this);
    }

    @Override
    public void OnCreateView() {
        Picasso.with(viewManager.getContext()).load(product.getThumb_photo()).into(target);
        fill();
    }

    private void fill() {
        view.setCategoryName(product.getCategory().getName());
        view.setDescription(product.getDescription());
        view.setCategorySection(product.getCategory().getSection().getName());
        view.setDate(String.valueOf(new Date(product.getDate())));
        view.setPrice(product.getPrice().getText());
        if(loadedImage != null)
            view.setImage(loadedImage);
        else
            view.setBlankImage();
    }

    @Override
    public CommonView getView() {
        return view;
    }
}
