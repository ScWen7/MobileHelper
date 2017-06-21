package com.xxh.mobilehelper.data.api;

import com.xxh.mobilehelper.bean.AppInfo;
import com.xxh.mobilehelper.bean.AppInfoBean;
import com.xxh.mobilehelper.bean.BaseResult;
import com.xxh.mobilehelper.bean.CategoryBean;
import com.xxh.mobilehelper.bean.IndexBean;
import com.xxh.mobilehelper.bean.LoginBean;
import com.xxh.mobilehelper.bean.PageBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
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
    Observable<BaseResult<AppInfoBean>> getTopList(@Query("page") int page);


    @GET("index")
    Observable<BaseResult<IndexBean>> getIndex();

    @GET("game")
    Observable<BaseResult<AppInfoBean>> getGame(@Query("page") int page);

    @GET("category")
    Observable<BaseResult<List<CategoryBean>>> getCategory();


    @POST("login")
    Observable<BaseResult<LoginBean>> login(@Body LoginRequest request);


    @GET("category/featured/{categoryid}")
    Observable<BaseResult<AppInfoBean>> getCategoryFeatured(@Path("categoryid") int categoryId, @Query("page") int page);

    @GET("category/toplist/{categoryid}")
    Observable<BaseResult<AppInfoBean>> getCategoryToplist(@Path("categoryid") int categoryId, @Query("page") int page);

    @GET("category/newlist/{categoryid}")
    Observable<BaseResult<AppInfoBean>> getCategoryNewlist(@Path("categoryid") int categoryId, @Query("page") int page);


    @GET("app/{id}")
    Observable<BaseResult<AppInfo>> getAppDetail(@Path("id") int id);


}
