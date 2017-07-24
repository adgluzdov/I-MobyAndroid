package com.dronteam.adm.i_moby.scenarios.detail_information;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import java.text.SimpleDateFormat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dronteam.adm.i_moby.R;
import com.dronteam.adm.i_moby.common.ScreenInfo;
import com.dronteam.adm.i_moby.common.fragment.with_toolbar.FragmentWithToolbar;
import com.dronteam.adm.i_moby.model.product.Category;
import com.dronteam.adm.i_moby.model.product.Price;

import java.util.Date;

/**
 * Created by adm on 27.04.2017.
 */

public class DetailInfoFragment extends FragmentWithToolbar implements DetailInfoView {
    Toast toast = null;
    boolean IS_CONTENT_DRAWN = false;
    LinearLayout payment_outer;
    ViewTreeObserver obs;
    int payment_outer_height;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        IS_CONTENT_DRAWN = false;
        View view = super.onCreateView(inflater,container,savedInstanceState);
        payment_outer = (LinearLayout)getView(R.id.payment_outer);
        payment_outer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        payment_outer_height = (int)(ScreenInfo.density(getActivity())*68);
        obs = getView(R.id.coordinator).getViewTreeObserver();
        obs.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw () {
                if(!IS_CONTENT_DRAWN) {
                    IS_CONTENT_DRAWN = true;
                    ObjectAnimator transAnimation= ObjectAnimator.ofFloat(payment_outer, "translationY",
                            payment_outer_height,0);
                    transAnimation.setStartDelay(300);
                    transAnimation.setDuration(500);
                    transAnimation.start();
                }
                return true;
            }
        });
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return view;
    }

    @Override
    protected int getLayout() {
        return R.layout.page_product;
    }

    @Override
    public void setTitle(String title) {
        ((TextView)getView(R.id.title)).setText(title);
    }

    @Override
    public void setCategoty(Category category) {
        ((TextView)getView(R.id.cat)).setText(category.getSection().getName()+" / "+category.getName());
    }

    @Override
    public void setDescription(String description) {
        ((TextView)getView(R.id.description)).setText(description);
    }

    @Override
    public void setDate(Integer unixSeconds) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("d MMMM yyyy");
        Date date = new Date(unixSeconds*1000L);
        String formattedDate = dateFormat.format(date);
        ((TextView)getView(R.id.date)).setText("Добавлено: "+formattedDate);
    }

    @Override
    public void setPrice(Price price) {
        ((TextView)getView(R.id.price)).setText(price.getText());
    }

    @Override
    public void setImage(Bitmap bitmap) {
        ((ImageView)getView(R.id.image)).setImageBitmap(bitmap);
    }

    @Override
    public void setPlaceHolder() {
        ((ImageView)getView(R.id.image)).setImageResource(R.drawable.img_pre);
    }

    @Override
    public void setErrorImage() {

    }

    @Override
    public void setOnSendMessegeListener(View.OnClickListener listener) {
        getView(R.id.pay).setOnClickListener(listener);
    }

    @Override
    public void informingMessageIsSent() {
        if(toast != null)
            toast.cancel();
        toast = Toast.makeText(getActivity(), "Сообщение отправлено",Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void informingMessageIsNotSent() {
        if(toast != null)
            toast.cancel();
        toast = Toast.makeText(getActivity(), "Сообщение не отправлено",Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void informingMessageAlreadySent() {
        if(toast != null)
            toast.cancel();
        toast = Toast.makeText(getActivity(), "Сообщение уже отправлено",Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onPause() {
        if(toast != null)
            toast.cancel();
        super.onPause();
    }

    @Override
    protected int getIdToolbar() {
        return R.id.toolbar;
    }

}
