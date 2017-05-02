package com.dronteam.adm.i_moby.data.VK.json_response.messages.send;

/**
 * Created by adm on 02.05.2017.
 */

public class MessegesSendResponse {
    public int getResponse() {
        return response;
    }

    public void setResponse(int response) {
        this.response = response;
    }

    public MessegesSendResponse(int response) {
        this.response = response;
    }

    public int response;
}
