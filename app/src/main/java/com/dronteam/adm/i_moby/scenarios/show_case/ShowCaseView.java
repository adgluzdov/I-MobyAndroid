package com.dronteam.adm.i_moby.scenarios.show_case;

import android.widget.BaseAdapter;

import com.dronteam.adm.i_moby.common.CommonView;
import com.dronteam.adm.i_moby.common.progressbar.CommonProgressbar;

/**
 * Created by smb on 13/12/2016.
 */

public interface ShowCaseView extends CommonView, CommonProgressbar {
    void setList(BaseAdapter adapter);
}
