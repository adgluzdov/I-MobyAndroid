package com.dronteam.adm.i_moby.scenarios.main;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.dronteam.adm.i_moby.R;
import com.dronteam.adm.i_moby.common.ViewListener;

public class ItemActivity extends Activity implements ItemView {
    ViewListener viewListener;
    ListView listViewMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        new ItemsPresenter(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        listViewMain = (ListView) findViewById(R.id.ListViewMain);
        viewListener.OnCreateView();
    }

    @Override
    public void setList(ItemAdapter adapter) {
        listViewMain.setAdapter(adapter);
    }

    @Override
    public void setOnCreateViewListener(ViewListener listener) {
        this.viewListener = listener;
    }
}
