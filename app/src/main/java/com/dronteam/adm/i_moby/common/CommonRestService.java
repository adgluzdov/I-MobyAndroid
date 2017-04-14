package com.dronteam.adm.i_moby.common;

import okhttp3.Authenticator;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by smb on 18/10/2016.
 */

public class CommonRestService {
    private final Retrofit retrofit;

    public CommonRestService(Authentication auth, String baseUrl) {
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(httpClient(auth))
                .build();
    }

    public <T> T getApi(Class<T> service) {
        return retrofit.create(service);

    }

    private OkHttpClient httpClient(Authentication auth) {
        OkHttpClient client = new OkHttpClient
                .Builder()
                .authenticator(getAuthenticator(auth))
                .build();
        return client;
    }

    public Authenticator getAuthenticator(Authentication auth) {
        return new CommonAuthenticator(auth);
    }
}
