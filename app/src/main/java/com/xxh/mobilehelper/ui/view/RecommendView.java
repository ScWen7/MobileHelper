package com.xxh.mobilehelper.ui.view;

import com.xxh.mobilehelper.bean.AppInfo;
import com.xxh.mobilehelper.ui.BaseView;

import java.util.List;

/**
 * Created by 解晓辉  on 2017/6/10 17:26 *
 * QQ  ：811733738
 * 作用:
 */

public interface RecommendView extends BaseView{
    void showResult(List<AppInfo> appInfos);
    void showNoData();
    void showError();
}
