package com.dronteam.adm.i_moby.common.progressbar;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.dronteam.adm.i_moby.R;
import com.dronteam.adm.i_moby.common.adapters.ItemView;

/**
 * Created by adm on 14.07.2017.
 */

public class ProgressbarLinerLayout extends LinearLayout implements ItemView {
    public ProgressbarLinerLayout(Context context) {
        super(context);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_progress, this);
        view.setLayoutParams(new ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
        );
    }

    @Override
    public View getView() {
        return this;
    }
}
