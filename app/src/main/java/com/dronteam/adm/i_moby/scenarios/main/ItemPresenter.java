package com.dronteam.adm.i_moby.scenarios.main;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.dronteam.adm.i_moby.model.Item;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

/**
 * Created by adm on 14.11.2016.
 */
public class ItemPresenter {
    ItemView view;
    Item item;
    private Context context;
    final Target target = new Target(){
        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
            view.setImage(bitmap);
        }

        @Override
        public void onBitmapFailed(Drawable errorDrawable) {
        }

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {
        }
    };

    public ItemPresenter(Context context, Item item) {
        this.context = context;
        this.view = new ItemFragment(context);
        this.item = item;
        this.view.setEditListener(edit());
        Picasso.with(context).load("http://square.github.io/picasso/static/sample.png").into(target);
    }

    private View.OnClickListener edit() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        };
    }

    public ItemView getView() {
        return view;
    }


    public void fill(){
        view.setText(item.getTitle(), item.description, item.price.text);
    }

}
