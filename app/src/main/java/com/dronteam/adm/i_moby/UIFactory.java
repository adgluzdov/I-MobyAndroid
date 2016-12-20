package com.dronteam.adm.i_moby;

import com.dronteam.adm.i_moby.common.Presenter;
import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.scenarios.detail_information.DetailInfoPresenter;
import com.dronteam.adm.i_moby.scenarios.item.ItemsFragment;
import com.dronteam.adm.i_moby.scenarios.item.ItemsPresenter;
import com.dronteam.adm.i_moby.scenarios.item.ItemsView;
import com.dronteam.adm.i_moby.scenarios.showcase.ShowcaseFragment;
import com.dronteam.adm.i_moby.scenarios.showcase.ShowcasePresenter;
import com.dronteam.adm.i_moby.scenarios.showcase.ShowcaseView;

/**
 * Created by smb on 13/12/2016.
 */
public class UIFactory {
    private static ShowcaseView showCaseView;
    private static ItemsView itemsView;

    public static Presenter ShowCase(ViewManager viewManager) {
        if (showCaseView == null) showCaseView = new ShowcaseFragment();
        return  new ShowcasePresenter(viewManager, showCaseView);
    }

    public static Presenter ItemsPresenter(ViewManager viewManager) {
        if (itemsView == null) itemsView = new ItemsFragment();
        return  new ItemsPresenter(viewManager, itemsView);
    }

    public static Presenter DetailInfo(ViewManager viewManager) {
        if (viewManager == null) detailInfoView = new detailInfoFragment();
        return new DetailInfoPresenter(viewManager, detailInfoView);
    }
}
