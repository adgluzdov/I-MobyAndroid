package com.dronteam.adm.i_moby.data;

/**
 * Created by adm on 06.11.2016.
 */
public class TestFactory implements ServiceFactory {
    @Override
    public <T> T getApi(Class<T> service) {
        return (T) new ItemServiceTest();
    }
}
