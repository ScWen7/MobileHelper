package com.xxh.mobilehelper.data.model;

import com.xxh.mobilehelper.bean.BaseResult;
import com.xxh.mobilehelper.bean.AppInfoBean;
import com.xxh.mobilehelper.common.Constant;
import com.xxh.mobilehelper.data.api.ApiService;
import com.xxh.mobilehelper.data.http.HttpUtil;
import com.xxh.mobilehelper.data.rxhelper.RxResultCompat;
import com.xxh.mobilehelper.data.rxhelper.RxSchedulerHepler;

import io.reactivex.Observable;

/**
 * Created by 解晓辉 on 2017/6/13.
 * 作用：
 */

public class RankingModel {

    ApiService mApiService;

    public RankingModel() {
        mApiService = HttpUtil.getInstance().provideRetrofit(Constant.BASE_URL).create(ApiService.class);
    }

    public Observable<AppInfoBean> getTopList(int page){
        return mApiService.getTopList(page)
                .compose(RxSchedulerHepler.<BaseResult<AppInfoBean>>io_main())
                .compose(RxResultCompat.<AppInfoBean>handleResult());
    }

}
