package com.xxh.mobilehelper.data.api;

import com.xxh.mobilehelper.bean.AppInfo;
import com.xxh.mobilehelper.bean.BaseResult;
import com.xxh.mobilehelper.bean.IndexBean;
import com.xxh.mobilehelper.bean.LoginBean;
import com.xxh.mobilehelper.bean.PageBean;
import com.xxh.mobilehelper.bean.RankBean;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


/**
 * Created by 解晓辉  on 2017/5/20 19:45 *
 * QQ  ：811733738
 * 作用:
 */

public interface ApiService {


    @GET("featured2")
    Observable<PageBean<AppInfo>> getApps(@Query("p") String jsonParams);

    @GET("featured2")
    Observable<PageBean<AppInfo>> getAppList(@Query("page") int page);


    @GET("toplist")
    Observable<BaseResult<RankBean>> getTopList(@Query("page") int page);


    @GET("index")
    Observable<BaseResult<IndexBean>> getIndex();

    @GET("game")
    Observable<BaseResult<IndexBean>> getGame();


    @POST("login")
    Observable<BaseResult<LoginBean>> login(@Body LoginRequest request);


}
