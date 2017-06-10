package com.xxh.mobilehelper.data.rxhelper;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 解晓辉  on 2017/6/3 08:45 *
 * QQ  ：811733738
 * 作用: RxJava  的线程管理ObservableTransformer
 */

public class RxSchedulerHepler {

    public static <T> ObservableTransformer<T,T> io_main(){
        return upstream-> upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
