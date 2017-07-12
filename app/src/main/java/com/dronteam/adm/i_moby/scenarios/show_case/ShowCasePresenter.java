package com.dronteam.adm.i_moby.scenarios.show_case;

import android.util.Log;

import com.dronteam.adm.i_moby.common.CommonView;
import com.dronteam.adm.i_moby.common.ItemPresenter;
import com.dronteam.adm.i_moby.common.adapters.ModelAdapter;
import com.dronteam.adm.i_moby.common.Presenter;
import com.dronteam.adm.i_moby.common.ViewListener;
import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.data.ItemService;
import com.dronteam.adm.i_moby.data.VK.json_response.get.GetResponse;
import com.dronteam.adm.i_moby.model.product.Item;
import com.dronteam.adm.i_moby.model.special_offer.SpecialOffer;
import com.dronteam.adm.i_moby.scenarios.special_offer.SpecialOfferAdapter;

import java.util.ArrayList;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import static android.content.ContentValues.TAG;

/**
 * Created by smb on 13/12/2016.
 */

public class ShowCasePresenter implements ItemPresenter, ViewListener {
    private ViewManager viewManager;
    private ShowCaseView view;
    private final ItemService itemService;
    private ModelAdapter adapter;
    private boolean onLoad = false;

    public ShowCasePresenter(ViewManager viewManager, final ShowCaseView view) {
        this.viewManager = viewManager;
        this.view = view;
        this.itemService = viewManager.getServiceFactory().getApi(ItemService.class);
        this.adapter = new SpecialOfferAdapter(viewManager);
        view.setOnCreateViewListener(this);
    }

    @Override
    public CommonView getView() {
        return view;
    }

    @Override
    public void OnCreateView() {
        if(!onLoad){
            startLoad();
        }
        view.setList(adapter.getViewAdapter(),viewManager.getContext());
    }

    private void startLoad(){
        view.startTopProgressbar();
        load();
    }

    private void load(){
        itemService.SearchSpecialOffers()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .map(responseToListModel())
                .map(deleteUnnecessaryItem())
                .subscribe(OnLoad(),onError());
    }

    private Func1<? super GetResponse, List<SpecialOffer>> responseToListModel() {
        return new Func1<GetResponse, List<SpecialOffer>>() {
            @Override
            public List<SpecialOffer> call(final GetResponse getResponse) {
                return new ArrayList<SpecialOffer>(){{
                    for (Item item : getResponse.getResponse().getItems()) {
                        add(new SpecialOffer(item));
                    }
                }};
            }
        };
    }

    private Func1<? super List<SpecialOffer>, List<SpecialOffer>> deleteUnnecessaryItem() {
        return new Func1<List<SpecialOffer>, List<SpecialOffer>>() {
            @Override
            public List<SpecialOffer> call(List<SpecialOffer> itemList) {
                for (int j = itemList.size()-1; j >= 0; j--) {
                    if(!itemList.get(j).getItem().getDescription().contains("#IMoby"))
                        itemList.remove(itemList.get(j));
                }
                return itemList;
            }
        };
    }

    private Action1<? super List<SpecialOffer>> OnLoad() {
        return new Action1<List<SpecialOffer>>() {
            @Override
            public void call(List<SpecialOffer> itemList) {
                if(itemList.size() == 0)
                    view.notifyNoGoods();
                else
                    adapter.addModel(itemList);
                onLoad = true;
                view.stopTopProgressbar();
            }
        };
    }

    private Action1<Throwable> onError() {
        return new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Log.d(TAG, "call: ");
            }
        };
    }

    @Override
    public String getViewTitle() {
        return view.getTitleFragment();
    }
}
