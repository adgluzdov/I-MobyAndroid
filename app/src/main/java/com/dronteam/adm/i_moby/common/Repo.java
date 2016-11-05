package com.dronteam.adm.i_moby.common;

import com.dronteam.adm.i_moby.model.Response;

/**
 * Created by adm on 05.11.2016.
 */
public class Repo {
    public Response response;

    public Repo(Response response) {
        this.setResponse(response);
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
