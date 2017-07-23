package com.dronteam.adm.i_moby.scenarios.detail_information;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.dronteam.adm.i_moby.R;
import com.dronteam.adm.i_moby.common.CommonView;
import com.dronteam.adm.i_moby.common.Presenter;
import com.dronteam.adm.i_moby.common.ViewListener;
import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.data.ItemService;
import com.dronteam.adm.i_moby.data.ServiceFactory;
import com.dronteam.adm.i_moby.data.VK.json_response.messages.send.MessegesSendResponse;
import com.dronteam.adm.i_moby.model.product.Item;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.Date;
import java.util.Random;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by User on 20.12.2016.
 */
public class DetailInfoPresenter implements Presenter, ViewListener {
    ItemService itemService;
    ServiceFactory serviceFactory;
    DetailInfoView view;
    ViewManager viewManager;
    Item product;
    Bitmap loadedImage;
    int random_id;
    private boolean isSend = false;

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
        this.serviceFactory = viewManager.getServiceFactory();
        this.itemService = serviceFactory.getApi(ItemService.class);
        this.random_id = new Random().nextInt(10000);
        view.setOnCreateViewListener(this);
    }

    @Override
    public void OnCreateView() {
        Picasso.with(viewManager.getContext()).load(product.getThumb_photo()).into(target);
        fill();
        view.setEditListener(edit());
        view.setToolbarTitle("Товар");
    }

    private View.OnClickListener edit(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isSend){
                    String attachment = "market"+product.getOwner_id()+"_"+product.getId();
                    itemService.MessegesSend(Item.MESSEGE_ORDER,attachment,String.valueOf(random_id))
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeOn(Schedulers.newThread())
                            .subscribe(onMessegesSend(), onError());
                }
                else
                    view.informingMessageAlreadySent();
            }
        };
    }

    private Action1<Throwable> onError() {
        return new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                view.informingMessageIsNotSent();
                random_id = new Random().nextInt(10000);
            }
        };
    }

    private Action1<? super MessegesSendResponse> onMessegesSend() {
        return new Action1<MessegesSendResponse>() {
            @Override
            public void call(MessegesSendResponse messegesSendResponse) {
                isSend = true;
                view.informingMessageIsSent();
            }
        };
    }

    private void fill() {
        view.setPrice(product.getPrice());
        view.setCategoty(product.getCategory());
        view.setTitle(product.getTitle());
        view.setDescription(product.getDescription());
        view.setDate(product.getDate());
        if(loadedImage != null)
            view.setImage(loadedImage);
        else
            view.setPlaceHolder(R.mipmap.ic_launcher);
    }

    @Override
    public CommonView getView() {
        return view;
    }
}
