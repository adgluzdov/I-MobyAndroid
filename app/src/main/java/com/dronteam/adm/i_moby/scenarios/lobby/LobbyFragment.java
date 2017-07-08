package com.dronteam.adm.i_moby.scenarios.lobby;

import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.dronteam.adm.i_moby.R;
import com.dronteam.adm.i_moby.common.fragment.with_toolbar.with_menu.with_search_view.FragmentWithToolbarWithSearchView;

/**
 * Created by danreegly on 08.07.17.
 */

public class LobbyFragment extends FragmentWithToolbarWithSearchView implements LobbyView {
    @Override
    public void setFragmentStatePagerAdapter(FragmentStatePagerAdapter adapter) {
        ((ViewPager)getView(R.id.pager)).setAdapter(adapter);
    }

    @Override
    protected int getIdSearchView() {
        return R.id.action_search;
    }

    @Override
    protected int getIdToolbar() {
        return R.id.toolbar;
    }

    @Override
    protected int getMenuXml() {
        return R.menu.search_menu;
    }

    @Override
    protected int getLayout() {
        return R.layout.page_lobby;
    }
}
