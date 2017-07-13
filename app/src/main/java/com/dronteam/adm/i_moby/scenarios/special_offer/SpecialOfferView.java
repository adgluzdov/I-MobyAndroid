package com.dronteam.adm.i_moby.scenarios.special_offer;

import android.graphics.Bitmap;
import android.view.View;

import com.dronteam.adm.i_moby.common.adapters.ItemView;
import com.dronteam.adm.i_moby.model.special_offer.Tags;
import com.dronteam.adm.i_moby.scenarios.product.ProductView;

/**
 * Created by User on 13.12.2016.
 */

public interface SpecialOfferView extends ProductView,ItemView {
    void setTags(Tags tags);
}
