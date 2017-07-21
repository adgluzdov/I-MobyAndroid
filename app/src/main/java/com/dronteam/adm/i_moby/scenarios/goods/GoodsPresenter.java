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
        // Если Integer - то должны создаваться КРАСНЫЕ кнопки
        List<Object> modelList1 = new ArrayList<>();
        for(int i = 0; i < 30; i++)
            modelList1.add(0);

        // Добавляем кнопки (КРАСНЫЕ)
        adapter.addListModel(modelList1);

        // Ставим на 30 позицию прогрессбар
        Observable.just("").delay(1,TimeUnit.SECONDS).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                adapter.addModel("",30);
            }
        });

        // Удаляем из 30 позиции прогрессбар и ставим ЗЕЛЕНЫЕ кнопки
        Observable.just("").delay(2,TimeUnit.SECONDS).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                // Список состоящий из элементов типа Item
                // Если Item - то должны создаваться ЗЕЛЕНЫЕ кнопки
                List<Object> modelList3 = new ArrayList<>();
                for(int i = 0; i < 30; i++)
                    modelList3.add(Item.ALL_GOODS);
                adapter.removeModel(30);
                adapter.addListModel(modelList3);
            }
        });


    }

    @Override
    public CommonView getView() {
        return view;
    }

}
