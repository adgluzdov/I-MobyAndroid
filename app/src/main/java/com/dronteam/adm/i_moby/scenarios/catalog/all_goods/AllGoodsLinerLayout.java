package com.dronteam.adm.i_moby.scenarios.catalog.all_goods;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.dronteam.adm.i_moby.R;

/**
 * Created by danreegly on 12.07.17.
 */

public class AllGoodsLinerLayout extends LinearLayout implements AllGoodsView {

    public AllGoodsLinerLayout(Context context) {
        super(context);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.all_goods_button, this);
        view.setLayoutParams(new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    @Override
    public View getView() {
        return this;
    }

    @Override
    public void setOnButtonClickListener(OnClickListener listener) {
        findViewById(R.id.pay).setOnClickListener(listener);
    }
}
