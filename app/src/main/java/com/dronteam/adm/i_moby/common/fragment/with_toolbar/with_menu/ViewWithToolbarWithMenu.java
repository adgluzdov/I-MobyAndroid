package com.dronteam.adm.i_moby.common.fragment.with_toolbar.with_menu;

import com.dronteam.adm.i_moby.common.fragment.with_toolbar.ViewWithToolbar;

/**
 * Created by adm on 08.07.2017.
 */

public interface ViewWithToolbarWithMenu extends ViewWithToolbar {
    void setOnCreateOptionsMenu(OptionsMenuListener listener);
}
