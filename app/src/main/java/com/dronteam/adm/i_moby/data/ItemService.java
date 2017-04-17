package com.dronteam.adm.i_moby.data;

import com.dronteam.adm.i_moby.data.VK.json_response.get.GetResponse;
import com.dronteam.adm.i_moby.data.VK.json_response.getAlbums.GetAlbumsResponse;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by smb on 18/10/2016.
 */

public interface ItemService {

    @GET("market.get?owner_id=-121677108&v=5.59")
    Observable<GetResponse> Get();
    @GET("market.search?owner_id=-121677108&q=%23IMoby&v=5.59")
    Observable<GetResponse> Search();
    @GET("market.getAlbums?owner_id=-121677108&v=5.59")
    Observable<GetAlbumsResponse> GetAlbums();

}
