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
    @GET("market.get?owner_id=-121677108&album_id=0&count=3&offset=0&extended=0&access_token=39233b7f4bb2e3c859c3958065db95cdbedbc3fb36a277a4790c63591533ca6b6dc6ba210b02be46eac26&v=5.9")
    Observable<Repo> Get();
}
