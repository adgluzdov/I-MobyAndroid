package com.dronteam.adm.i_moby.common;

import java.io.IOException;

import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

/**
 * Created by smb on 14/04/2017.
 */

class CommonAuthenticator implements Authenticator {

    private Authentication auth;

    public CommonAuthenticator(Authentication auth) {
        this.auth = auth;
    }

    @Override
    public Request authenticate(Route route, Response response) throws IOException {
        return response.request().newBuilder().header("Authorization", auth.getToken()).build();
    }
}
