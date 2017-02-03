package com.dronteam.adm.i_moby.data;

import com.dronteam.adm.i_moby.common.Repo;
import com.dronteam.adm.i_moby.model.Item;
import com.dronteam.adm.i_moby.model.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import rx.Observable;

/**
 * Created by smb on 18/10/2016.
 */
public class ItemServiceTest implements ItemService {
    @Override
    public Observable<Repo> Get() {
        Repo repo = new Repo(new Response(
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
