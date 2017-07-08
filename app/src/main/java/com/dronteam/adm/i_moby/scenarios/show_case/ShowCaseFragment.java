package com.dronteam.adm.i_moby.scenarios.show_case;

import android.support.v7.widget.RecyclerView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.dronteam.adm.i_moby.R;
import com.dronteam.adm.i_moby.common.fragment.MainFragment;
import com.dronteam.adm.i_moby.common.progressbar.SwapProgressbarListener;

/**
 * Created by smb on 13/12/2016.
 */
public class ShowCaseFragment extends MainFragment implements ShowCaseView {


    @Override
    protected int getLayout() {
        return R.layout.show_case;
    }

    @Override
    public void setList(RecyclerView.Adapter<RecyclerView.ViewHolder>  adapter)  {
        //((ListView)getView(R.id.list_view)).setAdapter(adapter);
    }

    @Override
    public void startTopProgressbar() {
        ((ProgressBar)getView(R.id.progress_bar)).setVisibility(ProgressBar.VISIBLE);
    }

    @Override
    public void stopTopProgressbar() {
        ((ProgressBar)getView(R.id.progress_bar)).setVisibility(ProgressBar.INVISIBLE);
    }

    @Override
    public void setOnSwapProgressbarListener(SwapProgressbarListener listener) {

    }
}
