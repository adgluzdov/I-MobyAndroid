package com.dronteam.adm.i_moby.common.fragment.with_toolbar.with_menu.with_search_view;

import com.dronteam.adm.i_moby.common.CallBack;
import com.dronteam.adm.i_moby.common.CallBack2;
import com.dronteam.adm.i_moby.common.fragment.with_toolbar.with_menu.ViewWithToolbarWithMenu;

/**
 * Created by adm on 05.07.2017.
 */

public interface ViewWithToolbarWithSearchView extends ViewWithToolbarWithMenu {
    void setQuery(String query,Boolean bool);
    void setActive();
    void setOnSubmit(CallBack2<String> onSubmit);
    void setOnClose(CallBack onClose);
}
