package com.dronteam.adm.i_moby.data;

import com.dronteam.adm.i_moby.data.VK.json_response.get.GetResponse;
import com.dronteam.adm.i_moby.data.VK.json_response.getAlbums.GetAlbumsResponse;
import com.dronteam.adm.i_moby.data.VK.json_response.messages.send.MessegesSendResponse;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by smb on 18/10/2016.
 */

public interface ItemService {

    @GET("market.get?owner_id=-121677108&v=5.59")
    Observable<GetResponse> Get();

    @GET("market.get?owner_id=-121677108&v=5.59")
    Observable<GetResponse> Get(@Query("album_id") String album_id);

    @GET("market.search?owner_id=-121677108&v=5.59")
    Observable<GetResponse> Search(@Query("q") String q);

    @GET("market.search?owner_id=-121677108&q=%23IMoby&v=5.59")
    Observable<GetResponse> SearchSpecialOffers();

    @GET("market.getAlbums?owner_id=-121677108&v=5.59")
    Observable<GetAlbumsResponse> GetAlbums();

    @GET("messages.send?user_id=-121677108&v=5.59")
    Observable<MessegesSendResponse> MessegesSend(@Query("message") String message, @Query("attachment") String attachment);

    @GET("messages.send?user_id=-121677108&v=5.59")
    Observable<MessegesSendResponse> MessegesSend(@Query("message") String message,@Query("attachment") String attachment,@Query("random_id") String random_id);

}
