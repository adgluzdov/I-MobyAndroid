package com.dronteam.adm.i_moby.scenarios.goods;

import android.util.Log;
import android.widget.AbsListView;

import com.dronteam.adm.i_moby.common.CommonBaseAdapter;
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

    private static final int COUNT_ITEM_LOAD = 10;
    private static final String QUERY_ALL = null;
    private static final String TAG = "My";
    private final GoodsView view;
    private final ItemService itemService;
    private String title;
    private ViewManager viewManager;
    private ServiceFactory serviceFactory;
    private CommonBaseAdapter adapter = new CommonBaseAdapter();
    private String albumId;
    private boolean goodsIsFull = false;
    private String searchQuery = QUERY_ALL;
    private boolean onLoad = false;

    public GoodsPresenter(ViewManager viewManager, GoodsView view, String albumId, String title, String query) {
        this.viewManager = viewManager;
        serviceFactory = viewManager.getServiceFactory();
        itemService = serviceFactory.getApi(ItemService.class);
        this.title = title;
        this.view = view;
        this.albumId = albumId;
        this.searchQuery = query;

        view.setOnCreateViewListener(this);
    }

    @Override
    public void OnCreateView() {
        if(!onLoad){
            startLoadGoods();
        }
        view.setList(adapter);
        view.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int scrollState) {
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE && (view.listViewGetLastVisiblePosition() - view.listViewGetHeaderViewsCount() -
                        view.listViewGetFooterViewsCount()) >= (adapter.getCount() - 1)) {
                    onScrollDown();
                }
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {

            }
        });
    }

    private void refresh(){
        goodsIsFull = false;
        onLoad = false;
        adapter.clear();
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
        view.startUnderProgressbar();
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
                ArrayList<ItemPresenter> itemPresenterList = new ArrayList<ItemPresenter>(){{
                    for (final Item item:
                        repo.getResponse().getItems()) {
                        add(new ProductPresenter(viewManager,item,new ProductFragment(viewManager.getContext())));
                    }
                }};
                if(itemPresenterList.size() < COUNT_ITEM_LOAD)
                    goodsIsFull = true;
                adapter.addItemPresenters(itemPresenterList);
                view.stopTopProgressbar();
                view.stopUnderProgressbar();
                onLoad = true;
            }
        };
    }

    @Override
    public CommonView getView() {
        return view;
    }

}
