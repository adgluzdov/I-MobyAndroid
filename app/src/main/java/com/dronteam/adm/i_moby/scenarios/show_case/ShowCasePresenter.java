package com.dronteam.adm.i_moby.scenarios.show_case;

import android.util.Log;

import com.dronteam.adm.i_moby.UIFactory;
import com.dronteam.adm.i_moby.common.CallBack;
import com.dronteam.adm.i_moby.common.CommonAdapter;
import com.dronteam.adm.i_moby.common.CommonView;
import com.dronteam.adm.i_moby.common.ItemPresenter;
import com.dronteam.adm.i_moby.common.Presenter;
import com.dronteam.adm.i_moby.data.VK.json_response.get.GetResponse;
import com.dronteam.adm.i_moby.common.ViewListener;
import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.data.ItemService;
import com.dronteam.adm.i_moby.data.VK.json_response.getAlbums.GetAlbumsResponse;
import com.dronteam.adm.i_moby.scenarios.album.AlbumFragment;
import com.dronteam.adm.i_moby.scenarios.album.AlbumPresenter;
import com.dronteam.adm.i_moby.model.special_offer.SpecialOffer;
import com.dronteam.adm.i_moby.scenarios.special_offer.SpecialOfferFragment;
import com.dronteam.adm.i_moby.scenarios.special_offer.SpecialOfferPresenter;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

import static android.content.ContentValues.TAG;

/**
 * Created by smb on 13/12/2016.
 */

public class ShowCasePresenter implements Presenter, ViewListener {
    private ViewManager viewManager;
    private ShowCaseView view;
    private final ItemService itemService;
    private CommonAdapter adapter = null;

    private static final String ALL_GOODS = "0";

    public ShowCasePresenter(ViewManager viewManager, ShowCaseView view) {
        this.viewManager = viewManager;
        this.view = view;
        itemService = viewManager.getServiceFactory().getApi(ItemService.class);
        view.setOnCreateViewListener(this);
    }

    @Override
    public CommonView getView() {
        return view;
    }

    @Override
    public void OnCreateView() {
        if(adapter == null){
            adapter = new CommonAdapter();
            startLoad();
        }
        view.setList(adapter);
        view.setOnButtonClick(new CallBack() {
            @Override
            public void call() {
                viewManager.show(UIFactory.SearchGoodsPresenter(viewManager,ALL_GOODS));
            }
        });
        view.setOnButtonCatalogClick(new CallBack() {
            @Override
            public void call() {
                viewManager.show(UIFactory.CatalogPresenter(viewManager));
            }
        });

    }

    private void startLoad(){
        view.startProgressBar();
        load();
    }

    private void load(){
        itemService.SearchSpecialOffers()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .map(responseToListItemPresenter())
                .subscribe(OnLoad(),onError());
    }

    private Func1<? super GetResponse, List<ItemPresenter>> responseToListItemPresenter() {
        return new Func1<GetResponse, List<ItemPresenter>>() {
            @Override
            public List<ItemPresenter> call(final GetResponse getResponse) {
                return new ArrayList<ItemPresenter>() {{
                    for (final com.dronteam.adm.i_moby.model.product.Item item :
                            getResponse.getResponse().getItems()) {
                        add(new SpecialOfferPresenter(viewManager, new SpecialOffer(item), new SpecialOfferFragment(viewManager.getContext())));
                    }
                }};
            }
        };
    }

    private Action1<? super List<ItemPresenter>> OnLoad() {
        return new Action1<List<ItemPresenter>>() {
            @Override
            public void call(List<ItemPresenter> itemPresenterList) {
                adapter.addItemPresenters(0, itemPresenterList);
                view.stopProgressBar();
            }
        };
    }

    private Action1<Throwable> onError() {
        return new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Log.d(TAG, "call: ");
            }
        };
    }
}
