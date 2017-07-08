package com.dronteam.adm.i_moby.scenarios.lobby;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.dronteam.adm.i_moby.UIFactory;
import com.dronteam.adm.i_moby.common.CallBack2;
import com.dronteam.adm.i_moby.common.CommonView;
import com.dronteam.adm.i_moby.common.Presenter;
import com.dronteam.adm.i_moby.common.ViewListener;
import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.common.fragment.with_toolbar.with_menu.OptionsMenuListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adm on 07.07.2017.
 */

public class LobbyPresenter implements Presenter, ViewListener,OptionsMenuListener {
    LobbyView view;
    ViewManager viewManager;
    LobbyPagerAdapter adapter;

    public LobbyPresenter(LobbyView view, ViewManager viewManager) {
        this.view = view;
        this.viewManager = viewManager;
        view.setOnCreateViewListener(this);
        view.setOnCreateOptionsMenu(this);
    }

    @Override
    public CommonView getView() {
        return view;
    }

    @Override
    public void OnCreateView() {
        view.setTitle("Главная");
        List<Presenter> presenterList = new ArrayList<Presenter>();
        presenterList.add(UIFactory.ShowCase(viewManager));
        presenterList.add(UIFactory.CatalogPresenter(viewManager));
        adapter = new LobbyPagerAdapter(viewManager.getSupportFragmentManager(),presenterList);
        view.setFragmentStatePagerAdapter(adapter);
    }

    @Override
    public void onCreateOptionsMenu() {
        view.setOnSubmit(new CallBack2<String>() {
            @Override
            public void call(String params) {
                viewManager.show(UIFactory.SearchGoodsPresenter(viewManager,"0",params));
            }
        });
    }
}
