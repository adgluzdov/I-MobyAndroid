package com.dronteam.adm.i_moby.scenarios.goods;

import android.util.Log;
import android.widget.AbsListView;

import com.dronteam.adm.i_moby.common.OnScrollViewListener;
import com.dronteam.adm.i_moby.common.adapters.ModelAdapter;
import com.dronteam.adm.i_moby.common.adapters.base_adapter.CommonBaseAdapter;
import com.dronteam.adm.i_moby.common.CommonView;
import com.dronteam.adm.i_moby.common.adapters.ItemPresenter;
import com.dronteam.adm.i_moby.common.Presenter;
import com.dronteam.adm.i_moby.data.VK.json_response.get.GetResponse;
import com.dronteam.adm.i_moby.common.ViewListener;
import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.data.ServiceFactory;
import com.dronteam.adm.i_moby.data.ItemService;
import com.dronteam.adm.i_moby.model.product.Item;
import com.dronteam.adm.i_moby.scenarios.product.ProductAdapter;
import com.dronteam.adm.i_moby.scenarios.product.ProductFragment;
import com.dronteam.adm.i_moby.scenarios.product.ProductPresenter;

import java.util.ArrayList;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by smb on 18/10/2016.
 */

public class GoodsPresenter implements ViewListener, Presenter {

    private static final int COUNT_ITEM_LOAD = 10;
    private static final String QUERY_ALL = null;
    private static final String TAG = "My";
    private final GoodsView view;
    private final ItemService itemService;
    private String title;
    private ViewManager viewManager;
    private ServiceFactory serviceFactory;
    private ModelAdapter adapter;
    private String albumId;
    private boolean goodsIsFull = false;
    private String searchQuery = QUERY_ALL;
    private int NUMBER_START_LOAD;
    private boolean onLoad = false;

    public GoodsPresenter(ViewManager viewManager, GoodsView view, String albumId, String title, String query) {
        this.viewManager = viewManager;
        serviceFactory = viewManager.getServiceFactory();
        itemService = serviceFactory.getApi(ItemService.class);
        this.title = title;
        this.view = view;
        this.albumId = albumId;
        this.searchQuery = query;
        this.adapter = new ProductAdapter(viewManager);
        view.setOnCreateViewListener(this);
    }

    @Override
    public void OnCreateView() {
        if(!onLoad){
            startLoadGoods();
        }
        view.setList(adapter.getViewAdapter(),viewManager);
        view.setOnScrollListener(new OnScrollViewListener() {
            @Override
            public void onScroll(int visiblePositin) {
                if(adapter.getCount() - visiblePositin <= NUMBER_START_LOAD){
                    adapter.addModel(new ArrayList<String>(){{add("");}});
                    onScrollDown();
                }
            }
        });
    }

    private void refresh(){
        goodsIsFull = false;
        onLoad = false;
        //adapter.clear();
        startLoadGoods();
    }

    private void startLoadGoods() {
        view.startTopProgressbar();
        loadGoods();
    }

    private void loadGoods() {
        itemService.Search(searchQuery,albumId,adapter.getCount(),COUNT_ITEM_LOAD)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(onItemLoaded(), onError());
    }

    private void moreLoadGoods() {
        //view.startUnderProgressbar();
        loadGoods();
    }

    private void onScrollDown(){
        if(!goodsIsFull)
            moreLoadGoods();
    }

        private Action1<Throwable> onError() {
        return new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {

            }
        };
    }

    private Action1<? super GetResponse> onItemLoaded() {
        return new Action1<GetResponse>() {
            @Override
            public void call(final GetResponse repo) {
                Log.d(TAG, "call: success");
                List<Item> itemList = repo.getResponse().getItems();
                if(itemList.size() < COUNT_ITEM_LOAD)
                    goodsIsFull = true;
                adapter.addModel(itemList);
                view.stopTopProgressbar();
                //view.stopUnderProgressbar();
                onLoad = true;
            }
        };
    }

    @Override
    public CommonView getView() {
        return view;
    }

}
