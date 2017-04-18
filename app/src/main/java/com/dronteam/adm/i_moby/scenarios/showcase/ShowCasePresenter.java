package com.dronteam.adm.i_moby.scenarios.showcase;

import android.util.Log;

import com.dronteam.adm.i_moby.common.CommonView;
import com.dronteam.adm.i_moby.common.Presenter;
import com.dronteam.adm.i_moby.data.VK.json_response.get.GetResponse;
import com.dronteam.adm.i_moby.common.ViewListener;
import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.data.ItemService;
import com.dronteam.adm.i_moby.data.VK.json_response.getAlbums.GetAlbumsResponse;
import com.dronteam.adm.i_moby.model.item.Item;
import com.dronteam.adm.i_moby.scenarios.album.AlbumsAdapter;
import com.dronteam.adm.i_moby.scenarios.special_offer.SpecialOffer;
import com.dronteam.adm.i_moby.scenarios.special_offer.SpecialOffersAdapter;

import java.util.ArrayList;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by smb on 13/12/2016.
 */
public class ShowCasePresenter implements Presenter, ViewListener {
    private static final String TAG = "My";
    private ViewManager viewManager;
    private ShowCaseView view;
    private final ItemService itemService;
    //private ServiceFactory serviceFactory;

    public ShowCasePresenter(ViewManager viewManager, ShowCaseView view) {
        this.viewManager = viewManager;
        this.view = view;
        //serviceFactory = new RetrofitFactory();
        itemService = viewManager.getServiceFactory().getApi(ItemService.class);
        view.setOnCreateViewListener(this);
    }

    @Override
    public CommonView getView() {
        return view;
    }

    @Override
    public void OnCreateView() {
        /*itemService.Search()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(onSpecialOffersLoaded(), onError());*/
        itemService.GetAlbums()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(onAlbumsLoaded(), onError());
    }

    private Action1<? super GetAlbumsResponse> onAlbumsLoaded() {
        return new Action1<GetAlbumsResponse>() {
            @Override
            public void call(final GetAlbumsResponse getAlbumsResponse) {
                Log.d(TAG, "call: success - onAlbumsLoaded()");
                AlbumsAdapter albumsAdapter = getAlbumsAdapter(getAlbumsResponse.getResponse().getItems());
                view.setList(albumsAdapter);
            }
        };
    }

    private Action1<? super GetResponse> onSpecialOffersLoaded() {
        return new Action1<GetResponse>() {
            @Override
            public void call(final GetResponse repo) {
                Log.d(TAG, "call: success - onSpecialOffersLoaded()");
                SpecialOffersAdapter specialOffersAdapter = getSpecialOffersAdapter(new ArrayList<SpecialOffer>(){
                    {
                        for (Item object: repo.getResponse().getItems()) {
                            add(new SpecialOffer(object));
                        }
                    }
                });
                view.setList(specialOffersAdapter);
            }
        };
    }

    private Action1<Throwable> onError() {
        return new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Log.d(TAG, "call: error in ShowCasePresenter");
            }
        };
    }

    private SpecialOffersAdapter getSpecialOffersAdapter(List<SpecialOffer> items) {
        return new SpecialOffersAdapter(viewManager,items);
    }

    private AlbumsAdapter getAlbumsAdapter(List<com.dronteam.adm.i_moby.model.album.Item> items) {
        return new AlbumsAdapter(viewManager,items);
    }
}
