package com.dronteam.adm.i_moby.scenarios.show_case;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dronteam.adm.i_moby.common.CommonView;
import com.dronteam.adm.i_moby.common.progressbar.TopProgressbarView;

/**
 * Created by smb on 13/12/2016.
 */

public interface ShowCaseView extends CommonView, TopProgressbarView {
    void setList(RecyclerView.Adapter  adapter);
    void notifyNoGoods();
    void informingFailedToConnect();
}
