package com.dronteam.adm.i_moby.scenarios.show_case;

import android.widget.BaseAdapter;

import com.dronteam.adm.i_moby.common.CallBack;
import com.dronteam.adm.i_moby.common.CommonToolBar;
import com.dronteam.adm.i_moby.common.CommonView;
import com.dronteam.adm.i_moby.common.CommonProgressBar;

/**
 * Created by smb on 13/12/2016.
 */

public interface ShowCaseView extends CommonView,CommonProgressBar,CommonToolBar {
    void setList(BaseAdapter adapter);

    void setOnButtonCatalogClick(CallBack callBack);
}
