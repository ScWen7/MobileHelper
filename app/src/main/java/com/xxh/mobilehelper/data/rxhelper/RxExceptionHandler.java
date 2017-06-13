package com.xxh.mobilehelper.data.rxhelper;


import android.util.Log;

import com.xxh.mobilehelper.common.exception.TokenException;
import com.xxh.mobilehelper.common.util.UIUtils;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.functions.Consumer;

/**
 * Created by 解晓辉  on 2017/6/10 17:04 *
 * QQ  ：811733738
 * 作用:  对网络错误的预处理
 */

public class RxExceptionHandler<T extends Throwable> implements Consumer<T> {

    private static String TAG = "RxExceptionHandler";


    private static final String TIMEOUT_EXCEPTION = "网络连接超时，请检查您的网络状态，稍后重试";
    private static final String CONNECT_EXCEPTION = "网络连接异常，请检查您的网络状态";
    private static final String JSON_EXCEPTION = "数据获取异常";
    private static final String UNKNOWN_HOST_EXCEPTION = "网络异常，请检查您的网络状态";

    private static final String TOKEN_EXCEPTION = "身份信息验证失败！";

    private Consumer<? super Throwable> onError;

    public RxExceptionHandler(Consumer<? super Throwable> onError) {
        this.onError = onError;
    }

    @Override
    public void accept(T t) {
        t.printStackTrace();
        if (t instanceof SocketTimeoutException) {
            Log.e(TAG, "onError: SocketTimeoutException---");
            UIUtils.showToast(TIMEOUT_EXCEPTION);
        } else if (t instanceof ConnectException) {
            Log.e(TAG, "onError: CONNECT_EXCEPTION---");
            UIUtils.showToast(CONNECT_EXCEPTION);
        } else if (t instanceof UnknownHostException) {
            Log.e(TAG, "onError: UNKNOWN_HOST_EXCEPTION---");
            UIUtils.showToast(UNKNOWN_HOST_EXCEPTION);
        } else if (t instanceof JSONException) {
            Log.e("TAG", "onError: JSON_EXCEPTION");
            UIUtils.showToast(JSON_EXCEPTION);
        } else if (t instanceof TokenException) {
            Log.e("TAG", "onError: TokenException");
            UIUtils.showToast(TOKEN_EXCEPTION);
        } else {
            try {
                onError.accept(t);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
