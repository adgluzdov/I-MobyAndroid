package com.dronteam.adm.i_moby;

import com.dronteam.adm.i_moby.common.Presenter;
import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.scenarios.item.ItemsFragment;
import com.dronteam.adm.i_moby.scenarios.item.ItemsPresenter;
import com.dronteam.adm.i_moby.scenarios.item.ItemsView;
import com.dronteam.adm.i_moby.scenarios.showcase.ShowCaseFragment;
import com.dronteam.adm.i_moby.scenarios.showcase.ShowCasePresenter;
import com.dronteam.adm.i_moby.scenarios.showcase.ShowCaseView;

/**
 * Created by smb on 13/12/2016.
 */
public class UIFactory {
    private static ShowCaseView showCaseView;
    private static ItemsView itemsView;

    public static Presenter ShowCase(ViewManager viewManager) {
        if (showCaseView == null) showCaseView = new ShowCaseFragment();
        return  new ShowCasePresenter(viewManager, showCaseView);
    }

    public static Presenter ItemsPresenter(ViewManager viewManager) {
        if (itemsView == null) itemsView = new ItemsFragment();
        return  new ItemsPresenter(viewManager, itemsView);
    }
}
