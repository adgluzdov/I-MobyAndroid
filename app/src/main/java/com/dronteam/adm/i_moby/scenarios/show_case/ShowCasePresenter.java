package com.dronteam.adm.i_moby.scenarios.show_case;

import com.dronteam.adm.i_moby.common.CommonView;
import com.dronteam.adm.i_moby.common.PagePresenter;
import com.dronteam.adm.i_moby.common.ViewListener;
import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.common.adapters.recycler_view_adapter.CommonRecyclerViewAdapter;
import com.dronteam.adm.i_moby.common.progressbar.SwapProgressbarListener;
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

public class ShowCasePresenter implements PagePresenter, ViewListener, SwapProgressbarListener {
    private ViewManager viewManager;
    private ShowCaseView view;
    private ItemService itemService;
    private CommonRecyclerViewAdapter adapter = null;
    private List currentLoadList = new ArrayList();

    public ShowCasePresenter(ViewManager viewManager, final ShowCaseView view) {
        this.viewManager = viewManager;
        this.view = view;
        this.itemService = viewManager.getServiceFactory().getApi(ItemService.class);
        view.setOnCreateViewListener(this);
    }

    @Override
    public void OnCreateView() {
        if(adapter != null){
            view.setList(adapter);
        } else {
            startLoadSpecialOffers();
        }
        view.setSwapProgressbarListener(this);
    }

    private void startLoadSpecialOffers(){
        view.startTopProgressbar();
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
                currentLoadList.addAll(itemList);
                if(itemList.size() == 0) {
                    view.notifyNoGoods();
                }
                else {
                    adapter = new SpecialOfferAdapter(viewManager);
                    adapter.addListModel(itemList);
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

    @Override
    public String getViewTitle() {
        return "Лучшее";
    }

    @Override
    public void onSwap() {
        view.startTopProgressbar();
        itemService.SearchSpecialOffers(SpecialOffer.TAG)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .map(deleteUnnecessaryItem())
                .map(responseToListModel())
                .subscribe(onUpdate(), onError());
    }

    private Action1<? super List<SpecialOffer>> onUpdate() {
        return new Action1<List<SpecialOffer>>() {
            @Override
            public void call(List<SpecialOffer> newModelList) {
                if(!currentLoadList.equals(newModelList)){
                    adapter = null;
                    currentLoadList.clear();
                    OnLoad().call(newModelList);
                }
                view.stopTopProgressbar();
            }
        };
    }
}
