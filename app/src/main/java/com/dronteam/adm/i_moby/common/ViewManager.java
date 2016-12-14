package com.dronteam.adm.i_moby.common;

import android.content.Context;

import com.dronteam.adm.i_moby.data.ServiceFactory;

/**
 * Created by smb on 13/12/2016.
 */

public interface ViewManager {
    void show(Presenter presenter);
    ServiceFactory getServiceFactory();
    Context getContext();
}