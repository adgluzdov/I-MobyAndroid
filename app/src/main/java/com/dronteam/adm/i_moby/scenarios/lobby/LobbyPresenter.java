package com.dronteam.adm.i_moby.scenarios.lobby;

import com.dronteam.adm.i_moby.UIFactory;
import com.dronteam.adm.i_moby.common.CallBack2;
import com.dronteam.adm.i_moby.common.CommonView;
import com.dronteam.adm.i_moby.common.PagePresenter;
import com.dronteam.adm.i_moby.common.Presenter;
import com.dronteam.adm.i_moby.common.ViewListener;
import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.common.fragment.with_toolbar.with_menu.OptionsMenuListener;
import com.dronteam.adm.i_moby.model.album.Item;

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
            List<PagePresenter> presenterList = new ArrayList<PagePresenter>();
            presenterList.add((PagePresenter)UIFactory.ShowCase(viewManager));
            presenterList.add((PagePresenter)UIFactory.CatalogPresenter(viewManager));
            adapter = new LobbyPagerAdapter(view.getChildFragmentManager(),presenterList);
        }
        view.setFragmentStatePagerAdapter(adapter);
        view.setToolbarTitle("Главная");
    }

    @Override
    public void onCreateOptionsMenu() {
        view.setOnSubmit(new CallBack2<String>() {
            @Override
            public void call(String query) {
                viewManager.show(UIFactory.SearchGoodsPresenter(viewManager,Item.ALL_GOODS,query));
            }
        });
    }
}
