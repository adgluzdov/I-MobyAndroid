package com.dronteam.adm.i_moby.common;

import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by adm on 05.07.2017.
 */

public interface CommonToolBar extends SearchMenuItem {
    Toolbar getToolbar();
    void setOnCreateOptionsMenu(OptionsMenuListener listener);
}
