package com.xxh.mobilehelper.presenter;

import com.xxh.mobilehelper.data.model.AppDetailModel;
import com.xxh.mobilehelper.ui.view.AppDetailView;

/**
 * Created by 解晓辉 on 2017/6/21.
 * 作用：
 */
public class AppDetailPresenter extends BasePresenter<AppDetailModel, AppDetailView> {


    public AppDetailPresenter(AppDetailView view) {
        super(view);
    }

    @Override
    protected AppDetailModel createModel() {
        return new AppDetailModel();
    }
}
