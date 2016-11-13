package com.dronteam.adm.i_moby.data;

/**
 * Created by adm on 14.11.2016.
 */
public class PicassoFactory implements ImageService, ImageServiceFactory{

    @Override
    public void LoadImage(String url) {

    }

    @Override
    public ImageService GetApi() {
        return this;
    }
}
