package com.dronteam.adm.i_moby.scenarios.goods;

import android.widget.AbsListView;
import android.widget.BaseAdapter;

import com.dronteam.adm.i_moby.common.CommonProgressBar;
import com.dronteam.adm.i_moby.common.CommonToolBar;
import com.dronteam.adm.i_moby.common.CommonView;

/**
 * Created by smb on 18/10/2016.
 */

public interface GoodsView extends CommonView,CommonProgressBar,CommonToolBar {
    void setList(BaseAdapter adapter);
    void setOnScrollListener(AbsListView.OnScrollListener listener);
    int listViewGetLastVisiblePosition();
    int listViewGetHeaderViewsCount();
    int listViewGetFooterViewsCount();
}
