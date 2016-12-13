package com.dronteam.adm.i_moby.scenarios.SpecialOffer;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.dronteam.adm.i_moby.common.ViewManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 13.12.2016.
 */

public class SpecialOfferAdapter extends BaseAdapter {
    private final List<SpecialOffer> specialOfferList;
    private final ArrayList<SpecialOfferPresenter> specialOfferPresenterList;
    ViewManager viewManager;

    SpecialOfferAdapter(ViewManager viewManager, final List<SpecialOffer> specialOfferList) {
        this.viewManager = viewManager;
        this.specialOfferList = specialOfferList;
        specialOfferPresenterList = new ArrayList<SpecialOfferPresenter>() {{
            for (int i = 0; i < specialOfferList.size(); i++) {
                add(new SpecialOfferPresenter(SpecialOfferAdapter.this.viewManager, specialOfferList.get(i)));
            }
        }};
    }


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return specialOfferList.get(position);
    }
/*
    @Override
    public long getItemId(int position) {

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return ;
    }
*/
    public SpecialOffer specialOfferFactory(int position) {
        return (SpecialOffer) getItem(position);
    }
}
