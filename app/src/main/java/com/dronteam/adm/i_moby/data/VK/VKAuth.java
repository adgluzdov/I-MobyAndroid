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

//Todo: Этот класс надо серьезно доработать. Обработать ошибки авторизации и реализовать обновление токена в слчуае ошибки его валидации.

public class VKAuth implements Authentication {

    private VKAccessToken token;

    public VKAuth(final Activity activity) {
        // Достаём токен из SDK
        token = VKAccessToken.currentToken();
        // Если НЕ залогинено - Авторизуемся
        if(!IsLoggedIn()) Authorization(activity);
        // Если залогинено - Аутентифицируемся
        else Authentication(activity,new VKCallback<VKSdk.LoginState>() {
            @Override
            public void onResult(VKSdk.LoginState res) {
                // Если токен НЕ Валиден - Авторизируемся по новой
                if(res == LoggedOut) {
                    LogOut();
                    Authorization(activity);
                }
            }

            @Override
            public void onError(VKError error) {

            }
        });
    }

    private void Authorization(Activity activity) {
        VKSdk.login(activity, "market", "offline");
    }

    private void Authentication(Activity activity,VKCallback<VKSdk.LoginState> callback) {
        VKSdk.wakeUpSession(activity,callback);
    }

    private void LogOut() {
        VKSdk.logout();
    }

    @Override
    public String getToken() {
        return token.accessToken;
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
