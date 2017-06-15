package com.xxh.mobilehelper.presenter;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.xxh.mobilehelper.data.model.RecommendModel;
import com.xxh.mobilehelper.data.rxhelper.RxExceptionHandler;
import com.xxh.mobilehelper.ui.view.RecommendView;

import java.util.List;

import io.reactivex.functions.Consumer;


/**
 * Created by 解晓辉  on 2017/5/21 09:37 *
 * QQ  ：811733738
 * 作用:
 */

public class RecommendPresenter extends BasePresenter<RecommendModel, RecommendView> {


    public RecommendPresenter(RecommendView view) {
        super(view);
    }

    public void requestData() {
        mView.showLoading();
        mModel.getIndex()
                .subscribe(new Consumer<List<MultiItemEntity>>() {
                    @Override
                    public void accept(List<MultiItemEntity> multiItemEntities) throws Exception {
                        mView.dismissLoading();
                        if (multiItemEntities != null && multiItemEntities.size() > 0) {
                            mView.showResult(multiItemEntities);
                        } else {
                            mView.showNoData();
                        }
                    }
                }, new RxExceptionHandler<Throwable>(mContext, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.dismissLoading();
                        mView.showError();
                    }
                }));
    }


    @Override
    protected RecommendModel createModel() {
        return new RecommendModel();
    }

    @Override
    public void detachView() {
        mView = null;
        mModel = null;
    }
}
