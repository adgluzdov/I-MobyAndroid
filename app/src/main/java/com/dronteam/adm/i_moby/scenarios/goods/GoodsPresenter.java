package com.dronteam.adm.i_moby.scenarios.goods;

import com.dronteam.adm.i_moby.common.CallBack;
import com.dronteam.adm.i_moby.common.CallBack2;
import com.dronteam.adm.i_moby.common.OnScrollViewListener;
import com.dronteam.adm.i_moby.common.adapters.ItemPresenter;
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
import java.util.concurrent.TimeUnit;

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
    private String searchQuery = QUERY_ALL;
    private int NUMBER_START_LOAD = 3;

    private int offset = 0;
    private int count = COUNT_ITEM_LOAD;
    private boolean goodsIsFull = false;

    private boolean startLoad = false;
    private boolean finishLoad = false;

    private boolean startLoadMore = false;
    private boolean finishLoadMore = false;
    private int progressbarPosition;

    public GoodsPresenter(ViewManager viewManager, GoodsView view, com.dronteam.adm.i_moby.model.album.Item album, String query) {
        this.viewManager = viewManager;
        serviceFactory = viewManager.getServiceFactory();
        itemService = serviceFactory.getApi(ItemService.class);
        this.title = album.getTitle();
        this.view = view;
        this.albumId = album.getId().toString();
        this.searchQuery = query;
        this.adapter = new ProductAdapter(viewManager);
        view.setOnCreateOptionsMenu(this);
        view.setOnCreateViewListener(this);
    }

    @Override
    public void OnCreateView() {
        view.setList(adapter.getViewAdapter(),viewManager);
        getList();
        view.setOnScrollListener(new OnScrollViewListener() {
            @Override
            public void onScroll(int dx) {
                if(!startLoadMore && finishLoad && !goodsIsFull)
                    if(adapter.getCount() - view.findFirstVisibleItemPosition() - view.getChildCount() <= NUMBER_START_LOAD){
                        startLoadMore();
                    }
            }
        });
    }
    private void getList(){
        if(!startLoad && !finishLoad && !goodsIsFull){
            startLoadGoods();
        }
    }

    private void startLoadMore() {
        startLoadMore = true;
        progressbarPosition = adapter.getCount();
        adapter.addModel("ProgressBar",progressbarPosition);
        loadGoods();
    }

    private void finishLoadMoreGoods(List<Item> itemList) {
        adapter.removeModel(progressbarPosition);
        adapter.addListModel(itemList);
        if(itemList.size() == 0) view.notifyNoGoods();
        startLoadMore = false;
        finishLoadMore = true;
    }

    private void startLoadGoods() {
        startLoad = true;
        view.startTopProgressbar();
        loadGoods();
    }

    private void finishLoadGoods(List<Item> itemList){
        view.stopTopProgressbar();
        if(itemList.size() == 0) view.notifyNoGoods();
        adapter.addListModel(itemList);
        finishLoad = true;
        startLoad = false;
    }

    private void loadGoods() {
        itemService.Search(searchQuery,albumId,offset,count)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(onItemLoaded(), onError());
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
                offset += itemList.size();
                goodsIsFull = (itemList.size() < COUNT_ITEM_LOAD);
                if(startLoad)
                    finishLoadGoods(itemList);
                if(startLoadMore)
                    finishLoadMoreGoods(itemList);
                adapter = adapter;
            }
        };
    }

    @Override
    public CommonView getView() {
        return view;
    }

    @Override
    public void onCreateOptionsMenu() {
        view.setToolbarTitle(title);
        view.setOnSubmit(new CallBack2<String>() {
            @Override
            public void call(String query) {
                searchQuery = query;
                reset();
                adapter.removeAll();
                getList();
            }
        });
        view.setOnClose(new CallBack() {
            @Override
            public void call() {
                searchQuery = QUERY_ALL;
                reset();
                adapter.removeAll();
                getList();
            }
        });
    }

    private void reset() {
        offset = 0;
        count = COUNT_ITEM_LOAD;
        goodsIsFull = false;

        startLoad = false;
        finishLoad = false;

        startLoadMore = false;
        finishLoadMore = false;
    }
}
