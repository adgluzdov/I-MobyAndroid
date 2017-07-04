package com.dronteam.adm.i_moby.scenarios.main;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.dronteam.adm.i_moby.R;
import com.dronteam.adm.i_moby.UIFactory;
import com.dronteam.adm.i_moby.common.AuthListener;
import com.dronteam.adm.i_moby.common.Presenter;
import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.data.RetrofitFactory;
import com.dronteam.adm.i_moby.data.ServiceFactory;
import com.dronteam.adm.i_moby.data.VK.VKAuth;

/**
 * Created by smb on 13/12/2016.
 */

public class MainActivity extends AppCompatActivity implements ViewManager, AuthListener {

    private VKAuth auth = new VKAuth();
    private ServiceFactory serviceFacory;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        auth.auth(this,this);
    }

    @Override
    public void show(Presenter presenter) {
        if (presenter == null) return;
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.main_content, presenter.getView().getFragment(), "");
        transaction.addToBackStack(presenter.getView().getFragment().toString());
        transaction.commitAllowingStateLoss();
    }

    @Override
    public ServiceFactory getServiceFactory() {
        if (serviceFacory == null) {serviceFacory = new RetrofitFactory(auth);}
        return serviceFacory;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        auth.ActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onAuth() {
        show(UIFactory.ShowCase(this));
    }
}
