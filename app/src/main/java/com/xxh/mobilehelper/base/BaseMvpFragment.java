package com.xxh.mobilehelper.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.xxh.mobilehelper.presenter.BasePresenter;

/**
 * Created by 解晓辉  on 2017/6/10 14:52 *
 * QQ  ：811733738
 * 作用:
 */

public abstract class BaseMvpFragment <P  extends BasePresenter> extends BaseFragment {


    P mPresenter;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(mPresenter!=null) {
            mPresenter.detachView();
            mPresenter = null;
        }

    }


    /**
     * 创建 Presenter
     * @return
     */
    public  abstract  P createPresenter() ;

}
