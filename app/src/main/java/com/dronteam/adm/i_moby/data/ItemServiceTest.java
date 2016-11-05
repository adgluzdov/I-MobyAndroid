package com.dronteam.adm.i_moby.data;

import com.dronteam.adm.i_moby.common.Repo;
import com.dronteam.adm.i_moby.model.Item;
import com.dronteam.adm.i_moby.model.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smb on 18/10/2016.
 */
public class ItemServiceTest implements ItemService {
    @Override
    public Repo Get() {
        List<Item> itemList = new ArrayList<Item>() {{
            add(new Item(1));
            add(new Item(2));
            add(new Item(3));
        }};

        return new Repo(new Response(itemList));

    }
}
