package com.xxh.mobilehelper.common.util;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 解晓辉  on 2017/5/24 20:49 *
 * QQ  ：811733738
 * 作用:
 */

public class HttpUtil {

  private static   HttpUtil instance;

    private OkHttpClient mOkHttpClient;
    private HttpUtil() {
        mOkHttpClient = provideOkHttpClient();
    }

    public  static HttpUtil create(){
        if(instance==null) {
            instance = new HttpUtil();
        }
        return instance;
    }


    public  OkHttpClient provideOkHttpClient(){
        //log  用的拦截器
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        //打印整个body
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .addInterceptor(interceptor).build();
    }


    public Retrofit provideRetrofit(String baseUrl){
        Retrofit.Builder  builder= new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(mOkHttpClient);
        return builder.build();
    }
}
