package com.dronteam.adm.i_moby.scenarios.show_case;

import android.widget.BaseAdapter;

import com.dronteam.adm.i_moby.common.CallBack;
import com.dronteam.adm.i_moby.common.CommonView;

/**
 * Created by smb on 13/12/2016.
 */

public interface ShowCaseView extends CommonView {

    void setOnButtonClick(CallBack callBack);
    void setList(BaseAdapter adapter);
}
