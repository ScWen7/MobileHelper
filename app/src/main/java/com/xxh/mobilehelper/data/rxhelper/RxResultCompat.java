package com.xxh.mobilehelper.data.rxhelper;

import com.xxh.mobilehelper.bean.BaseResult;
import com.xxh.mobilehelper.common.exception.TokenErrorException;
import com.xxh.mobilehelper.common.exception.TokenException;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Function;

/**
 * Created by 解晓辉  on 2017/6/4 13:56 *
 * QQ  ：811733738
 * 作用: 对Retrofit 返回数据的预处理
 */

public class RxResultCompat {
    public static <T> ObservableTransformer<BaseResult<T>, T> handleResult() {
        return new ObservableTransformer<BaseResult<T>, T>() {
            @Override
            public ObservableSource<T> apply(Observable<BaseResult<T>> upstream) {
                return upstream.flatMap(new Function<BaseResult<T>, ObservableSource<T>>() {
                    @Override
                    public ObservableSource<T> apply(BaseResult<T> tBaseResult) throws Exception {
                        int status = tBaseResult.getStatus();
                        tBaseResult.getStatus();
                        if (tBaseResult.isSuccess()) {
                            return Observable.just(tBaseResult.getData());
                        } else if (status == BaseResult.TOKEN_MISS) {
                            return Observable.error(new TokenException(tBaseResult.getStatus() + "", tBaseResult.getMessage()));
                        } else if (status == BaseResult.TOKEN_ERROR) {
                            return Observable.error(new TokenErrorException(tBaseResult.getStatus() + "", tBaseResult.getMessage()));
                        }
                        return Observable.empty();
                    }
                });
            }
        };
    }
}
