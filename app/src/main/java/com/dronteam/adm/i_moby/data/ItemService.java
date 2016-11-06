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
    @GET("market.get?owner_id=-121677108&album_id=0&count=3&offset=0&extended=0&access_token=2d7f61d969cd008fa829b7846f3d82677e3b533edd8c0f4abb576b2fe3c5e27bd992df839612888dd4c3a&v=5.9")
    Observable<Repo> Get();
}
