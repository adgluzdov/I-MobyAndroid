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
    //    @GET("market.get?owner_id=-121677108&album_id=0&count=10&offset=0&extended=0&access_token=dd21aa3aced5389181cc428e2512fd54a1700213b16f25f0870434edf760660174a879cea6487449fff65&v=5.59")
    @GET("market.get?owner_id=-121677108&album_id=0&count=10&offset=0&extended=0&v=5.59")
    Observable<Repo> Get();

}
