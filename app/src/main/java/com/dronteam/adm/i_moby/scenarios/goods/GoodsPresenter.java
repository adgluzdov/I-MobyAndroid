package com.dronteam.adm.i_moby.scenarios.goods;

import android.view.View;
import android.widget.Adapter;

import com.dronteam.adm.i_moby.common.CallBack;
import com.dronteam.adm.i_moby.common.CallBack2;
import com.dronteam.adm.i_moby.common.OnScrollViewListener;
import com.dronteam.adm.i_moby.common.adapters.ItemPresenter;
import com.dronteam.adm.i_moby.common.adapters.ModelAdapter;
import com.dronteam.adm.i_moby.common.CommonView;
import com.dronteam.adm.i_moby.common.Presenter;
import com.dronteam.adm.i_moby.common.fragment.with_toolbar.with_menu.OptionsMenuListener;
import com.dronteam.adm.i_moby.data.VK.json_response.get.GetResponse;
import com.dronteam.adm.i_moby.common.ViewListener;
import com.dronteam.adm.i_moby.common.ViewManager;
import com.dronteam.adm.i_moby.data.ServiceFactory;
import com.dronteam.adm.i_moby.data.ItemService;
import com.dronteam.adm.i_moby.model.album.Item;
import com.dronteam.adm.i_moby.scenarios.product.ProductAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by smb on 18/10/2016.
 */

public class GoodsPresenter implements ViewListener, Presenter{

    private final GoodsView view;
    private ViewManager viewManager;
    private ModelAdapter adapter;

    public GoodsPresenter(ViewManager viewManager, GoodsView view, com.dronteam.adm.i_moby.model.album.Item album, String query) {
        this.view = view;
        this.viewManager = viewManager;
        this.adapter = new ProductAdapter(viewManager);
        view.setOnCreateViewListener(this);
    }

    @Override
    public void OnCreateView() {
        view.setList(adapter.getViewAdapter(),viewManager);

        // Список состоящий из элементов типа Integer
        // Если Integer - то должны создаваться кнопки
        List<Object> modelList1 = new ArrayList<>();
        for(int i = 0; i < 30; i++)
            modelList1.add(0);

        // Добавляем кнопки
        adapter.addListModel(modelList1);

        // Ставим ProgressBar вместо всего
        Observable.just("").delay(1,TimeUnit.SECONDS).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                List<Object> modelList2 = new ArrayList<>();
                for(int i = 0; i < 30; i++)
                    modelList2.add("");
                adapter.removeAll();
                adapter.addListModel(modelList2);
            }
        });

        // Ставим ProgressBar СНОВА вместо всего - но почему-то будут снова кнопки
        Observable.just("").delay(2,TimeUnit.SECONDS).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                List<Object> modelList2 = new ArrayList<>();
                for(int i = 0; i < 30; i++)
                    modelList2.add("");
                adapter.removeAll();
                adapter.addListModel(modelList2);
            }
        });


    }

    @Override
    public CommonView getView() {
        return view;
    }

}
