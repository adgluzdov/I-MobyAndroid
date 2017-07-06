package com.dronteam.adm.i_moby.common;

import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by adm on 05.07.2017.
 */

public interface CommonToolbar extends SearchMenuItem {
    void setOnCreateOptionsMenu(OptionsMenuListener listener);
    void setTitle(String title);
}
