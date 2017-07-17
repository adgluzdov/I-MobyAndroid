package com.dronteam.adm.i_moby.scenarios.lobby;

import com.dronteam.adm.i_moby.UIFactory;
import com.dronteam.adm.i_moby.common.CallBack2;
import com.dronteam.adm.i_moby.common.CommonView;
import com.dronteam.adm.i_moby.common.ItemPresenter;
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
    private LobbyView view;
    private ViewManager viewManager;
    private LobbyPagerAdapter adapter = null;

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
        if(adapter == null){
            List<ItemPresenter> presenterList = new ArrayList<ItemPresenter>();
            presenterList.add((ItemPresenter)UIFactory.ShowCase(viewManager));
            presenterList.add((ItemPresenter)UIFactory.CatalogPresenter(viewManager));
            adapter = new LobbyPagerAdapter(view.getChildFragmentManager(),presenterList);
        }
        view.setFragmentStatePagerAdapter(adapter);
    }

    @Override
    public void onCreateOptionsMenu() {
        view.setToolbarTitle("Главная");
        view.setOnSubmit(new CallBack2<String>() {
            @Override
            public void call(String params) {
                viewManager.show(UIFactory.SearchGoodsPresenter(viewManager,"0",params));
            }
        });
    }
}
