package com.dronteam.adm.i_moby.scenarios.lobby;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.dronteam.adm.i_moby.common.Presenter;
import com.dronteam.adm.i_moby.model.album.Item;
import com.dronteam.adm.i_moby.scenarios.album.AlbumFragment;
import com.dronteam.adm.i_moby.scenarios.album.AlbumPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adm on 07.07.2017.
 */

public class LobbyPagerAdapter extends FragmentStatePagerAdapter {

    private List<Presenter> presenterList = null;

    public LobbyPagerAdapter(FragmentManager fm, List<Presenter> presenterList) {
        super(fm);
        this.presenterList = presenterList;
    }

    @Override
    public Fragment getItem(int position) {
        return (Fragment) presenterList.get(position);
    }

    @Override
    public int getCount() {
        return presenterList.size();
    }
}
