package com.dronteam.adm.i_moby.scenarios.goods;

import com.dronteam.adm.i_moby.common.CallBack2;
import com.dronteam.adm.i_moby.common.OnScrollViewListener;
import com.dronteam.adm.i_moby.common.adapters.ModelAdapter;
import com.dronteam.adm.i_moby.common.CommonView;
import com.dronteam.adm.i_moby.common.Presenter;
import com.dronteam.adm.i_moby.common.fragment.with_toolbar.with_menu.OptionsMenuListener;
import com.dronteam.adm.i_moby.data.VK.json_response.get.GetResponse;
import com.dronteam.adm.i_moby.common.ViewListener;
import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.data.ServiceFactory;
import com.dronteam.adm.i_moby.data.ItemService;
import com.dronteam.adm.i_moby.model.product.Item;
import com.dronteam.adm.i_moby.scenarios.product.ProductAdapter;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by smb on 18/10/2016.
 */

public class GoodsPresenter implements ViewListener, Presenter, OptionsMenuListener {

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
    private int NUMBER_START_LOAD = 0;
    private boolean loaded = false;
    private boolean loadingMore = false;
    private int progressbarPosition;
    private int countModelLoaded = 0;

    public GoodsPresenter(ViewManager viewManager, GoodsView view, String albumId, String title, String query) {
        this.viewManager = viewManager;
        serviceFactory = viewManager.getServiceFactory();
        itemService = serviceFactory.getApi(ItemService.class);
        this.title = title;
        this.view = view;
        this.albumId = albumId;
        this.searchQuery = query;
        this.adapter = new ProductAdapter(viewManager);
        view.setOnCreateOptionsMenu(this);
        view.setOnCreateViewListener(this);
    }

    @Override
    public void OnCreateView() {
        if(!loaded){
            startLoadGoods();
        }
        view.setList(adapter.getViewAdapter(),viewManager);
        view.setOnScrollListener(new OnScrollViewListener() {
            @Override
            public void onScroll(int dx) {
                if(!loadingMore)
                    if(loaded)
                        if(!goodsIsFull)
                            if(adapter.getCount() - view.findFirstVisibleItemPosition() - view.getChildCount() <= NUMBER_START_LOAD)
                                moreLoadGoods();
            }
        });
    }

    private void refresh(){
        loadingMore = false;
        goodsIsFull = false;
        loaded = false;
        adapter.removeAll();
        startLoadGoods();
    }

    private void startLoadGoods() {
        view.startTopProgressbar();
        loadGoods();
    }

    private void loadGoods() {
        itemService.Search(searchQuery,albumId,countModelLoaded,COUNT_ITEM_LOAD)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(onItemLoaded(), onError());
    }

    private void moreLoadGoods() {
        loadingMore = true;
        progressbarPosition = adapter.getCount();
        adapter.addModel("Progressbar",adapter.getCount());
        loadGoods();
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
                List<Item> itemList = repo.getResponse().getItems();
                countModelLoaded += itemList.size();
                if(itemList.size() < COUNT_ITEM_LOAD)
                    goodsIsFull = true;

                if(loadingMore){
                    loadingMore = false;
                    adapter.removeModel(progressbarPosition);
                }
                if(itemList.size() == 0)
                    view.notifyNoGoods();
                else{
                    adapter.addListModel(itemList);
                }

                view.stopTopProgressbar();
                loaded = true;
            }
        };
    }

    @Override
    public CommonView getView() {
        return view;
    }

    @Override
    public void onCreateOptionsMenu() {
        view.setOnSubmit(new CallBack2<String>() {
            @Override
            public void call(String query) {
                searchQuery = query;
                refresh();
            }
        });
    }
}
