package com.xxh.mobilehelper.data.model;

import com.xxh.mobilehelper.bean.BaseResult;
import com.xxh.mobilehelper.bean.RankBean;
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
        mApiService = HttpUtil.create().provideRetrofit(Constant.BASE_URL).create(ApiService.class);
    }

    public Observable<RankBean> getTopList(){
        return mApiService.getTopList(0)
                .compose(RxSchedulerHepler.<BaseResult<RankBean>>io_main())
                .compose(RxResultCompat.<RankBean>handleResult());
    }

}
