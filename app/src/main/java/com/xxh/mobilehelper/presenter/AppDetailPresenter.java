package com.xxh.mobilehelper.presenter;

import com.xxh.mobilehelper.bean.AppInfo;
import com.xxh.mobilehelper.data.model.AppDetailModel;
import com.xxh.mobilehelper.data.rxhelper.RxExceptionHandler;
import com.xxh.mobilehelper.ui.view.AppDetailView;

import io.reactivex.functions.Consumer;

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


    public void getAppDetail(int id) {
        addRx(mModel.getAppDetail(id).subscribe(new Consumer<AppInfo>() {
            @Override
            public void accept(AppInfo appInfo) throws Exception {
                mView.showAppDetail(appInfo);
            }
        }, new RxExceptionHandler<Throwable>(mContext, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                //错误提示

            }
        })));
    }
}
