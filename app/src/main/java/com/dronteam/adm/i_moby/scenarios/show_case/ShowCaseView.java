package com.dronteam.adm.i_moby.scenarios.show_case;

import android.widget.BaseAdapter;
import android.support.v7.widget.SearchView;

import com.dronteam.adm.i_moby.common.CallBack;
import com.dronteam.adm.i_moby.common.CommonToolbar;
import com.dronteam.adm.i_moby.common.CommonView;
import com.dronteam.adm.i_moby.common.CommonProgressBar;
import com.dronteam.adm.i_moby.common.SearchMenuItem;

/**
 * Created by smb on 13/12/2016.
 */

public interface ShowCaseView extends CommonView,CommonProgressBar,CommonToolbar {
    void setOnButtonCatalogClick(CallBack callBack);
    void setList(BaseAdapter adapter);
}
