package com.dronteam.adm.i_moby.data;

/**
 * Created by adm on 06.11.2016.
 */
public interface ServiceFactory {
    <T> T  getApi(Class<T> service);
}
