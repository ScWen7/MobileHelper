package com.xxh.mobilehelper.ui.view;

import com.xxh.mobilehelper.bean.AppInfoBean;
import com.xxh.mobilehelper.ui.BaseView;

/**
 * Created by 解晓辉 on 2017/6/14.
 * 作用：
 */

public interface AppInfoView extends BaseView{
    void showResult(AppInfoBean appInfoBean);
    void onLoadMoreComplete();
}
