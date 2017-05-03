package com.dronteam.adm.i_moby.scenarios.special_offer;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dronteam.adm.i_moby.R;

/**
 * Created by User on 19.12.2016.
 */
public class SpecialOfferFragment extends LinearLayout implements SpecialOfferView {

    public SpecialOfferFragment(Context context) {
        super(context);

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.special_offer, this);
    }

    @Override
    public void setDiscount(String discount) {
        ((TextView)findViewById(R.id.text_view_discount)).setText(discount);
    }

    @Override
    public void setBonus(String bonus) {
        ((TextView)findViewById(R.id.text_view_bonus)).setText(bonus);
    }

    @Override
    public void setAdditionalInfo(String additionalInfo) {
        ((TextView)findViewById(R.id.text_view_additionalInfo)).setText(additionalInfo);
    }

    @Override
    public void setImage(Bitmap image) {
        ((ImageView)findViewById(R.id.image_view)).setImageBitmap(image);
    }

    @Override
    public void setImage(int resId) {
        ((ImageView)findViewById(R.id.image_view)).setImageResource(resId);
    }

    @Override
    public void setTitle(String title) {
        ((TextView)findViewById(R.id.text_view_title)).setText(title);
    }

    @Override
    public void setPrice(String price) {
        ((TextView)findViewById(R.id.text_view_price)).setText(price);
    }

    @Override
    public void setEditListener(OnClickListener listener) {
        setOnClickListener(listener);
    }
}
