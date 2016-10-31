package com.dronteam.adm.i_moby.common;

import retrofit2.Retrofit;

/**
 * Created by smb on 18/10/2016.
 */

public class CommonRestService {
    private final Retrofit retrofit;

    public CommonRestService(String baseUrl) {
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                //.addConverterFactory(GsonConverterFactory.create())
                //.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public <T> T getApi(Class<T> service) {
        return retrofit.create(service);

    }
}
