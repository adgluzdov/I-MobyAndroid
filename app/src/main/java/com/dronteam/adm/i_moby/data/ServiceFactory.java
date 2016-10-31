package com.dronteam.adm.i_moby.data;

import com.dronteam.adm.i_moby.common.CommonRestService;

/**
 * Created by smb on 18/10/2016.
 */

public class ServiceFactory {
    private static final String BASE_URL = "";
    private static final CommonRestService commonService = new CommonRestService(BASE_URL);

    public static <T> T  getApi(Class<T> service) {
        return commonService.getApi(service);
    }

    public static ItemService getItemServiceTest() {
        return new ItemServiceTest();
    }

}
