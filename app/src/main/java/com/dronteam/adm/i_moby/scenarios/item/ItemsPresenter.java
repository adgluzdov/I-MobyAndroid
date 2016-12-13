package com.dronteam.adm.i_moby.scenarios.item;

import android.content.Context;
import android.util.Log;

import com.dronteam.adm.i_moby.common.CommonView;
import com.dronteam.adm.i_moby.common.Presenter;
import com.dronteam.adm.i_moby.common.Repo;
import com.dronteam.adm.i_moby.common.ViewListener;
import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.data.ServiceFactory;
import com.dronteam.adm.i_moby.data.ItemService;
import com.dronteam.adm.i_moby.data.RetrofitFactory;
import com.dronteam.adm.i_moby.model.Item;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by smb on 18/10/2016.
 */

public class ItemsPresenter implements ViewListener, Presenter {

    private static final String TAG = "My";
    private final ItemsView view;
    private final ItemService itemService;
    private ViewManager viewManager;
  //  private Context ctx;
    private ServiceFactory serviceFactory;

    public ItemsPresenter(ViewManager viewManager, ItemsView view) {
        this.viewManager = viewManager;
//        this.ctx = (Context)view;
        this.view = view;
        serviceFactory = new RetrofitFactory();
        //serviceFactory = new TestFactory();
        itemService = serviceFactory.getApi(ItemService.class);
        view.setOnCreateViewListener(this);
    }

    @Override
    public void OnCreateView() {
        itemService.Get()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(onItemLoaded(), onError());
    }

    private Action1<Throwable> onError() {
        return new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Log.d(TAG, "call: error");
            }
        };
    }

    private Action1<? super Repo> onItemLoaded() {
        return new Action1<Repo>() {
            @Override
            public void call(Repo repo) {
                Log.d(TAG, "call: success");
                ItemAdapter itemAdapter = getAdapter(repo.getResponse().getItems());
                view.setList(itemAdapter);
            }
        };
    }

    private ItemAdapter getAdapter(List<Item> items) {
        return new ItemAdapter(viewManager,items);
    }

    @Override
    public CommonView getView() {
        return view;
    }
}
