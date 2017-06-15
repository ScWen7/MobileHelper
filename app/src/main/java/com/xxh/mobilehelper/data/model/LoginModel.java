package com.xxh.mobilehelper.data.model;

import android.content.Context;

import com.xxh.mobilehelper.bean.BaseResult;
import com.xxh.mobilehelper.bean.LoginBean;
import com.xxh.mobilehelper.bean.UserBean;
import com.xxh.mobilehelper.common.Constant;
import com.xxh.mobilehelper.common.util.ACache;
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

    private Context mContext;

    public LoginModel(Context context) {
        this.mContext = context.getApplicationContext();
        mApiService = HttpUtil.getInstance().provideRetrofit(Constant.BASE_URL).create(ApiService.class);
    }

    public Observable<LoginBean> login(String email, String passdord) {
        return mApiService.login(new LoginRequest(email, passdord))
                .compose(RxSchedulerHepler.<BaseResult<LoginBean>>io_main())
                .compose(RxResultCompat.<LoginBean>handleResult());
    }

    public void saveToken(String token){
        ACache.get(mContext).put(Constant.TOKEN,token);
    }

    public void saveUser(UserBean userBean){
        ACache.get(mContext).put(Constant.USER, userBean);
    }





}
