package com.xxh.mobilehelper.data.model;

import com.xxh.mobilehelper.bean.AppInfo;
import com.xxh.mobilehelper.bean.BaseResult;
import com.xxh.mobilehelper.contract.AppDetailContract;
import com.xxh.mobilehelper.data.api.ApiService;
import com.xxh.mobilehelper.data.http.HttpUtil;
import com.xxh.mobilehelper.data.rxhelper.RxResultCompat;
import com.xxh.mobilehelper.data.rxhelper.RxSchedulerHepler;

import io.reactivex.Observable;

/**
 * Created by 解晓辉 on 2017/6/21.
 * 作用：
 */
public class AppDetailModel implements AppDetailContract.Model {


    ApiService mApiService;

    public AppDetailModel() {
        mApiService = HttpUtil.getInstance().provideRetrofit().create(ApiService.class);
    }


    public Observable<AppInfo> getAppDetail(int id) {
        return mApiService.getAppDetail(id)
                .compose(RxSchedulerHepler.<BaseResult<AppInfo>>io_main())
                .compose(RxResultCompat.<AppInfo>handleResult());
    }

}
