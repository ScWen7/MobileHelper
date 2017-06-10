package com.xxh.mobilehelper.data.rxhelper;

import com.xxh.mobilehelper.bean.BaseResult;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;

/**
 * Created by 解晓辉  on 2017/6/4 13:56 *
 * QQ  ：811733738
 * 作用: 对Retrofit 返回数据的预处理
 */

public class RxResultCompat {
    public static <T> ObservableTransformer<BaseResult<T>, T> handleResult() {
        return upstream -> {
          return   upstream.flatMap(tBaseResult -> {
                if (tBaseResult.isSuccess()) {
                    return Observable.just(tBaseResult.getData());
                }
                return Observable.empty();
            }
          );
        };
    }
}
