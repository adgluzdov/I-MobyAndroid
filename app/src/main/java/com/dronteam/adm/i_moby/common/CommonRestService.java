package com.dronteam.adm.i_moby.common;

import java.io.IOException;
import java.net.Authenticator;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by smb on 18/10/2016.
 */

public class CommonRestService {
    private final Retrofit retrofit;
    private Authentication auth;

    public CommonRestService(Authentication auth, String baseUrl) {
        this.auth = auth;
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(httpClient())
                .build();
    }

    private OkHttpClient httpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(
                        new Interceptor() {
                            @Override
                            public Response intercept(Chain chain) throws IOException {
                                Request.Builder ongoing = chain.request().newBuilder();
                                //ongoing.addHeader("Accept", "application/json;versions=1");
                                if (auth.IsLoggedIn()) {
                                    HttpUrl url = chain.request().url().newBuilder().addQueryParameter("access_token", auth.getToken()).build();
                                    ongoing.url(url);
                                    //ongoing.addHeader("Authorization", auth.getToken());
                                }
                                return chain.proceed(ongoing.build());
                            }
                        })
                .build();
    }

    public <T> T getApi(Class<T> service) {
        return retrofit.create(service);

    }
}
