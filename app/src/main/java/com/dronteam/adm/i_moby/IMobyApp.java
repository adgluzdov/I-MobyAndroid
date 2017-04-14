package com.dronteam.adm.i_moby;

import android.app.Application;
import com.vk.sdk.VKSdk;

/**
 * Created by smb on 13/12/2016.
 */

public class IMobyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        VKSdk.initialize(this);
    }
}
