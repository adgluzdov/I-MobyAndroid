package com.dronteam.adm.i_moby;

import com.dronteam.adm.i_moby.common.Presenter;
import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.model.product.Item;
import com.dronteam.adm.i_moby.scenarios.catalog.CatalogFragment;
import com.dronteam.adm.i_moby.scenarios.catalog.CatalogPresenter;
import com.dronteam.adm.i_moby.scenarios.detail_information.DetailInfoFragment;
import com.dronteam.adm.i_moby.scenarios.detail_information.DetailInfoPresenter;
import com.dronteam.adm.i_moby.scenarios.detail_information.DetailInfoView;
import com.dronteam.adm.i_moby.scenarios.goods.GoodsFragment;
import com.dronteam.adm.i_moby.scenarios.goods.GoodsPresenter;
import com.dronteam.adm.i_moby.scenarios.goods.Goods;
import com.dronteam.adm.i_moby.scenarios.show_case.ShowCaseFragment;
import com.dronteam.adm.i_moby.scenarios.show_case.ShowCasePresenter;
import com.dronteam.adm.i_moby.scenarios.show_case.ShowCase;

/**
 * Created by smb on 13/12/2016.
 */
public class UIFactory {

    private static ShowCase showCaseView;
    private static Goods goodsView;
    private static Goods searchGoodsView;
    private static DetailInfoView detailInfoView;
    private static CatalogFragment catalogView;
    private static final String QUERY_ALL = "";

    public static Presenter ShowCase(ViewManager viewManager) {
        if (showCaseView == null) showCaseView = new ShowCaseFragment();
        return  new ShowCasePresenter(viewManager, showCaseView);
    }

    public static Presenter GoodsPresenter(ViewManager viewManager,String albumId,String albumName) {
        if (goodsView == null) goodsView = new GoodsFragment();
        return  new GoodsPresenter(viewManager, goodsView, albumId,albumName,QUERY_ALL);
    }

    public static Presenter SearchGoodsPresenter(ViewManager viewManager,String albumId,String query) {
        if (searchGoodsView == null) searchGoodsView = new GoodsFragment();
        return  new GoodsPresenter(viewManager, searchGoodsView, albumId,"Поиск",query);
    }

    public static Presenter CatalogPresenter(ViewManager viewManager) {
        if (goodsView == null) catalogView = new CatalogFragment();
        return  new CatalogPresenter(viewManager, catalogView);
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
