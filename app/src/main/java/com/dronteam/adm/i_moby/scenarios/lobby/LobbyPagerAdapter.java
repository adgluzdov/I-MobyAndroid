package com.dronteam.adm.i_moby.scenarios.lobby;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.dronteam.adm.i_moby.common.PagePresenter;

import java.util.List;

/**
 * Created by adm on 07.07.2017.
 */

public class LobbyPagerAdapter extends FragmentStatePagerAdapter {

    private List<PagePresenter> presenterList = null;


    public LobbyPagerAdapter(FragmentManager fm, List<PagePresenter> presenterList) {
        super(fm);
        this.presenterList = presenterList;
    }

    @Override
    public Fragment getItem(int position) {
        return presenterList.get(position).getView().getFragment();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return presenterList.get(position).getViewTitle();
    }

    @Override
    public int getCount() {
        return presenterList.size();
    }
}
