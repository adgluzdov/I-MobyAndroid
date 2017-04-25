package com.dronteam.adm.i_moby.scenarios.goods;

import android.util.Log;

import com.dronteam.adm.i_moby.common.CommonAdapter;
import com.dronteam.adm.i_moby.common.CommonView;
import com.dronteam.adm.i_moby.common.ItemPresenter;
import com.dronteam.adm.i_moby.common.Presenter;
import com.dronteam.adm.i_moby.data.VK.json_response.get.GetResponse;
import com.dronteam.adm.i_moby.common.ViewListener;
import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.data.ServiceFactory;
import com.dronteam.adm.i_moby.data.ItemService;
import com.dronteam.adm.i_moby.model.product.Item;
import com.dronteam.adm.i_moby.scenarios.product.ProductFragment;
import com.dronteam.adm.i_moby.scenarios.product.ProductPresenter;

import java.util.ArrayList;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by smb on 18/10/2016.
 */

public class GoodsPresenter implements ViewListener, Presenter {

    private static final String TAG = "My";
    private final GoodsView view;
    private final ItemService itemService;
    private ViewManager viewManager;
    private ServiceFactory serviceFactory;
    private CommonAdapter adapter;
    private String albumId;

    public GoodsPresenter(ViewManager viewManager, GoodsView view, String albumId) {
        this.viewManager = viewManager;
        this.view = view;
        this.albumId = albumId;
        serviceFactory = viewManager.getServiceFactory();
        itemService = serviceFactory.getApi(ItemService.class);
        view.setOnCreateViewListener(this);
        this.adapter = new CommonAdapter();
    }

    @Override
    public void OnCreateView() {
        adapter.clear();
        view.setList(adapter);
        itemService.Get(albumId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(onItemLoaded(), onError());
    }

    private Action1<Throwable> onError() {
        return new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Log.d(TAG, "call: error in GoodsPresenter");
            }
        };
    }

    private Action1<? super GetResponse> onItemLoaded() {
        return new Action1<GetResponse>() {
            @Override
            public void call(final GetResponse repo) {
                Log.d(TAG, "call: success");
                ArrayList<ItemPresenter> itemPresenterList = new ArrayList<ItemPresenter>(){{
                    for (final Item item:
                        repo.getResponse().getItems()) {
                        add(new ProductPresenter(viewManager,item,new ProductFragment(viewManager.getContext())));
                    }
                }};
                adapter.addItemPresenters(itemPresenterList);
            }
        };
    }

    @Override
    public CommonView getView() {
        return view;
    }
}
