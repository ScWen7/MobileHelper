package com.xxh.mobilehelper.presenter;

import com.xxh.mobilehelper.data.model.RecommendModel;
import com.xxh.mobilehelper.data.rxhelper.RxSchedulerHepler;
import com.xxh.mobilehelper.presenter.contract.RecommendContract;


/**
 * Created by 解晓辉  on 2017/5/21 09:37 *
 * QQ  ：811733738
 * 作用:
 */

public class RecommendPresenter implements RecommendContract.Presenter {
    private RecommendContract.View mView;

    private RecommendModel mModel;

    public RecommendPresenter(RecommendContract.View view, RecommendModel recommendModel) {
        mView = view;
        mModel = recommendModel;
    }

    @Override
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
