package com.dronteam.adm.i_moby.scenarios.lobby;

import android.support.v4.app.FragmentStatePagerAdapter;

import com.dronteam.adm.i_moby.common.CommonProgressBar;
import com.dronteam.adm.i_moby.common.CommonToolbar;
import com.dronteam.adm.i_moby.common.CommonView;

/**
 * Created by adm on 07.07.2017.
 */

public interface LobbyView extends CommonView, CommonToolbar {
    void setFragmentStatePagerAdapter(FragmentStatePagerAdapter adapter);
}
