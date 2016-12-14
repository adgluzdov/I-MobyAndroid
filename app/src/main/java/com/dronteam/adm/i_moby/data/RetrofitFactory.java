package com.dronteam.adm.i_moby.data;

import android.content.Context;

import com.dronteam.adm.i_moby.common.Authentication;
import com.dronteam.adm.i_moby.common.CommonRestService;
import com.dronteam.adm.i_moby.data.VK.VKAuth;

/**
 * Created by smb on 18/10/2016.
 */

public class RetrofitFactory implements ServiceFactory {
    private final String BASE_URL = "https://api.vk.com/method/";
    private final CommonRestService commonService;

    public RetrofitFactory(Authentication auth) {
        commonService = new CommonRestService(auth, BASE_URL);
    }

    @Override
    public <T> T getApi(Class<T> service) {
        return commonService.getApi(service);
    }

}