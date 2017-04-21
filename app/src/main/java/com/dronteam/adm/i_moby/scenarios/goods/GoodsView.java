package com.dronteam.adm.i_moby.scenarios.goods;

import android.widget.BaseAdapter;

import com.dronteam.adm.i_moby.common.CommonView;

/**
 * Created by smb on 18/10/2016.
 */

public interface GoodsView extends CommonView {
    void setList(BaseAdapter adapter);
}
