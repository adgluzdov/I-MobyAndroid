package com.dronteam.adm.i_moby.data;

import com.dronteam.adm.i_moby.data.VK.json_response.get.GetResponse;
import com.dronteam.adm.i_moby.model.item.Item;
import com.dronteam.adm.i_moby.data.VK.json_response.get.Response;

import java.util.ArrayList;

import rx.Observable;

/**
 * Created by smb on 18/10/2016.
 */
public class ItemServiceTest implements ItemService {
    @Override
    public Observable<GetResponse> Get() {
        GetResponse repo = new GetResponse(new Response(
                new ArrayList<Item>() {
                    {
                        add(new Item(1));
                        add(new Item(2));
                        add(new Item(3));
                    }
                }
        ));
        return Observable.just(repo);
    }

    @Override
    public Observable<GetResponse> Search() {
        GetResponse repo = new GetResponse(new Response(
            new ArrayList<Item>() {
                {
                    add(new Item(1));
                    add(new Item(2));
                    add(new Item(3));
                }
            }
        ));
        return Observable.just(repo);
    }
}
