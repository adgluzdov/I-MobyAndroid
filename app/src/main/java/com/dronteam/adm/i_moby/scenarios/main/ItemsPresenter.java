package com.dronteam.adm.i_moby.scenarios.main;

import com.dronteam.adm.i_moby.common.ViewListener;
import com.dronteam.adm.i_moby.data.ItemService;
import com.dronteam.adm.i_moby.data.ServiceFactory;
import com.dronteam.adm.i_moby.model.Item;

import java.util.List;

/**
 * Created by smb on 18/10/2016.
 */

public class ItemsPresenter implements ViewListener {

    private final ItemView view;
    private final ItemService itemsService;

    public ItemsPresenter(ItemView view) {
        this.view = view;
        //itemsService = ServiceFactory.getApi(ItemService.class);
        itemsService = ServiceFactory.getItemServiceTest();
        view.setViewListener(this);
    }


    @Override
    public void OnCreateView() {
        List<Item> items = itemsService.Get();
        view.setList(getAdapter(items));
    }

    private ItemAdapter getAdapter(List<Item> items) {
        return null;
    }
}
