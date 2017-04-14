package com.dronteam.adm.i_moby.common;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

/**
 * Created by smb on 14/04/2017.
 */

class CommonAuthenticator implements Interceptor {

    private Authentication auth;

    public CommonAuthenticator(Authentication auth) {
        this.auth = auth;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl url = request.url().newBuilder().addQueryParameter("access_token",auth.getToken()).build();
        request = request.newBuilder().url(url).build();
        return chain.proceed(request);
    }
}
