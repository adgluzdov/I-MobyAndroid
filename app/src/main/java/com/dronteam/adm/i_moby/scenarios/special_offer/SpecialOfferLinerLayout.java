package com.dronteam.adm.i_moby.scenarios.special_offer;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dronteam.adm.i_moby.R;
import com.dronteam.adm.i_moby.model.product.Price;
import com.dronteam.adm.i_moby.model.special_offer.Tags;
import com.dronteam.adm.i_moby.scenarios.product.ProductFragment;

/**
 * Created by User on 19.12.2016.
 */
public class SpecialOfferLinerLayout extends LinearLayout implements SpecialOfferView {
    CardView cardView = null;
    View isSale = null;
    View isHit = null;
    public SpecialOfferLinerLayout(Context context) {
        super(context);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_special_offer2, this);
        view.setLayoutParams(new ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
        );
        cardView = (CardView)view.findViewById(R.id.card_view);
        isSale = view.findViewById(R.id.sale);
        isHit = view.findViewById(R.id.hit);
        isSale.setVisibility(View.GONE);
        isHit.setVisibility(View.GONE);
    }

    @Override
    public void setImage(Bitmap image) {
        ((ImageView)findViewById(R.id.image)).setImageBitmap(image);
    }

    @Override
    public void setErrorImage() {
        ((ImageView)findViewById(R.id.image)).setImageResource(R.drawable.img_pre);
    }

    @Override
    public void setPlaceHolder() {
        ((ImageView)findViewById(R.id.image)).setImageResource(R.drawable.img_pre);
    }

    @Override
    public void setTitle(String title) {
        ((TextView)findViewById(R.id.title)).setText(title);
    }

    @Override
    public void setPrice(Price price) {
        ((TextView)findViewById(R.id.price)).setText(price.getText());
    }

    @Override
    public void setOnItemViewClickListener(View.OnClickListener listener) {
        cardView.setOnClickListener(listener);
    }

    @Override
    public View getView() {
        return this;
    }

    @Override
    public void setTags(Tags tags) {
        if(tags.isSale())
            isSale.setVisibility(View.VISIBLE);
        if(tags.isHit())
            isHit.setVisibility(View.VISIBLE);
    }
}
