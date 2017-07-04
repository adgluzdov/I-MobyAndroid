package com.dronteam.adm.i_moby.common;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import com.dronteam.adm.i_moby.R;

/**
 * Created by smb on 13/12/2016.
 */
public abstract class MainFragment extends Fragment implements CommonView{

    private View view;
    private ViewListener onCreateViewListener;

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(getLayout(), container, false);
        if (onCreateViewListener != null) {
            onCreateViewListener.OnCreateView();
        }
        return view;
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

    public Button getButton(int id) {
        return (Button) view.findViewById(id);
    }

    protected ListView getListView(int id) {
        return (ListView) view.findViewById(id);
    }

    protected SearchView getSearchView(int id) {
        return (SearchView) view.findViewById(id);
    }

    protected View getView(int id) {
        return view.findViewById(id);
    }

}
