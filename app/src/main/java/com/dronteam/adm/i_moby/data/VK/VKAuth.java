package com.dronteam.adm.i_moby.data.VK;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.dronteam.adm.i_moby.common.AuthListener;
import com.dronteam.adm.i_moby.common.Authentication;
import com.dronteam.adm.i_moby.common.CallBack;
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
// Todo: Убрал Конструктор и создал отдельный метод, потому что в authListener.onAuth() уже нужен инициализированный класс.

public class VKAuth implements Authentication {

    private VKAccessToken token;
    private AuthListener authListener;

    public void auth(Activity activity, AuthListener authListener) {
        this.authListener = authListener;
        if (!VKSdk.isLoggedIn()) {
            VKSdk.login(activity, "market", "offline","messages");
        } else {
            token = VKAccessToken.currentToken();
            authListener.onAuth();
        }
    }

    @Override
    public String getToken() {
        return token.accessToken;
    }

    public void ActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken result) {
                token = result;
                authListener.onAuth();
            }
            @Override
            public void onError(VKError error) {

            }
        }));
    }

}
