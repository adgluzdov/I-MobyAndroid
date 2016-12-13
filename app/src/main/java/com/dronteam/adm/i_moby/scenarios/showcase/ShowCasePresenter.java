package com.dronteam.adm.i_moby.scenarios.showcase;

import com.dronteam.adm.i_moby.UIFactory;
import com.dronteam.adm.i_moby.common.CallBack;
import com.dronteam.adm.i_moby.common.CommonView;
import com.dronteam.adm.i_moby.common.Presenter;
import com.dronteam.adm.i_moby.common.ViewListener;
import com.dronteam.adm.i_moby.common.ViewManager;

/**
 * Created by smb on 13/12/2016.
 */
public class ShowcasePresenter implements Presenter, ViewListener {
    private ViewManager viewManager;
    private ShowcaseView view;

    public ShowcasePresenter(ViewManager viewManager, ShowcaseView view) {
        this.viewManager = viewManager;
        this.view = view;
        view.setOnCreateViewListener(this);
    }

    @Override
    public CommonView getView() {
        return view;
    }

    @Override
    public void OnCreateView() {
        view.setOnButtonClick(new CallBack() {
            @Override
            public void call() {
                viewManager.show(UIFactory.ItemsPresenter(viewManager));
            }
        });
    }
}
