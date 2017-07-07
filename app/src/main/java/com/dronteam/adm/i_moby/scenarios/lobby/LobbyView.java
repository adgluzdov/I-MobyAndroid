package com.dronteam.adm.i_moby.scenarios.lobby;

import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.Toolbar;

import com.dronteam.adm.i_moby.common.toolbar.CommonToolbar;
import com.dronteam.adm.i_moby.common.CommonView;
import com.dronteam.adm.i_moby.common.toolbar.ToolbarWithSearchView;

/**
 * Created by adm on 07.07.2017.
 */

public interface LobbyView extends CommonView, ToolbarWithSearchView {
    void setFragmentStatePagerAdapter(FragmentStatePagerAdapter adapter);
}
