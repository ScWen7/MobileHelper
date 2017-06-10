package com.xxh.mobilehelper.presenter.contract;

import com.xxh.mobilehelper.bean.AppInfo;
import com.xxh.mobilehelper.presenter.BasePresenter;
import com.xxh.mobilehelper.ui.BaseView;

import java.util.List;

/**
 * Created by 解晓辉  on 2017/5/21 09:35 *
 * QQ  ：811733738
 * 作用:
 */

public interface RecommendContract {
    interface View extends BaseView {
        void showLoading();
        void dismissLoading();

        void showResult(List<AppInfo> appInfos);
        void showNoData();
        void showError();

    }
    interface Presenter extends BasePresenter{

        void getApps(String jsonParams);

    }
}
