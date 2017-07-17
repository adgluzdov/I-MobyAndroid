package com.dronteam.adm.i_moby.scenarios.detail_information;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import java.text.SimpleDateFormat;

import android.os.Bundle;
import android.support.v4.app.SupportActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
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
import com.dronteam.adm.i_moby.common.fragment.MainFragment;
import com.dronteam.adm.i_moby.common.fragment.with_toolbar.FragmentWithToolbar;
import com.dronteam.adm.i_moby.common.fragment.with_toolbar.with_menu.with_search_view.FragmentWithToolbarWithSearchView;
import com.dronteam.adm.i_moby.model.product.Category;
import com.dronteam.adm.i_moby.model.product.Price;

import java.util.Date;
import java.util.TimeZone;

/**
 * Created by adm on 27.04.2017.
 */

public class DetailInfoFragment extends FragmentWithToolbar implements DetailInfoView {
    Toast toast = null;
    boolean IS_CONTENT_DRAWN = false;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        IS_CONTENT_DRAWN = false;
        View view = super.onCreateView(inflater,container,savedInstanceState);
        final LinearLayout payment_outer = (LinearLayout)getView(R.id.payment_outer);
        payment_outer.setVisibility(View.GONE);
        payment_outer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        final ViewGroup.MarginLayoutParams parms =
                (ViewGroup.MarginLayoutParams)getView(R.id.payment_outer).getLayoutParams();
        final View outer = getView(R.id.coordinator);
        final ViewTreeObserver obs = outer.getViewTreeObserver();
        obs.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw () {
                if(!IS_CONTENT_DRAWN) {
                    IS_CONTENT_DRAWN = true;
                    int animation_delta = (int)(ScreenInfo.density(getActivity())*68);
                    int height = outer.getHeight();
                    parms.setMargins(0, height-animation_delta, 0, 0);
                    payment_outer.setLayoutParams(parms);
                    payment_outer.setTranslationY(animation_delta);
                    payment_outer.setVisibility(View.VISIBLE);
                    ObjectAnimator transAnimation= ObjectAnimator.ofFloat(payment_outer, "translationY",
                            animation_delta,0);
                    transAnimation.setStartDelay(300);
                    transAnimation.setDuration(500);
                    transAnimation.start();
                }
                return true;
            }
        });
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
        ((TextView)getView(R.id.cat)).setText("Категория: "+category.getSection().getName()+" / "+category.getName());
    }

    @Override
    public void setDescription(String description) {
        ((TextView)getView(R.id.description)).setText(description);
    }

    @Override
    public void setDate(Integer unixSeconds) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
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
    public void setPlaceHolder(int resId) {
        ((ImageView)getView(R.id.image)).setImageResource(R.drawable.img_pre);
    }

    @Override
    public void setEditListener(View.OnClickListener listener) {
        getView(R.id.pay).setOnClickListener(listener);
    }

    @Override
    public void informingMessageIsSent(Context context) {
        if(toast != null)
            toast.cancel();
        toast = Toast.makeText(context, "Сообщение отправлено",Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void informingMessageIsNotSent(Context context) {
        if(toast != null)
            toast.cancel();
        toast = Toast.makeText(context, "Сообщение не отправлено",Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void informingMessageAlreadySent(Context context) {
        if(toast != null)
            toast.cancel();
        toast = Toast.makeText(context, "Сообщение уже отправлено",Toast.LENGTH_SHORT);
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

    @Override
    public String getTitle() {
        return "Товар";
    }

}
