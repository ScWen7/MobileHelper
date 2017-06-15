package com.xxh.mobilehelper.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.xxh.mobilehelper.MyApplication;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by 解晓辉  on 2017/6/10 11:03 *
 * QQ  ：811733738
 * 作用:  Activity 的基类
 * 1、布局ID
 * 2、ButterKnife
 * 3、提供Application 对象
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder mUnbinder;


    private MyApplication mApplication;

    CompositeDisposable disposables;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        Log.e("TAG", "BaseActivity onCreate");
        //ButterKnife 的绑定
        mUnbinder = ButterKnife.bind(this);
        this.mApplication = (MyApplication) getApplication();
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


    public void startActivity(Class<? extends Activity> clazz) {
        startActivity(new Intent(this, clazz));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (disposables != null) {
            disposables.dispose();
            disposables = null;
        }

        if (mUnbinder != null) {
            mUnbinder.unbind();
            mUnbinder = null;
        }
    }

    public void addRx(Disposable disposable) {
        if (disposables == null) {
            disposables = new CompositeDisposable();
        }
        disposables.add(disposable);
    }

}
