package com.xxh.mobilehelper.data.model;

import com.xxh.mobilehelper.bean.AppInfo;
import com.xxh.mobilehelper.bean.PageBean;
import com.xxh.mobilehelper.data.api.ApiService;

import io.reactivex.Observable;


/**
 * Created by 解晓辉  on 2017/5/21 09:39 *
 * QQ  ：811733738
 * 作用:
 */

public class RecommendModel {
    ApiService mApiService;

    public RecommendModel(ApiService apiService) {
        mApiService = apiService;
    }

    public Observable<PageBean<AppInfo>> getApps(String jsonParams) {
        return mApiService
                .getApps(jsonParams);
    }
}
