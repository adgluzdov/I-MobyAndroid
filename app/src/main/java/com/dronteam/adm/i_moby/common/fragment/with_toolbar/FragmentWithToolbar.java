package com.dronteam.adm.i_moby.common.fragment.with_toolbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dronteam.adm.i_moby.common.fragment.MainFragment;

/**
 * Created by adm on 08.07.2017.
 */

public abstract class FragmentWithToolbar extends MainFragment implements ViewWithToolbar {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater,container,savedInstanceState);
        ((AppCompatActivity)getActivity()).setSupportActionBar(getToolbar());
        return view;
    }

    protected Toolbar getToolbar(){
        return (Toolbar) getView(getIdToolbar());
    }

    protected abstract int getIdToolbar();

    @Override
    public void setToolbarTitle(String string) {
        getToolbar().setTitle(string);
    }
}
