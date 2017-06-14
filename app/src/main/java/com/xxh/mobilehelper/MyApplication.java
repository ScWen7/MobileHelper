package com.xxh.mobilehelper;

import android.app.Application;
import android.content.Context;

import com.xxh.mobilehelper.common.util.DensityUtil;
import com.xxh.mobilehelper.common.util.DeviceUtils;
import com.xxh.mobilehelper.common.util.UIUtils;
import com.xxh.mobilehelper.data.http.HttpUtil;

/**
 * Created by 解晓辉  on 2017/5/24 20:36 *
 * QQ  ：811733738
 * 作用:全局的Application 进行一系列的初始化操作
 */

public class MyApplication extends Application {


    public static Application get(Context context) {
        return (Application) context.getApplicationContext();

    }


    @Override
    public void onCreate() {
        super.onCreate();
        UIUtils.init(this);
        HttpUtil.create(this);
        DeviceUtils.init(this);
        DensityUtil.init(this);
    }
}
