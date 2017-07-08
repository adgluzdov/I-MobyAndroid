package com.dronteam.adm.i_moby.scenarios.lobby;

import android.support.v4.app.FragmentStatePagerAdapter;

import com.dronteam.adm.i_moby.common.CommonView;
import com.dronteam.adm.i_moby.common.fragment.with_toolbar.with_menu.with_search_view.ViewWithToolbarWithSearchView;

/**
 * Created by adm on 07.07.2017.
 */

public interface LobbyView extends CommonView, ViewWithToolbarWithSearchView {
    void setFragmentStatePagerAdapter(FragmentStatePagerAdapter adapter);
}
