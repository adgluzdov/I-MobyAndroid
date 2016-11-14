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
    @GET("market.get?owner_id=-121677108&album_id=0&count=3&offset=0&extended=0&access_token=a45bd5f1457321ef3f29bbc9cc2525f89847a15972f5705c3d95307fb6b443201f24f0e77081b101f587f&v=5.59")
    Observable<Repo> Get();
}
