package com.xxh.mobilehelper.data.model;

import com.xxh.mobilehelper.bean.BaseResult;
import com.xxh.mobilehelper.bean.CategoryBean;
import com.xxh.mobilehelper.data.api.ApiService;
import com.xxh.mobilehelper.data.http.HttpUtil;
import com.xxh.mobilehelper.data.rxhelper.RxResultCompat;
import com.xxh.mobilehelper.data.rxhelper.RxSchedulerHepler;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by 解晓辉 on 2017/6/13.
 * 作用：
 */

public class CategoryModel {

    ApiService mApiService;

    public CategoryModel() {
        mApiService = HttpUtil.getInstance().provideRetrofit().create(ApiService.class);
    }

    public Observable<List<CategoryBean>> getCategory() {
        return mApiService.getCategory()
                .compose(RxSchedulerHepler.<BaseResult<List<CategoryBean>>>io_main())
                .compose(RxResultCompat.<List<CategoryBean>>handleResult());
    }


}
