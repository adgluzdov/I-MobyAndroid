package com.dronteam.adm.i_moby.common.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.dronteam.adm.i_moby.common.CommonView;
import com.dronteam.adm.i_moby.common.ViewListener;

/**
 * Created by smb on 13/12/2016.
 */
public abstract class MainFragment extends Fragment implements CommonView {

    private View view;
    private ViewListener onCreateViewListener;

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(getLayout(), container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (onCreateViewListener != null) {
            onCreateViewListener.OnCreateView();
        }
    }

    protected abstract int getLayout();

    @Override
    public void setOnCreateViewListener(ViewListener listener) {
        onCreateViewListener = listener;
    }

    @Override
    public Fragment getFragment() {
        return this;
    }

    protected ListView getListView(int id) {
        return (ListView) view.findViewById(id);
    }

    protected View getView(int id) {
        return view.findViewById(id);
    }

}
