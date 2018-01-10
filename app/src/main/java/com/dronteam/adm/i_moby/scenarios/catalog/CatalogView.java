package com.dronteam.adm.i_moby.scenarios.catalog;

import android.support.v7.widget.RecyclerView;

import com.dronteam.adm.i_moby.common.CommonView;
import com.dronteam.adm.i_moby.common.progressbar.TopProgressbarView;

/**
 * Created by adm on 04.07.2017.
 */

public interface CatalogView extends CommonView,TopProgressbarView {
    void setList(RecyclerView.Adapter adapter);
    void informingFailedToConnect();
}
