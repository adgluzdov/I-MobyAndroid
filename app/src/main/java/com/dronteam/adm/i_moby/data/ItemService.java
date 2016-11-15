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
    @GET("market.get?owner_id=-121677108&album_id=0&count=3&offset=0&extended=0&access_token=16605a35aecea94365c0a0e5bfa8b99b6e4d4b59442b5ca87a3a2f685e6da41a43ff120ca83ff37d59b61&v=5.59")
    Observable<Repo> Get();
}
