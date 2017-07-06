package com.dronteam.adm.i_moby.scenarios.detail_information;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dronteam.adm.i_moby.R;
import com.dronteam.adm.i_moby.common.MainFragment;

/**
 * Created by adm on 27.04.2017.
 */

public class DetailInfoFragment extends MainFragment implements DetailInfoView {
    Toast toast = null;

    @Override
    protected int getLayout() {
        return R.layout.detail_info;
    }

    @Override
    public void setTitle(String title) {
        ((TextView)getView(R.id.text_view_title)).setText(title);
    }

    @Override
    public void setDescription(String description) {
        ((TextView)getView(R.id.text_view_description)).setText(description);
    }

    @Override
    public void setPrice(String price) {
        ((TextView)getView(R.id.text_view_price)).setText(price);
    }

    @Override
    public void setCategorySection(String categorySection) {
        ((TextView)getView(R.id.text_view_category_section)).setText(categorySection);
    }

    @Override
    public void setCategoryName(String categoryName) {
        ((TextView)getView(R.id.text_view_category_name)).setText(categoryName);
    }
    @Override
    public void setDate(String date) {
        ((TextView)getView(R.id.text_view_date)).setText(date);
    }

    @Override
    public void setBlankImage() {
        ((ImageView)getView(R.id.image_view)).setImageResource(R.mipmap.ic_launcher);
    }

    @Override
    public void setImage(Bitmap bitmap) {
        ((ImageView)getView(R.id.image_view)).setImageBitmap(bitmap);
    }

    @Override
    public void setEditListener(View.OnClickListener listener) {
        getView(R.id.button_send_order_product).setOnClickListener(listener);
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
}
