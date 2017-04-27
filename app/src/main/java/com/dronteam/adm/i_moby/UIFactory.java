package com.dronteam.adm.i_moby;

import com.dronteam.adm.i_moby.common.Presenter;
import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.model.product.Item;
import com.dronteam.adm.i_moby.scenarios.detail_information.DetailInfoFragment;
import com.dronteam.adm.i_moby.scenarios.detail_information.DetailInfoPresenter;
import com.dronteam.adm.i_moby.scenarios.detail_information.DetailInfoView;
import com.dronteam.adm.i_moby.scenarios.goods.GoodsFragment;
import com.dronteam.adm.i_moby.scenarios.goods.GoodsPresenter;
import com.dronteam.adm.i_moby.scenarios.goods.GoodsView;
import com.dronteam.adm.i_moby.scenarios.search_goods.SearchGoodsFragment;
import com.dronteam.adm.i_moby.scenarios.search_goods.SearchGoodsPresenter;
import com.dronteam.adm.i_moby.scenarios.search_goods.SearchGoodsView;
import com.dronteam.adm.i_moby.scenarios.show_case.ShowCaseFragment;
import com.dronteam.adm.i_moby.scenarios.show_case.ShowCasePresenter;
import com.dronteam.adm.i_moby.scenarios.show_case.ShowCaseView;

/**
 * Created by smb on 13/12/2016.
 */
public class UIFactory {
    private static ShowCaseView showCaseView;
    private static GoodsView goodsView;
    private static SearchGoodsView searchGoodsView;
    private static DetailInfoView detailInfoView;

    public static Presenter ShowCase(ViewManager viewManager) {
        if (showCaseView == null) showCaseView = new ShowCaseFragment();
        return  new ShowCasePresenter(viewManager, showCaseView);
    }

    public static Presenter GoodsPresenter(ViewManager viewManager,String albumId) {
        if (goodsView == null) goodsView = new GoodsFragment();
        return  new GoodsPresenter(viewManager, goodsView, albumId);
    }
    public static Presenter GoodsPresenter(ViewManager viewManager) {
        if (goodsView == null) goodsView = new GoodsFragment();
        return  new GoodsPresenter(viewManager, goodsView, "0");
    }

    public static Presenter SearchGoodsPresenter(ViewManager viewManager) {
        if (searchGoodsView == null) searchGoodsView = new SearchGoodsFragment();
        return  new SearchGoodsPresenter(viewManager, searchGoodsView);
    }

    public static Presenter DetailInfoPresenter(ViewManager viewManager, Item product) {
        if (detailInfoView == null) detailInfoView = new DetailInfoFragment();
        return  new DetailInfoPresenter(viewManager, product, detailInfoView);
    }
/*
    public static Presenter DetailInfo(ViewManager viewManager) {
        if (viewManager == null) detailInfoView = new detailInfoFragment();
        return new DetailInfoPresenter(viewManager, detailInfoView);
    }
    */
}
