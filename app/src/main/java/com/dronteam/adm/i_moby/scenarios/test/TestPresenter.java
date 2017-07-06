package com.dronteam.adm.i_moby.scenarios.test;

import android.content.Context;
import android.view.View;
import android.widget.Button;

import com.dronteam.adm.i_moby.common.CommonView;
import com.dronteam.adm.i_moby.common.Presenter;
import com.dronteam.adm.i_moby.common.ViewListener;

/**
 * Created by adm on 06.07.2017.
 */

public class TestPresenter implements Presenter, ViewListener{

    TestView view;

    public TestPresenter(TestView view) {
        this.view = view;
        view.setOnCreateListener(this);
        view.setTitle("kkk");
    }

    @Override
    public CommonView getView() {
        return view;
    }

    @Override
    public void OnCreateView() {
        // слушатель на кнопку
    }
}
