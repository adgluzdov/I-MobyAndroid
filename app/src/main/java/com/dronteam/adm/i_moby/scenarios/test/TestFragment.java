package com.dronteam.adm.i_moby.scenarios.test;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dronteam.adm.i_moby.R;
import com.dronteam.adm.i_moby.common.MainFragment;
import com.dronteam.adm.i_moby.common.ViewListener;

/**
 * Created by adm on 06.07.2017.
 */

public class TestFragment extends MainFragment implements TestView{
    ViewListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // предупредить презентера
        listener.OnCreateView();
        return super.onCreateView(inflater,container,savedInstanceState);
    }

    @Override
    protected int getLayout() {
        return R.layout.show_case;
    }

    @Override
    public void setTitle(String title) {

    }

    @Override
    public void setOnCreateListener(ViewListener listener) {
        this.listener = listener;
    }
}
