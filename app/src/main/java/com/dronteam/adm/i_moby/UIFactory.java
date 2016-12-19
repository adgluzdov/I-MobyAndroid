package com.dronteam.adm.i_moby;

import com.dronteam.adm.i_moby.common.Presenter;
import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.scenarios.SpecialOffer.SpecialOfferPresenter;
import com.dronteam.adm.i_moby.scenarios.SpecialOffer.SpecialOfferView;
import com.dronteam.adm.i_moby.scenarios.SpecialOffer.SpecialOffersFragment;
import com.dronteam.adm.i_moby.scenarios.SpecialOffer.SpecialOffersPresenter;
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
    private static SpecialOffersFragment specialOffersView;

    public static Presenter ShowCase(ViewManager viewManager) {
        if (showCaseView == null) showCaseView = new ShowcaseFragment();
        return  new ShowcasePresenter(viewManager, showCaseView);
    }

    public static Presenter ItemsPresenter(ViewManager viewManager) {
        if (itemsView == null) itemsView = new ItemsFragment();
        return  new ItemsPresenter(viewManager, itemsView);
    }
    public static Presenter SpecialOffersPresenter(ViewManager viewManager){
        if (viewManager == null) specialOffersView = new SpecialOffersFragment();
        return new SpecialOffersPresenter(viewManager, specialOffersView);
    }
}
