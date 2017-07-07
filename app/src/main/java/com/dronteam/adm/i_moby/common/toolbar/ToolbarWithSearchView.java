package com.dronteam.adm.i_moby.common.toolbar;

import android.support.v7.widget.SearchView;
import android.telecom.RemoteConnection;
import com.dronteam.adm.i_moby.common.CallBack;

/**
 * Created by adm on 05.07.2017.
 */

public interface ToolbarWithSearchView extends CommonToolbar {
    void setQuery(String query);
    void setActive();
    void setOnSubmit(CallBack OnSubmit);
    void setOnClose(CallBack OnClose);
}
