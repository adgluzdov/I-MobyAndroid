package com.dronteam.adm.i_moby.scenarios.showcase;

import android.view.View;

import com.dronteam.adm.i_moby.R;
import com.dronteam.adm.i_moby.common.CallBack;
import com.dronteam.adm.i_moby.common.MainFragment;

/**
 * Created by smb on 13/12/2016.
 */
public class ShowcaseFragment extends MainFragment implements ShowcaseView {

    @Override
    protected int getLayout() {
        return R.layout.showcase;
    }

    @Override
    public void setOnButtonClick(final CallBack callBack) {
        getButton(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.call();
            }
        });
    }

}
