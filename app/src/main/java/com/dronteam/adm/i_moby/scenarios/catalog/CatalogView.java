package com.dronteam.adm.i_moby.scenarios.catalog;

import android.widget.BaseAdapter;

import com.dronteam.adm.i_moby.common.CallBack;
import com.dronteam.adm.i_moby.common.CommonView;
import com.dronteam.adm.i_moby.common.progressbar.TopProgressbarView;

/**
 * Created by adm on 04.07.2017.
 */

public interface CatalogView extends CommonView,TopProgressbarView {
    void setList(BaseAdapter adapter);

    void setOnButtonMainAlbumClick(CallBack callBack);
}
