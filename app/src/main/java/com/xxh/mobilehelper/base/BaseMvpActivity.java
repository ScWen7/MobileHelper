package com.xxh.mobilehelper.base;

import android.os.Bundle;
import android.util.Log;

import com.xxh.mobilehelper.presenter.BasePresenter;

/**
 * Created by 解晓辉  on 2017/6/10 14:34 *
 * QQ  ：811733738
 * 作用: 公共的Mvp Activity 继承与BaseActivity
 *
 *  getLayoutId()   -> initView()  -> createPresenter() -> presenter.attachView()
 *
 *   生命周期  onDestory-> 中包含  presenter 的 detachView 和 presenter的置空
 *
 *
 */

public abstract class BaseMvpActivity<P extends BasePresenter> extends BaseActivity {

   protected P mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("TAG", "oncreate BaseMvpActivity");
        mPresenter = createPresenter();
        mPresenter.attachView();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
    }

    /**
     * 创建 Presenter
     *
     * @return
     */
    public abstract P createPresenter();
}
