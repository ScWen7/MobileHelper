package com.xxh.mobilehelper.presenter;

import com.xxh.mobilehelper.data.model.RecommendModel;
import com.xxh.mobilehelper.data.rxhelper.RxSchedulerHepler;
import com.xxh.mobilehelper.ui.view.RecommendView;


/**
 * Created by 解晓辉  on 2017/5/21 09:37 *
 * QQ  ：811733738
 * 作用:
 */

public class RecommendPresenter extends BasePresenter {
    private RecommendView mView;

    private RecommendModel mModel;

    public RecommendPresenter(RecommendView view, RecommendModel recommendModel) {
        mView = view;
        mModel = recommendModel;
    }

    public void getApps(String jsonParams) {

        mModel.getApps(jsonParams)
                .compose(RxSchedulerHepler.io_main())
                .doOnSubscribe(disposable -> mView.showLoading())
                .subscribe(appInfoPageBean -> {
                            mView.dismissLoading();
                            mView.showResult(appInfoPageBean.getDatas());
                        }
                        , t -> mView.dismissLoading());

    }

    @Override
    public void attachView() {

    }

    @Override
    public void detachView() {

    }
}
