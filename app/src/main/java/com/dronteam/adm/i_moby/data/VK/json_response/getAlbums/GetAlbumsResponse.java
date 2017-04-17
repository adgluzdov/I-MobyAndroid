package com.dronteam.adm.i_moby.data.VK.json_response.getAlbums;

/**
 * Created by adm on 17.04.2017.
 */

public class GetAlbumsResponse {
    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public GetAlbumsResponse(Response response) {

        this.response = response;
    }

    public Response response;

}
