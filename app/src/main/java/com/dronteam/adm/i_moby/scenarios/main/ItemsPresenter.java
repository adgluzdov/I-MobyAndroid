package com.dronteam.adm.i_moby.scenarios.main;

import android.content.Context;
import android.util.Log;

import com.dronteam.adm.i_moby.common.Repo;
import com.dronteam.adm.i_moby.common.ViewListener;
import com.dronteam.adm.i_moby.data.TestFactory;
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

public class ItemsPresenter implements ViewListener {

    private static final String TAG = "I-MobyLogs";
    private final ItemView view;
    private final ItemService itemService;
    private Context ctx;
    private ServiceFactory itemServiceApi;
    public ItemsPresenter(ItemView view) {
        this.ctx = (Context)view;
        this.view = view;
        itemServiceApi = new RetrofitFactory();
        //itemServiceApi = new TestFactory();
        itemService = itemServiceApi.getApi(ItemService.class);
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
        return new ItemAdapter(ctx,items);
    }
}
