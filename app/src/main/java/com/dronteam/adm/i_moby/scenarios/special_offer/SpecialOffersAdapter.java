package com.dronteam.adm.i_moby.scenarios.special_offer;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.model.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 20.12.2016.
 */

public class SpecialOffersAdapter extends BaseAdapter {
    List<SpecialOfferPresenter> specialOfferPresenterList = new ArrayList<SpecialOfferPresenter>();

    public SpecialOffersAdapter(final ViewManager viewManager, final List<Item> itemList) {

        specialOfferPresenterList = new ArrayList<SpecialOfferPresenter>(){{
            for(int i=0;i<itemList.size();i++){
                add(
                        new SpecialOfferPresenter(//viewManager,
                                new SpecialOffer(itemList.get(i)),
                                new SpecialOfferFragment(viewManager.getContext()))
                );
            }
        }};
    }

    @Override
    public int getCount() {
        return specialOfferPresenterList.size();
    }

    @Override
    public Object getItem(int position) {
        return specialOfferPresenterList.get(position);
    }


    @Override
    public long getItemId(int position) {
        return specialOfferFactory(position).getItem().getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        specialOfferPresenterList.get(position).fill();
        return (View)specialOfferPresenterList.get(position).getView();
    }

    public SpecialOffer specialOfferFactory(int position) {
        return (SpecialOffer) getItem(position);
    }
}

