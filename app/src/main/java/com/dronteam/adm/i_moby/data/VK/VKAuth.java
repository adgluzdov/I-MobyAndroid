package com.dronteam.adm.i_moby.data.VK;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.dronteam.adm.i_moby.common.Authentication;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKAccessTokenTracker;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;

import static android.content.ContentValues.TAG;
import static com.vk.sdk.VKSdk.LoginState.LoggedIn;
import static com.vk.sdk.VKSdk.LoginState.LoggedOut;

/**
 * Created by smb on 13/12/2016.
 */

//Todo: Этот класс надо серьезно доработать. Обработать ошибки авторизации.
//Todo: Непонятно что делать ошибкой повторной авторизации. По-сути это ошибка ВК.

public class VKAuth implements Authentication {

    private VKAccessToken token;
    private final String BASE_URL = "https://api.vk.com/method/";

    public VKAuth(Activity activity) {
        if (!VKSdk.isLoggedIn()) {
            VKSdk.login(activity, "market", "offline");
        }
        else
        {
            token = VKAccessToken.currentToken();
        }
/*
        // Достаём токен из VKSDK
        token = VKAccessToken.currentToken();
        // Если НЕ залогинено - Аутентифицируемся
        if(!IsLoggedIn()) Authentication(activity);
        // Если залогинено - Обновляем токен
        else RefreshToken(activity);
*/
    }

    private void Authentication(Activity activity) {
        VKSdk.login(activity, "market", "offline");
    }

    public void RefreshToken(final Activity activity) {
        VKSdk.wakeUpSession(activity,new VKCallback<VKSdk.LoginState>() {
            @Override
            public void onResult(VKSdk.LoginState res) {
                // Если токен НЕ Валиден - Аутентифицируемся по новой
                if(res == LoggedOut) {
                    Authentication(activity);
                }
            }

            @Override
            public void onError(VKError error) {

            }
        });
    }

    @Override
    public String getToken() {
        return token.accessToken;
    }

    @Override
    public boolean IsLoggedIn() {
        return token != null;
    }

    @Override
    public String getBaseUrl() {
        return BASE_URL;
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
