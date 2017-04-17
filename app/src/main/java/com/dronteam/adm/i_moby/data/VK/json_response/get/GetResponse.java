package com.dronteam.adm.i_moby.data.VK.json_response.get;

/**
 * Created by adm on 05.11.2016.
 */
public class GetResponse {
    public Response response;

    public GetResponse(Response response) {
        this.setResponse(response);
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
