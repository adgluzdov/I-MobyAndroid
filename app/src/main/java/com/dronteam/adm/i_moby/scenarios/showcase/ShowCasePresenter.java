package com.dronteam.adm.i_moby.scenarios.showcase;

import android.util.Log;

import com.dronteam.adm.i_moby.UIFactory;
import com.dronteam.adm.i_moby.common.CallBack;
import com.dronteam.adm.i_moby.common.CommonView;
import com.dronteam.adm.i_moby.common.Presenter;
import com.dronteam.adm.i_moby.common.Repo;
import com.dronteam.adm.i_moby.common.ViewListener;
import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.data.ItemService;
import com.dronteam.adm.i_moby.data.ItemServiceTest;
import com.dronteam.adm.i_moby.data.RetrofitFactory;
import com.dronteam.adm.i_moby.data.ServiceFactory;
import com.dronteam.adm.i_moby.data.TestFactory;
import com.dronteam.adm.i_moby.model.Item;
import com.dronteam.adm.i_moby.scenarios.item.ItemAdapter;
import com.dronteam.adm.i_moby.scenarios.special_offer.SpecialOffer;
import com.dronteam.adm.i_moby.scenarios.special_offer.SpecialOffersAdapter;

import java.util.List;
import com.vk.sdk.VKSdk;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by smb on 13/12/2016.
 */
public class ShowcasePresenter implements Presenter, ViewListener {
    private static final String TAG = "My";
    private ViewManager viewManager;
    private ShowcaseView view;
    private final ItemService itemService;
    //private ServiceFactory serviceFactory;

    public ShowcasePresenter(ViewManager viewManager, ShowcaseView view) {
        this.viewManager = viewManager;
        this.view = view;
        //serviceFactory = new RetrofitFactory();
        itemService = viewManager.getServiceFactory().getApi(ItemService.class);

        view.setOnCreateViewListener(this);
    }

    @Override
    public CommonView getView() {
        return view;
    }

    @Override
    public void OnCreateView() {
        itemService.Get()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(onSpecialOffersLoaded(), onError());
    }

    private Action1<? super Repo> onSpecialOffersLoaded() {
        return new Action1<Repo>() {
            @Override
            public void call(Repo repo) {
                Log.d(TAG, "call: success - onSpecialOffersLoaded()");
                SpecialOffersAdapter specialOffersAdapter = getAdapter(repo.getResponse().getItems());
                view.setList(specialOffersAdapter);
            }
        };
    }

    private Action1<Throwable> onError() {
        return new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Log.d(TAG, "call: error in ShowCasePresenter");
            }
        };
    }

    private SpecialOffersAdapter getAdapter(List<Item> items) {


        return new SpecialOffersAdapter(viewManager,items);
    }
}
