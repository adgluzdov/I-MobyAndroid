package com.dronteam.adm.i_moby.scenarios.search;

import android.widget.SearchView;

import com.dronteam.adm.i_moby.common.CommonAdapter;
import com.dronteam.adm.i_moby.common.CommonView;
import com.dronteam.adm.i_moby.common.ItemPresenter;
import com.dronteam.adm.i_moby.common.Presenter;
import com.dronteam.adm.i_moby.common.ViewListener;
import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.data.ItemService;
import com.dronteam.adm.i_moby.data.VK.json_response.get.GetResponse;
import com.dronteam.adm.i_moby.scenarios.product.ProductFragment;
import com.dronteam.adm.i_moby.scenarios.product.ProductPresenter;

import java.util.ArrayList;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by adm on 22.04.2017.
 */

public class SearchGoodsPresenter implements Presenter, ViewListener {
    SearchGoodsView view;
    ViewManager viewManager;
    ItemService itemService;
    CommonAdapter adapter;

    public SearchGoodsPresenter(final ViewManager viewManager, SearchGoodsView view) {
        this.view = view;
        this.viewManager = viewManager;
        adapter = new CommonAdapter();
        itemService = viewManager.getServiceFactory().getApi(ItemService.class);
        view.setOnCreateViewListener(this);
    }



    @Override
    public void OnCreateView() {
        view.setAdapter(adapter);
        view.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                itemService.Search(query)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.newThread())
                        .subscribe(onProductLoaded(), onError());
                return false;
            }
        });
    }

    private Action1<Throwable> onError() {
        return new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {

            }
        };
    }

    private Action1<? super GetResponse> onProductLoaded() {
        return new Action1<GetResponse>() {

            @Override
            public void call(final GetResponse getResponse) {
                ArrayList<ItemPresenter> itemPresenterList = new ArrayList<ItemPresenter>(){{
                    for (final com.dronteam.adm.i_moby.model.product.Item item:
                            getResponse.getResponse().getItems()) {
                        add(new ProductPresenter(viewManager,item,new ProductFragment(viewManager.getContext())));
                    }
                }};
                adapter.clear();
                adapter.addItemPresenters(itemPresenterList);
            }
        };
    }

    @Override
    public CommonView getView() {
        return view;
    }
}
