package com.dronteam.adm.i_moby.scenarios.show_case;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dronteam.adm.i_moby.R;
import com.dronteam.adm.i_moby.common.fragment.MainFragment;
import com.dronteam.adm.i_moby.common.progressbar.SwapProgressbarListener;

/**
 * Created by smb on 13/12/2016.
 */
public class ShowCaseFragment extends MainFragment implements ShowCaseView {


    @Override
    protected int getLayout() {
        return R.layout.show_case2;
    }

    @Override
    public String getTitleFragment() {
        return "Kzkzk";
    }

    @Override
    public void setList(RecyclerView.Adapter adapter, Context context) {
        RecyclerView mRecyclerView = (RecyclerView) getView(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(context);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ((RecyclerView)getView(R.id.recyclerView)).setAdapter(adapter);
    }

    @Override
    public void setEmpty() {
        
    }

    @Override
    public void startTopProgressbar() {
        //((ProgressBar)getView(R.id.progress_bar)).setVisibility(ProgressBar.VISIBLE);
    }

    @Override
    public void stopTopProgressbar() {
        //((ProgressBar)getView(R.id.progress_bar)).setVisibility(ProgressBar.INVISIBLE);
    }

    @Override
    public void setOnSwapProgressbarListener(SwapProgressbarListener listener) {

    }
}
