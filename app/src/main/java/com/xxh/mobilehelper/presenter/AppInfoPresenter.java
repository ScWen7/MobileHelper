package com.xxh.mobilehelper.presenter;

import com.xxh.mobilehelper.bean.AppInfoBean;
import com.xxh.mobilehelper.data.model.AppInfoModel;
import com.xxh.mobilehelper.data.rxhelper.RxExceptionHandler;
import com.xxh.mobilehelper.ui.view.AppInfoView;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by 解晓辉 on 2017/6/14.
 * 作用：
 */

public class AppInfoPresenter extends BasePresenter<AppInfoModel, AppInfoView> {

    public static final int RANK_TYPE = 0;
    public static final int GAME_TYPE = 1;


    private boolean isFirst = true;

    private int page = 0;

    public AppInfoPresenter(AppInfoView appInfoView) {
        super(appInfoView);
    }

    @Override
    protected AppInfoModel createModel() {
        return new AppInfoModel();
    }


    public void request(int type, final int page) {
        mView.showLoading();
        Observable<AppInfoBean> observable = getObservable(type, page);
        observable.subscribe(new Consumer<AppInfoBean>() {
            @Override
            public void accept(AppInfoBean appInfoBean) throws Exception {
                //表示数据获取成功
                if (isFirst) {
                    isFirst = !isFirst;
                    mView.dismissLoading();
                }
                if (page != 0) {
                    mView.onLoadMoreComplete();
                }
                mView.showResult(appInfoBean);
            }
        }, new RxExceptionHandler<Throwable>(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                //表示数据获取成功
                if (isFirst) {
                    isFirst = !isFirst;
                    mView.dismissLoading();
                }
            }
        }));

    }

    private Observable<AppInfoBean> getObservable(int type, int page) {
        switch (type) {
            case RANK_TYPE:
                return mModel.getTopList(page);
            case GAME_TYPE:
                return mModel.getGame(page);
            default:
                return mModel.getTopList(page);
        }
    }

    @Override
    public void detachView() {
        mView = null;
        mModel = null;
    }


}
