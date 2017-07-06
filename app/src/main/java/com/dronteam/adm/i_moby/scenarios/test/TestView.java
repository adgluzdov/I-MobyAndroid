package com.dronteam.adm.i_moby.scenarios.test;

import android.app.Fragment;

import com.dronteam.adm.i_moby.common.CommonView;
import com.dronteam.adm.i_moby.common.ViewListener;

/**
 * Created by adm on 06.07.2017.
 */

public interface TestView extends CommonView{
    void setTitle(String title);
    void setOnCreateListener(ViewListener listener);
}
