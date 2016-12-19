package com.dronteam.adm.i_moby.scenarios.main;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.dronteam.adm.i_moby.R;
import com.dronteam.adm.i_moby.UIFactory;
import com.dronteam.adm.i_moby.common.Presenter;
import com.dronteam.adm.i_moby.common.ViewManager;

/**
 * Created by User on 19.12.2016.
 */

public class ShowCaseActivity extends Activity implements ViewManager {


    @Override
    public void show(Presenter presenter) {
        if (presenter == null) return;
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.showcase_content, presenter.getView().getFragment(), "");
        transaction.addToBackStack(presenter.getView().getFragment().toString());
        transaction.commitAllowingStateLoss();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showcase);
        show(UIFactory.ShowCase(this));
    }
}
