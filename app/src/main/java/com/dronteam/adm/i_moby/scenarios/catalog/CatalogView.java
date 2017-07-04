package com.dronteam.adm.i_moby.scenarios.catalog;

import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.SearchView;

import com.dronteam.adm.i_moby.common.CallBack;
import com.dronteam.adm.i_moby.common.CommonProgressBar;
import com.dronteam.adm.i_moby.common.CommonView;

/**
 * Created by adm on 04.07.2017.
 */

public interface CatalogView extends CommonView,CommonProgressBar {

    void setList(BaseAdapter adapter);
    void setOnButtonMainAlbumClick(CallBack callBack);
}
