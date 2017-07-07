package com.dronteam.adm.i_moby.scenarios.show_case;

import android.widget.BaseAdapter;

import com.dronteam.adm.i_moby.common.CallBack;
import com.dronteam.adm.i_moby.common.CommonToolbar;
import com.dronteam.adm.i_moby.common.CommonView;
import com.dronteam.adm.i_moby.common.CommonProgressBar;

/**
 * Created by smb on 13/12/2016.
 */

public interface ShowCase extends CommonView,CommonToolbar {
    void setList(BaseAdapter adapter);

    void setOnButtonCatalogClick(CallBack callBack);
}
