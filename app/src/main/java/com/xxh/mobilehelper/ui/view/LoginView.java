package com.xxh.mobilehelper.ui.view;

import com.xxh.mobilehelper.bean.LoginBean;

/**
 * Created by 解晓辉 on 2017/6/13.
 * 作用：
 */

public interface LoginView {
    void showLoginLoading();
    void dissmissLoading();
    void loginSuccess(LoginBean loginBean);

    void loginError();
}
