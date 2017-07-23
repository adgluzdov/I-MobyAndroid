package com.dronteam.adm.i_moby.scenarios.goods;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.AbsListView;
import android.widget.BaseAdapter;

import com.dronteam.adm.i_moby.common.CommonView;
import com.dronteam.adm.i_moby.common.OnScrollViewListener;
import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.common.fragment.with_toolbar.with_menu.with_search_view.ViewWithToolbarWithSearchView;
import com.dronteam.adm.i_moby.common.progressbar.TopProgressbarView;
import com.dronteam.adm.i_moby.common.progressbar.UnderProgressbarView;

/**
 * Created by smb on 18/10/2016.
 */

public interface GoodsView extends CommonView,TopProgressbarView,ViewWithToolbarWithSearchView {
    void setList(RecyclerView.Adapter adapter);
    void notifyNoGoods();
    void setOnScrollListener(OnScrollViewListener listener);
    int getChildCount();
    int findFirstVisibleItemPosition();
}
