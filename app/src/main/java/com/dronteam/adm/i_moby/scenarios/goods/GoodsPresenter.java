package com.dronteam.adm.i_moby.scenarios.goods;

import com.dronteam.adm.i_moby.common.CallBack;
import com.dronteam.adm.i_moby.common.CallBack2;
import com.dronteam.adm.i_moby.common.CommonView;
import com.dronteam.adm.i_moby.common.Presenter;
import com.dronteam.adm.i_moby.common.adapters.recycler_view_adapter.CommonRecyclerViewAdapter;
import com.dronteam.adm.i_moby.common.fragment.with_toolbar.with_menu.OptionsMenuListener;
import com.dronteam.adm.i_moby.common.progressbar.ProgressbarPresenter;
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
    private static final String QUERY_ALL = "";

    private GoodsView view;
    private final ItemService itemService;
    private ViewManager viewManager;
    private ServiceFactory serviceFactory;
    public CommonRecyclerViewAdapter adapter;
    private com.dronteam.adm.i_moby.model.album.Item album;

    private String title;
    private String searchQuery = QUERY_ALL;
    private int offset = 0;
    private int count = COUNT_ITEM_LOAD;
    private int progressbarPosition;

    public GoodsPresenter(ViewManager viewManager, GoodsView view, com.dronteam.adm.i_moby.model.album.Item album, String query) {
        this.viewManager = viewManager;
        serviceFactory = viewManager.getServiceFactory();
        itemService = serviceFactory.getApi(ItemService.class);
        this.album = album;
        this.view = view;
        this.searchQuery = query;
        title = isGlobalSearch() ? "Глобальный поиск" : album.getTitle();
        view.setOnCreateOptionsMenu(this);
        view.setOnCreateViewListener(this);
    }

    @Override
    public void OnCreateView() {
        if(adapter != null) {
            view.setList(adapter);
        } else {
            startLoadGoods();
        }
    }

    @Override
    public void onCreateOptionsMenu() {
        view.setToolbarTitle(title);
        if (!searchQuery.equals(QUERY_ALL)) {
            view.setActive();
            view.setQuery(searchQuery, false);
        }
        view.setOnSubmit(new CallBack2<String>() {
            @Override
            public void call(String query) {
                resetLoadParametr();
                searchQuery = query;
                adapter = null;
                startLoadGoods();
            }
        });
        view.setOnClose(new CallBack() {
            @Override
            public void call() {
                if(!searchQuery.equals("")){
                    resetLoadParametr();
                    adapter = null;
                    startLoadGoods();
                }
            }
        });
    }

    private void startLoadGoods() {
        view.startTopProgressbar();
        itemService.Search(searchQuery,album.getId().toString(),offset,count)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(onItemLoaded(), onError());
    }

    private Action1<? super GetResponse> onItemLoaded() {
        return new Action1<GetResponse>() {
            @Override
            public void call(final GetResponse repo) {
                List<Item> itemList = repo.getResponse().getItems();
                if(itemList.size() == 0){
                    view.notifyNoGoods();
                }else{
                    offset+= itemList.size();
                    adapter = new ProductAdapter(viewManager);
                    adapter.addListModel(itemList);
                    adapter.setLoadMoreListener(new CommonRecyclerViewAdapter.OnLoadMoreListener() {
                        @Override
                        public void onLoadMore() {
                            progressbarPosition = adapter.getCount();
                            adapter.addModel(ProgressbarPresenter.MODEL,progressbarPosition);
                            itemService.Search(searchQuery,album.getId().toString(),offset,count)
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribeOn(Schedulers.newThread())
                                    .subscribe(onItemsLoadMore(), onError());
                        }

                        private Action1<? super GetResponse> onItemsLoadMore() {
                            return new Action1<GetResponse>() {
                                @Override
                                public void call(GetResponse getResponse) {
                                    List<Item> itemList = getResponse.getResponse().getItems();
                                    if(!(itemList.size() == count))
                                        adapter.setMoreDataAvailable(false);
                                    offset+= itemList.size();
                                    adapter.setLoading(false);
                                    adapter.removeModel(progressbarPosition);
                                    adapter.addListModel(itemList);
                                }
                            };
                        }
                    });
                    view.setList(adapter);
                }
                view.stopTopProgressbar();
            }
        };
    }

    private Action1<Throwable> onError() {
        return new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {

            }
        };
    }

    @Override
    public CommonView getView() {
        return view;
    }

    private void resetLoadParametr() {
        offset = 0;
        count = COUNT_ITEM_LOAD;
        searchQuery = QUERY_ALL;
    }

    private boolean isGlobalSearch(){
        return !searchQuery.equals(QUERY_ALL) && album.getId().equals(com.dronteam.adm.i_moby.model.album.Item.ALL_GOODS.getId());
    }
}
