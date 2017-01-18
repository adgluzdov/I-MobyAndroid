package com.dronteam.adm.i_moby.scenarios.special_offer;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.dronteam.adm.i_moby.common.ViewManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 20.12.2016.
 */

public class SpecialOffersAdapter extends BaseAdapter {
    private ViewManager viewManager;
    List<SpecialOffer> specialOfferList;
    List<SpecialOfferPresenter> specialOfferPresenterList = new ArrayList<SpecialOfferPresenter>();

    public SpecialOffersAdapter(ViewManager viewManager, final List<SpecialOffer> specialOfferList) {
        this.viewManager = viewManager;
        this.specialOfferList = specialOfferList;
        specialOfferPresenterList = new ArrayList<SpecialOfferPresenter>(){{
            for(int i=0;i<specialOfferList.size();i++){
                add(
                        new SpecialOfferPresenter(SpecialOffersAdapter.this.viewManager,
                                specialOfferList.get(i))
                );
            }
        }};

    }

    @Override
    public int getCount() {
        return specialOfferList.size();
    }

    @Override
    public Object getItem(int position) {
        return specialOfferList.get(position);
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

