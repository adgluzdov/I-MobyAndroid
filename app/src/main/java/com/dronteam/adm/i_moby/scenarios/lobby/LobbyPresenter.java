package com.dronteam.adm.i_moby.scenarios.lobby;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.dronteam.adm.i_moby.UIFactory;
import com.dronteam.adm.i_moby.common.CommonView;
import com.dronteam.adm.i_moby.common.Presenter;
import com.dronteam.adm.i_moby.common.ViewListener;
import com.dronteam.adm.i_moby.common.ViewManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adm on 07.07.2017.
 */

public class LobbyPresenter implements Presenter, ViewListener {
    LobbyView view;
    ViewManager viewManager;
    FragmentStatePagerAdapter adapter;

    public LobbyPresenter(LobbyView view, ViewManager viewManager) {
        this.view = view;
        this.viewManager = viewManager;
        view.setOnCreateViewListener(this);
    }

    @Override
    public CommonView getView() {
        return null;
    }

    @Override
    public void OnCreateView() {
        List<Presenter> presenterList = new ArrayList<Presenter>();
        presenterList.add(UIFactory.ShowCase(viewManager));
        presenterList.add(UIFactory.CatalogPresenter(viewManager));
        adapter = new LobbyPagerAdapter(viewManager.getSupportFragmentManager(),presenterList);
        view.setFragmentStatePagerAdapter(adapter);
    }
}
