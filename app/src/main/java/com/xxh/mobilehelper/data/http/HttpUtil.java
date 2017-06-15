package com.xxh.mobilehelper.data.http;

import android.content.Context;

import com.xxh.mobilehelper.common.Constant;

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

    private static HttpUtil instance;

    private OkHttpClient mOkHttpClient;


    private Context mContext;
    private Retrofit mRetrofit;

    private HttpUtil(Context context) {
        this.mContext = context;
        mOkHttpClient = provideOkHttpClient();
    }

    public static HttpUtil create(Context context) {
        if (instance == null) {
            instance = new HttpUtil(context);
        }
        return instance;
    }


    public static HttpUtil getInstance() {
        return instance;
    }


    public OkHttpClient provideOkHttpClient() {
        //log  用的拦截器
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        //打印整个body
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .addInterceptor(new HttpParamInterceptor(mContext))
                .build();
    }


    public Retrofit provideRetrofit() {

        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(Constant.BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(mOkHttpClient).build();
        }

        return mRetrofit;
    }
}
