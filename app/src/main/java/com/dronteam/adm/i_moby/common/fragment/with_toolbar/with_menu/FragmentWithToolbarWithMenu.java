package com.dronteam.adm.i_moby.common.fragment.with_toolbar.with_menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dronteam.adm.i_moby.common.fragment.with_toolbar.FragmentWithToolbar;

/**
 * Created by adm on 08.07.2017.
 */

public abstract class FragmentWithToolbarWithMenu extends FragmentWithToolbar implements ViewWithToolbarWithMenu {

    OptionsMenuListener optionsMenuListener = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater,container,savedInstanceState);
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(getMenuXml(), menu);
        if(optionsMenuListener !=  null)
            optionsMenuListener.onCreateOptionsMenu();
        super.onCreateOptionsMenu(menu, inflater);
    }

    protected abstract int getMenuXml();

    protected Menu getMenu(){
        return getToolbar().getMenu();
    }

    @Override
    public void setOnCreateOptionsMenu(OptionsMenuListener listener) {
        optionsMenuListener = listener;
    }
}
