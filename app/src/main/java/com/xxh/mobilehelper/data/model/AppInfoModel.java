package com.xxh.mobilehelper.data.model;

import com.xxh.mobilehelper.bean.AppInfoBean;
import com.xxh.mobilehelper.bean.BaseResult;
import com.xxh.mobilehelper.data.api.ApiService;
import com.xxh.mobilehelper.data.http.HttpUtil;
import com.xxh.mobilehelper.data.rxhelper.RxResultCompat;
import com.xxh.mobilehelper.data.rxhelper.RxSchedulerHepler;

import io.reactivex.Observable;

/**
 * Created by 解晓辉 on 2017/6/13.
 * 作用：
 */

public class AppInfoModel {

    ApiService mApiService;

    public AppInfoModel() {
        mApiService = HttpUtil.getInstance().provideRetrofit().create(ApiService.class);
    }

    public Observable<AppInfoBean> getTopList(int page) {
        return mApiService.getTopList(page)
                .compose(RxSchedulerHepler.<BaseResult<AppInfoBean>>io_main())
                .compose(RxResultCompat.<AppInfoBean>handleResult());
    }

    public Observable<AppInfoBean> getGame(int page) {
        return mApiService.getGame(page)
                .compose(RxSchedulerHepler.<BaseResult<AppInfoBean>>io_main())
                .compose(RxResultCompat.<AppInfoBean>handleResult());
    }

    public Observable<AppInfoBean> getCategoryFeatured(int categoryid, int flagtype) {
        return mApiService.getCategoryFeatured(categoryid, flagtype)
                .compose(RxSchedulerHepler.<BaseResult<AppInfoBean>>io_main())
                .compose(RxResultCompat.<AppInfoBean>handleResult());
    }

    public Observable<AppInfoBean> getCategoryToplist(int categoryid, int flagtype) {
        return mApiService.getCategoryToplist(categoryid, flagtype)
                .compose(RxSchedulerHepler.<BaseResult<AppInfoBean>>io_main())
                .compose(RxResultCompat.<AppInfoBean>handleResult());
    }

    public Observable<AppInfoBean> getCategoryNewlist(int categoryid, int flagtype) {
        return mApiService.getCategoryNewlist(categoryid, flagtype)
                .compose(RxSchedulerHepler.<BaseResult<AppInfoBean>>io_main())
                .compose(RxResultCompat.<AppInfoBean>handleResult());
    }


}
