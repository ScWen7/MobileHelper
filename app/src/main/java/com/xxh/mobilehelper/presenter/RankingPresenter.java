package com.xxh.mobilehelper.presenter;

import com.xxh.mobilehelper.bean.RankBean;
import com.xxh.mobilehelper.data.model.RankingModel;
import com.xxh.mobilehelper.data.rxhelper.RxExceptionHandler;
import com.xxh.mobilehelper.ui.view.RankingView;

import io.reactivex.functions.Consumer;

/**
 * Created by 解晓辉 on 2017/6/13.
 * 作用：
 */

public class RankingPresenter extends BasePresenter {


    private RankingView mView;

    private RankingModel mModel;

    public RankingPresenter(RankingView rankingView) {
        mModel = new RankingModel();
        this.mView = rankingView;
    }

    @Override
    public void attachView() {
        mView.showLoading();
        mModel.getTopList().subscribe(new Consumer<RankBean>() {
            @Override
            public void accept(RankBean rankBean) throws Exception {
                //表示数据获取成功
                mView.dismissLoading();
                mView.showResult(rankBean);
            }
        }, new RxExceptionHandler<Throwable>(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                //出现异常
                mView.dismissLoading();

            }
        }));

    }

    @Override
    public void detachView() {
        mView = null;
        mModel = null;
    }
}
