package com.dronteam.adm.i_moby.scenarios.main;

import android.content.Context;
import android.util.Log;

import com.dronteam.adm.i_moby.common.ViewListener;
import com.dronteam.adm.i_moby.data.ItemService;
import com.dronteam.adm.i_moby.data.ItemServiceTest;
import com.dronteam.adm.i_moby.data.ServiceFactory;
import com.dronteam.adm.i_moby.model.Item;

import java.util.List;

/**
 * Created by smb on 18/10/2016.
 */

public class ItemsPresenter implements ViewListener {

    private final ItemView view;
    private final ItemService itemService;
    private Context ctx;
    public ItemsPresenter(ItemView view) {
        this.ctx = (Context)view;
        this.view = view;
        //itemService = ServiceFactory.getApi(ItemService.class);
        //itemService = ServiceFactory.getItemServiceTest();
        itemService = new ItemServiceTest();
        view.setOnCreateViewListener(this);
    }


    @Override
    public void OnCreateView() {
        List<Item> items = itemService.Get();
        view.setList(getAdapter(items));
    }

    private ItemAdapter getAdapter(List<Item> items) {
        return new ItemAdapter(ctx,items);
    }
}
