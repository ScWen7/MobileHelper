package com.xxh.mobilehelper.ui.view;

import com.xxh.mobilehelper.bean.LoginBean;
import com.xxh.mobilehelper.ui.BaseView;

/**
 * Created by 解晓辉 on 2017/6/13.
 * 作用：
 */

public interface LoginView  extends BaseView{

    void loginSuccess(LoginBean loginBean);
    void loginError();
    void verifyErroe();
}
