package com.dronteam.adm.i_moby.common;

import android.app.Fragment;

/**
 * Created by smb on 18/10/2016.
 */
public interface CommonView {
    void setOnCreateViewListener(ViewListener listener);
    Fragment getFragment();
}
