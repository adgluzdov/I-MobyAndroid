package com.dronteam.adm.i_moby.data;

import com.dronteam.adm.i_moby.common.Repo;
import com.dronteam.adm.i_moby.scenarios.special_offer.SpecialOffer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by smb on 18/10/2016.
 */

public interface ItemService {
    //    @GET("market.get?owner_id=-121677108&album_id=0&count=10&offset=0&extended=0&access_token=98ff2e7787be571fb1e306a29dc8412631a65706a5b512a18ae76bb4b97fcaca285b4ec4a0b4bc17b1899&v=5.59")
    @GET("market.get?owner_id=-121677108&v=5.59")
    Observable<Repo> Get();
    @GET("market.search?owner_id=-121677108&q=%23IMoby&v=5.59")
    Observable<Repo> Search();

}
