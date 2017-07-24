package com.dronteam.adm.i_moby.scenarios.catalog;

import com.dronteam.adm.i_moby.common.CommonView;
import com.dronteam.adm.i_moby.common.PagePresenter;
import com.dronteam.adm.i_moby.common.ViewListener;
import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.common.adapters.recycler_view_adapter.CommonRecyclerViewAdapter;
import com.dronteam.adm.i_moby.common.progressbar.SwapProgressbarListener;
import com.dronteam.adm.i_moby.data.ItemService;
import com.dronteam.adm.i_moby.data.ServiceFactory;
import com.dronteam.adm.i_moby.data.VK.json_response.getAlbums.GetAlbumsResponse;
import com.dronteam.adm.i_moby.model.album.Item;
import com.dronteam.adm.i_moby.scenarios.album.AlbumAdapter;
import com.dronteam.adm.i_moby.scenarios.catalog.all_goods.AllGoodsPresenter;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by adm on 04.07.2017.
 */

public class CatalogPresenter implements ViewListener, PagePresenter, SwapProgressbarListener {
    private final CatalogView view;
    private final ItemService itemService;
    private ViewManager viewManager;
    private ServiceFactory serviceFactory;
    private CommonRecyclerViewAdapter adapter;

    public CatalogPresenter(ViewManager viewManager, CatalogView view) {
        this.viewManager = viewManager;
        serviceFactory = viewManager.getServiceFactory();
        itemService = serviceFactory.getApi(ItemService.class);
        this.view = view;
        view.setOnCreateViewListener(this);
    }

    @Override
    public void OnCreateView() {
        if(adapter != null) {
            view.setList(adapter);
        }
        else {
            startLoadCatalog();
        }
        view.setSwapProgressbarListener(this);
    }

    private void startLoadCatalog() {
        view.startTopProgressbar();
        itemService.GetAlbums()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .map(responseToListModel())
                .subscribe(onItemLoaded(), onError());
    }

    private Func1<? super GetAlbumsResponse, List<Item>> responseToListModel() {
        return new Func1<GetAlbumsResponse, List<Item>>() {
            @Override
            public List<Item> call(GetAlbumsResponse getAlbumsResponse) {
                return getAlbumsResponse.getResponse().getItems();
            }
        };
    }

    private Action1<? super List<Item>> onItemLoaded() {
        return new Action1<List<Item>>() {
            @Override
            public void call(List<Item> itemList) {
                adapter = new AlbumAdapter(viewManager);
                adapter.addListModel(itemList);
                adapter.addModel(AllGoodsPresenter.MODEL,adapter.getCount());
                view.setList(adapter);
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

    @Override
    public String getViewTitle() {
        return "Каталог";
    }

    @Override
    public void onSwap() {
        view.startTopProgressbar();
        itemService.GetAlbums()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .map(responseToListModel())
                .subscribe(onItemUpdate(), onError());
    }

    private Action1<? super List<Item>> onItemUpdate() {
        return new Action1<List<Item>>() {
            @Override
            public void call(List<Item> items) {
                if(!items.equals(adapter.getModelList())){
                    adapter = null;
                    onItemLoaded().call(items);
                }
            }
        };
    }
}
