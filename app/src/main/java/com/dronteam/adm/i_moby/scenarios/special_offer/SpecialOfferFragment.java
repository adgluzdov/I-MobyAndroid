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
    //Context context;


    public SpecialOfferFragment(Context context) {
        super(context);
        //this.context = context;
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.ll_special_offer, this);
    }

    @Override
    public void setDiscount(double discount) {
        ((TextView)findViewById(R.id.SP_discount)).setText(Double.toString(discount));
    }

    @Override
    public void setBonus(double bonus) {
        ((TextView)findViewById(R.id.SP_bonus)).setText(Double.toString(bonus));
    }

    @Override
    public void setAdditionalInfo(String additionalInfo) {
        ((TextView)findViewById(R.id.SP_additionalInfo)).setText(additionalInfo);
    }

    @Override
    public void setImage(Bitmap image) {
        ((ImageView)findViewById(R.id.SP_image1)).setImageBitmap(image);
    }

    @Override
    public void setImage(int resId) {
        ((ImageView)findViewById(R.id.SP_image1)).setImageResource(resId);
    }

    @Override
    public void setEditListener(OnClickListener listener) {
        setOnClickListener(listener);
    }
}
