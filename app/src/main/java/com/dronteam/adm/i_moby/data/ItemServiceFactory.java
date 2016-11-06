package com.dronteam.adm.i_moby.data;

import com.dronteam.adm.i_moby.common.CommonRestService;

/**
 * Created by smb on 18/10/2016.
 */

public class ItemServiceFactory implements ItemServiceApi {
    private static final String BASE_URL = "https://api.vk.com/method/";
    private static final CommonRestService commonService = new CommonRestService(BASE_URL);

    @Override
    public <T> T getApi(Class<T> service) {
        return commonService.getApi(service);
    }

}