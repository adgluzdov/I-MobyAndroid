package com.dronteam.adm.i_moby.scenarios.show_case;

import android.support.v7.widget.RecyclerView;

import com.dronteam.adm.i_moby.common.CommonView;
import com.dronteam.adm.i_moby.common.progressbar.SwapProgressbarListener;
import com.dronteam.adm.i_moby.common.progressbar.TopProgressbarView;

/**
 * Created by smb on 13/12/2016.
 */

public interface ShowCaseView extends CommonView, TopProgressbarView {
    void setList(RecyclerView.Adapter<RecyclerView.ViewHolder>  adapter);
    void setOnSwapProgressbarListener(SwapProgressbarListener listener);
}
