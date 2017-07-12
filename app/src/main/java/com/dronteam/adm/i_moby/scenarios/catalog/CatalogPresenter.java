package com.dronteam.adm.i_moby.scenarios.catalog;

import com.dronteam.adm.i_moby.UIFactory;
import com.dronteam.adm.i_moby.common.CallBack;
import com.dronteam.adm.i_moby.common.adapters.ModelAdapter;
import com.dronteam.adm.i_moby.common.adapters.base_adapter.CommonBaseAdapter;
import com.dronteam.adm.i_moby.common.CommonView;
import com.dronteam.adm.i_moby.common.adapters.ItemPresenter;
import com.dronteam.adm.i_moby.common.ViewListener;
import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.common.adapters.recycler_view_adapter.CommonRecyclerViewAdapter;
import com.dronteam.adm.i_moby.data.ItemService;
import com.dronteam.adm.i_moby.data.ServiceFactory;
import com.dronteam.adm.i_moby.data.VK.json_response.getAlbums.GetAlbumsResponse;
import com.dronteam.adm.i_moby.model.album.Item;
import com.dronteam.adm.i_moby.scenarios.album.AlbumAdapter;
import com.dronteam.adm.i_moby.scenarios.album.AlbumFragment;
import com.dronteam.adm.i_moby.scenarios.album.AlbumPresenter;

import java.util.ArrayList;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by adm on 04.07.2017.
 */

public class CatalogPresenter implements ViewListener, com.dronteam.adm.i_moby.common.ItemPresenter {
    private static final String TAG = "My";
    private final CatalogView view;
    private final ItemService itemService;
    private ViewManager viewManager;
    private ServiceFactory serviceFactory;
    private ModelAdapter adapter;
    private static final String ID_MAIN_ALBUM = "0";
    private boolean onLoad = false;

    public CatalogPresenter(ViewManager viewManager, CatalogView view) {
        this.viewManager = viewManager;
        serviceFactory = viewManager.getServiceFactory();
        itemService = serviceFactory.getApi(ItemService.class);
        this.view = view;
        adapter = new AlbumAdapter(viewManager);
        view.setOnCreateViewListener(this);
    }

    @Override
    public void OnCreateView() {
        if(!onLoad)
            startLoadCatalog();
        view.setList(adapter.getViewAdapter(),viewManager.getContext());
    }

    private void startLoadCatalog() {
        view.startTopProgressbar();
        loadCatalog();
    }

    private void loadCatalog() {
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
                onLoad = true;
                adapter.addModel(itemList);
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
        return view.getTitleFragment();
    }
}
