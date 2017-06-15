package com.xxh.mobilehelper.presenter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.xxh.mobilehelper.ui.BaseView;

/**
 * Created by 解晓辉  on 2017/5/21 09:36 *
 * QQ  ：811733738
 * 作用:
 */

public abstract class BasePresenter<M, V extends BaseView> {

    protected M mModel;
    protected V mView;

    protected Context mContext;

    public BasePresenter(V view) {
        mView = view;
        initContext(view);
        mModel = createModel();
    }

    protected void initContext(V view) {
        if (view instanceof Activity) {
            //Activity
            mContext = (Activity) view;
        } else {
            mContext = ((Fragment) view).getActivity();
        }

    }

    public Context getContext() {
        return mContext;
    }

    protected abstract M createModel();


    public abstract void detachView();
}
