package com.xxh.mobilehelper.data.model;

import com.xxh.mobilehelper.bean.BaseResult;
import com.xxh.mobilehelper.bean.LoginBean;
import com.xxh.mobilehelper.common.Constant;
import com.xxh.mobilehelper.data.api.ApiService;
import com.xxh.mobilehelper.data.api.LoginRequest;
import com.xxh.mobilehelper.data.http.HttpUtil;
import com.xxh.mobilehelper.data.rxhelper.RxResultCompat;
import com.xxh.mobilehelper.data.rxhelper.RxSchedulerHepler;

import io.reactivex.Observable;

/**
 * Created by 解晓辉 on 2017/6/13.
 * 作用：
 */

public class LoginModel {
    private ApiService mApiService;

    public LoginModel() {
        mApiService = HttpUtil.create().provideRetrofit(Constant.BASE_URL).create(ApiService.class);
    }

    public Observable<LoginBean> login(String email, String passdord) {
        return mApiService.login(new LoginRequest(email, passdord))
                .compose(RxSchedulerHepler.<BaseResult<LoginBean>>io_main())
                .compose(RxResultCompat.<LoginBean>handleResult());

    }
}
