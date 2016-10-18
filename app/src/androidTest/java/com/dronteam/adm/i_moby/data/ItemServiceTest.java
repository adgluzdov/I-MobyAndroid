package com.dronteam.adm.i_moby.data;

import com.dronteam.adm.i_moby.model.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smb on 18/10/2016.
 */
public class ItemServiceTest implements ItemService{
    @Override
    public List<Item> Get() {
        return
        new ArrayList<Item>() {{
            add(new Item("Печенье"));
            add(new Item("кокосы"));
            add(new Item("абрикосы"));
        }};    }
}
