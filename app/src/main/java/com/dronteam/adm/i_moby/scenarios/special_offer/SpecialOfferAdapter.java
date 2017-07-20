package com.dronteam.adm.i_moby.scenarios.special_offer;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.dronteam.adm.i_moby.common.adapters.ItemPresenter;
import com.dronteam.adm.i_moby.common.adapters.recycler_view_adapter.CommonRecyclerViewAdapter;
import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.common.adapters.recycler_view_adapter.CommonViewHolder;
import com.dronteam.adm.i_moby.model.special_offer.SpecialOffer;

import java.util.List;

/**
 * Created by adm on 10.07.2017.
 */

public class SpecialOfferAdapter extends CommonRecyclerViewAdapter {

    public SpecialOfferAdapter(ViewManager viewManager) {
        super(viewManager);
    }

    @Override
    public ItemPresenter createItemPresenter(int position) {
        return new SpecialOfferPresenter(getViewManager(),(SpecialOffer) getModelList().get(position),new SpecialOfferLinerLayout(getViewManager().getContext()));
    }
}

