package com.dronteam.adm.i_moby.scenarios.catalog;

import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.dronteam.adm.i_moby.R;
import com.dronteam.adm.i_moby.common.CallBack;
import com.dronteam.adm.i_moby.common.fragment.MainFragment;

/**
 * Created by adm on 04.07.2017.
 */

public class CatalogFragment extends MainFragment implements CatalogView {
    private ListView getList(){
        return getListView(R.id.list_view);
    }
    @Override
    public void setList(BaseAdapter adapter) {
        getList().setAdapter(adapter);
    }

    @Override
    public void setOnButtonMainAlbumClick(final CallBack callBack) {
        ((Button)getView(R.id.button_open_main_album)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBack.call();
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.catalog;
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
    public String getTitleFragment() {
        return "dssdsd";
    }
}
