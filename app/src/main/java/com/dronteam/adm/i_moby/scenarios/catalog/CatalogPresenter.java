package com.dronteam.adm.i_moby.scenarios.catalog;

import com.dronteam.adm.i_moby.UIFactory;
import com.dronteam.adm.i_moby.common.CallBack;
import com.dronteam.adm.i_moby.common.CommonAdapter;
import com.dronteam.adm.i_moby.common.CommonView;
import com.dronteam.adm.i_moby.common.ItemPresenter;
import com.dronteam.adm.i_moby.common.Presenter;
import com.dronteam.adm.i_moby.common.ViewListener;
import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.data.ItemService;
import com.dronteam.adm.i_moby.data.ServiceFactory;
import com.dronteam.adm.i_moby.data.VK.json_response.getAlbums.GetAlbumsResponse;
import com.dronteam.adm.i_moby.model.album.Item;
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

public class CatalogPresenter implements ViewListener, Presenter {
    private static final String TAG = "My";
    private final CatalogView view;
    private final ItemService itemService;
    private ViewManager viewManager;
    private ServiceFactory serviceFactory;
    private CommonAdapter adapter = new CommonAdapter();
    private static final String ID_MAIN_ALBUM = "0";
    private boolean onLoad = false;

    public CatalogPresenter(ViewManager viewManager, CatalogView view) {
        this.viewManager = viewManager;
        serviceFactory = viewManager.getServiceFactory();
        itemService = serviceFactory.getApi(ItemService.class);
        this.view = view;
        adapter = new CommonAdapter();
        view.setOnCreateViewListener(this);
    }

    @Override
    public void OnCreateView() {
        if(!onLoad)
            startLoadCatalog();
        view.setList(adapter);
        view.setOnButtonMainAlbumClick(new CallBack() {
            @Override
            public void call() {
                viewManager.show(UIFactory.GoodsPresenter(viewManager, ID_MAIN_ALBUM));
            }
        });
    }

    private void startLoadCatalog() {
        view.startProgressBar();
        loadCatalog();
    }

    private void loadCatalog() {
        itemService.GetAlbums()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .map(responseToListItemPresenter())
                .subscribe(onItemLoaded(), onError());
    }

    private Action1<? super List<ItemPresenter>> onItemLoaded() {
        return new Action1<List<ItemPresenter>>() {
            @Override
            public void call(List<ItemPresenter> itemPresenters) {
                onLoad = true;
                adapter.addItemPresenters(itemPresenters);
                view.stopProgressBar();
            }
        };
    }

    private Func1<? super GetAlbumsResponse, List<ItemPresenter>> responseToListItemPresenter() {
        return new Func1<GetAlbumsResponse, List<ItemPresenter>>() {
            @Override
            public List<ItemPresenter> call(final GetAlbumsResponse getAlbumsResponse) {
                return new ArrayList<ItemPresenter>(){{
                    for (Item item:
                            getAlbumsResponse.getResponse().getItems()) {
                        add(new AlbumPresenter(viewManager,item,new AlbumFragment(viewManager.getContext())));
                    }
                }};
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

}
