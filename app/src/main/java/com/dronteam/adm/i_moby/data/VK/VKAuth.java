package com.dronteam.adm.i_moby.data.VK;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.dronteam.adm.i_moby.common.Authentication;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;

/**
 * Created by smb on 13/12/2016.
 */

//Todo: Этот класс надо серьезно доработать. Обработать ошибки авторизации и реализовать обновление токена в слчуае ошибки его валидации.

public class VKAuth implements Authentication {

    private VKAccessToken token;

    public VKAuth(Activity activity) {
        VKSdk.login(activity, "market");
    }

    @Override
    public String getToken() {

        String accessToken = null;
        if (token != null) {
            accessToken = token.accessToken;
        }
        return accessToken;
    }

    @Override
    public boolean IsLoggedIn() {
        return token != null;
    }

    public void ActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken result) {
                token = result;
            }
            @Override
            public void onError(VKError error) {

            }
        }));
    }

}
