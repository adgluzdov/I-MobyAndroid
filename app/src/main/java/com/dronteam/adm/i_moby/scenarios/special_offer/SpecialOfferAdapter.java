package com.dronteam.adm.i_moby.scenarios.special_offer;

import com.dronteam.adm.i_moby.common.adapters.recycler_view_adapter.CommonRecyclerViewAdapter;
import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.model.special_offer.SpecialOffer;

/**
 * Created by adm on 10.07.2017.
 */

public class SpecialOfferAdapter extends CommonRecyclerViewAdapter<SpecialOffer,SpecialOfferView,SpecialOfferPresenter> {

    public SpecialOfferAdapter(ViewManager viewManager) {
        super(viewManager);
    }

    @Override
    public SpecialOfferPresenter createPresenter(SpecialOffer offer, SpecialOfferView view) {
        return new SpecialOfferPresenter(getViewManager(),offer,view);
    }

    @Override
    public SpecialOfferView createView() {
        return new SpecialOfferLinerLayout(getViewManager().getContext());
    }
}

