package com.xxh.mobilehelper.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xxh.mobilehelper.MyApplication;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 解晓辉  on 2017/6/10 14:18 *
 * QQ  ：811733738
 * 作用:
 */

public abstract class BaseFragment extends Fragment {

    protected Activity mActivity;

    protected MyApplication mApplication;

    protected View mRootView;

    private Unbinder mUnbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getLayoutId(),container,false);
        mUnbinder = ButterKnife.bind(this, mRootView);
        return mRootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(mUnbinder!=null) {
            mUnbinder.unbind();
            mUnbinder = null;
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity = getActivity();
        mApplication = (MyApplication) mActivity.getApplication();
        initView();
    }


    /**
     * 初始化操作
     */
    protected abstract void initView();

    /**
     * 子类需要提供布局ID
     *
     * @return activity对应的  布局id
     */
    protected abstract int getLayoutId();


    public <T extends Activity> T  getParentActivity(){
        return (T)mActivity;
    }


    public void startActivity(Class <? extends Activity> clazz){
        mActivity.startActivity(new Intent(mActivity,clazz));
    }
}
