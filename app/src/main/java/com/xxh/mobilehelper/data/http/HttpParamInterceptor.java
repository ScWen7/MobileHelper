package com.xxh.mobilehelper.data.http;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.xxh.mobilehelper.common.Constant;
import com.xxh.mobilehelper.common.util.ACache;
import com.xxh.mobilehelper.common.util.DensityUtil;
import com.xxh.mobilehelper.common.util.DeviceUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/**
 * Created by 解晓辉  on 2017/6/10 09:48 *
 * QQ  ：811733738
 * 作用:
 */

public class HttpParamInterceptor implements Interceptor {

    private Context mContext;

    public HttpParamInterceptor(Context context) {
        this.mContext = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        HashMap<String, Object> commonMap = new HashMap<>();

        String imei = DeviceUtils.getIMEI();

        if (imei != null && imei.startsWith("000000")) {
            imei = "5284047f4ffb4e04824a2fd1d1f0cd62";
        }

        commonMap.put(Constant.IMEI, imei);
        commonMap.put(Constant.MODEL, DeviceUtils.getModel());
        commonMap.put(Constant.LANGUAGE, DeviceUtils.getLanguage());
        commonMap.put(Constant.os, DeviceUtils.getBuildVersionIncremental());
        commonMap.put(Constant.RESOLUTION, DensityUtil.getScreenW() + "*" + DensityUtil.getScreenH());
        commonMap.put(Constant.SDK, DeviceUtils.getBuildVersionSDK() + "");
        commonMap.put(Constant.DENSITY_SCALE_FACTOR, DensityUtil.getDensity() + "");

        String token = ACache.get(mContext).getAsString("token");
        if (!TextUtils.isEmpty(token)) {
            commonMap.put(Constant.TOKEN, token);
        }

        Request request = chain.request();
        String method = request.method();
        if ("GET".equals(method)) {  //GET请求
            HttpUrl url = request.url(); //获取请求的Url
            Set<String> paramNames = url.queryParameterNames();

            //最终的结果为 "p":"{}"
            HashMap<String, Object> rootMap = new HashMap<>();
            for (String paramName : paramNames) {
                if (Constant.API_PARAM.equals(paramName)) {
                    String oldParams = url.queryParameter(Constant.API_PARAM);
                    if (!TextUtils.isEmpty(oldParams)) {
                        HashMap<String, Object> hashMap = new Gson().fromJson(oldParams, HashMap.class);
                        if (hashMap != null) {
                            Set<Map.Entry<String, Object>> entries = hashMap.entrySet();
                            for (Map.Entry<String, Object> entry : entries) {
                                rootMap.put(entry.getKey(), entry.getValue());
                            }
                        }
                    }
                } else {
                    rootMap.put(paramName, url.queryParameter(paramName));
                }
            }
            rootMap.put(Constant.PUBLICPARAMS, commonMap); //重新组装的参数

            String newParams = new Gson().toJson(rootMap);

            String newUrl = url.toString();
            //由于是get 请求 直接对url 的拼接操作
            int index = newUrl.indexOf("?");
            if (index > 0) {
                newUrl = newUrl.substring(0, index);
            }


            newUrl = newUrl + "?" + Constant.API_PARAM + "=" + newParams;
            request = request.newBuilder().url(newUrl).build();
            Log.e("TAG", "newUrl:" + newUrl);


        } else if ("POST".equals(method)) {  //POST 请求
            RequestBody body = request.body();
            HashMap<String, Object> rootMap = new HashMap<>();
            if (body instanceof FormBody) {

                FormBody formBody = (FormBody) body;
                FormBody.Builder builder = new FormBody.Builder();
                int size = formBody.size();
                for (int i = 0; i < size; i++) {
                    builder.add(formBody.name(i), formBody.value(i));
                }
                String commonParam = new Gson().toJson(commonMap);
                builder.add(Constant.PUBLICPARAMS, commonParam);

                formBody = builder.build();

                request = request.newBuilder()
                        .post(formBody)
                        .build();

            } else {
                Buffer buffer = new Buffer();
                body.writeTo(buffer);
                String oldParams = buffer.readUtf8();
                if (oldParams != null) {
                    rootMap = new Gson().fromJson(oldParams, HashMap.class);
                    rootMap.put(Constant.PUBLICPARAMS, commonMap);
                    String newJsonParams = new Gson().toJson(rootMap);

                    MediaType JSON
                            = MediaType.parse("application/json; charset=utf-8");
                    request = request.newBuilder()
                            .post(RequestBody.create(JSON, newJsonParams))
                            .build();
                }

            }


        }

        return chain.proceed(request);
    }

}
