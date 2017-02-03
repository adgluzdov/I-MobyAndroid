package com.dronteam.adm.i_moby.data;

import com.dronteam.adm.i_moby.common.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by smb on 18/10/2016.
 */

public interface ItemService {
    @GET("market.get?owner_id=-121677108&album_id=0&count=10&offset=0&extended=0&access_token=1adc26a4faf11bcc4333b5a0b7a79c580b9fceec1bc01f75b35e4358fbd0c6dacf08a899c3e4a2d32b195&v=5.59")
    Observable<Repo> Get();

}
