package com.dronteam.adm.i_moby.scenarios.show_case;

import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;

import com.dronteam.adm.i_moby.R;
import com.dronteam.adm.i_moby.common.CallBack;
import com.dronteam.adm.i_moby.common.MainFragment;

/**
 * Created by smb on 13/12/2016.
 */
public class ShowCaseFragment extends MainFragment implements ShowCaseView {

    @Override
    protected int getLayout() {
        return R.layout.show_case;
    }

    @Override
    public void setOnButtonClick(final CallBack callBack) {
        getButton(R.id.button_open_search_goods).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.call();
            }
        });
    }

    @Override
    public void setOnButtonCatalogClick(final CallBack callBack) {
        getButton(R.id.button_open_catalog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBack.call();
            }
        });
    }

    @Override
    public void setList(BaseAdapter adapter)  {
        getListView(R.id.list_view).setAdapter(adapter);
    }

    @Override
    public void startProgressBar() {
        ((ProgressBar)getView(R.id.progress_bar)).setVisibility(ProgressBar.VISIBLE);
    }

    @Override
    public void stopProgressBar() {
        ((ProgressBar)getView(R.id.progress_bar)).setVisibility(ProgressBar.INVISIBLE);
    }

    @Override
    public void startUnderProgressBar() {

    }

    @Override
    public void stopUnderProgressBar() {

    }
}
