package com.dronteam.adm.i_moby.common.adapters;

/**
 * Created by adm on 21.04.2017.
 */

public interface ItemPresenter{
    public void fill();
    public ItemView getView();
    public Object getItem();
    int getItemId_();
}
