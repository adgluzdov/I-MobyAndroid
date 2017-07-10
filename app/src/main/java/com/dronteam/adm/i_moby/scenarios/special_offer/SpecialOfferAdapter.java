package com.dronteam.adm.i_moby.scenarios.special_offer;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.dronteam.adm.i_moby.common.CommonRecyclerViewAdapter;
import com.dronteam.adm.i_moby.common.CommonView;
import com.dronteam.adm.i_moby.common.CommonViewHolder;
import com.dronteam.adm.i_moby.common.ItemPresenter;
import com.dronteam.adm.i_moby.common.ItemView;
import com.dronteam.adm.i_moby.common.ModelAdapter;
import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.model.special_offer.SpecialOffer;

import java.util.ArrayList;
import java.util.List;

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

