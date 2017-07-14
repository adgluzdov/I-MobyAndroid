package com.dronteam.adm.i_moby.scenarios.show_case;

import com.dronteam.adm.i_moby.common.CommonView;
import com.dronteam.adm.i_moby.common.ItemPresenter;
import com.dronteam.adm.i_moby.common.adapters.ModelAdapter;
import com.dronteam.adm.i_moby.common.ViewListener;
import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.data.ItemService;
import com.dronteam.adm.i_moby.data.VK.json_response.get.GetResponse;
import com.dronteam.adm.i_moby.model.product.Item;
import com.dronteam.adm.i_moby.model.special_offer.SpecialOffer;
import com.dronteam.adm.i_moby.scenarios.special_offer.SpecialOfferAdapter;

import java.util.ArrayList;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by smb on 13/12/2016.
 */

public class ShowCasePresenter implements ItemPresenter, ViewListener {
    private ViewManager viewManager;
    private ShowCaseView view;
    private final ItemService itemService;
    private ModelAdapter adapter;
    private boolean onLoad = false;

    public ShowCasePresenter(ViewManager viewManager, final ShowCaseView view) {
        this.viewManager = viewManager;
        this.view = view;
        this.itemService = viewManager.getServiceFactory().getApi(ItemService.class);
        this.adapter = new SpecialOfferAdapter(viewManager);
        view.setOnCreateViewListener(this);
    }

    @Override
    public CommonView getView() {
        return view;
    }

    @Override
    public void OnCreateView() {
        if(!onLoad){
            startLoad();
        }
        view.setList(adapter.getViewAdapter(),viewManager.getContext());
    }

    private void startLoad(){
        view.startTopProgressbar();
        load();
    }

    private void load(){
        itemService.SearchSpecialOffers(SpecialOffer.TAG)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .map(deleteUnnecessaryItem())
                .map(responseToListModel())
                .subscribe(OnLoad(), onError());
    }

    private Func1<? super GetResponse, List<SpecialOffer>> responseToListModel() {
        return new Func1<GetResponse, List<SpecialOffer>>() {
            @Override
            public List<SpecialOffer> call(final GetResponse getResponse) {
                return new ArrayList<SpecialOffer>(){{
                    for (Item item : getResponse.getResponse().getItems()) {
                        add(new SpecialOffer(item));
                    }
                }};
            }
        };
    }

    private Func1<? super GetResponse, GetResponse> deleteUnnecessaryItem() {
        return new Func1<GetResponse, GetResponse>() {
            @Override
            public GetResponse call(GetResponse getResponse) {
                for (int j = getResponse.getResponse().getItems().size()-1; j >= 0; j--) {
                    if(!getResponse.getResponse().getItems().get(j).getDescription().contains(SpecialOffer.TAG))
                        getResponse.getResponse().getItems().remove(getResponse.getResponse().getItems().get(j));
                }
                return getResponse;
            }
        };
    }

    private Action1<? super List<SpecialOffer>> OnLoad() {
        return new Action1<List<SpecialOffer>>() {
            @Override
            public void call(List<SpecialOffer> itemList) {
                if(itemList.size() == 0)
                    view.notifyNoGoods();
                else
                    adapter.addListModel(itemList);
                onLoad = true;
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
    public String getViewTitle() {
        return view.getTitleFragment();
    }
}
