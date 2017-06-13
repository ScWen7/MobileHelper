package com.xxh.mobilehelper.presenter;

import com.xxh.mobilehelper.bean.LoginBean;
import com.xxh.mobilehelper.data.model.LoginModel;
import com.xxh.mobilehelper.data.rxhelper.RxExceptionHandler;
import com.xxh.mobilehelper.ui.view.LoginView;

import io.reactivex.functions.Consumer;

/**
 * Created by 解晓辉 on 2017/6/13.
 * 作用：
 */

public class LoginPresenter extends BasePresenter {

    private LoginModel mLoginModel;

    private LoginView mLoginView;

    public LoginPresenter(LoginView loginView) {
        mLoginModel = new LoginModel();
        mLoginView = loginView;
    }

    public void login(String email, String pasword) {
        mLoginView.showLoginLoading();
        mLoginModel.login(email, pasword)
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean loginBean) throws Exception {
                        mLoginView.dissmissLoading();
                        mLoginView.loginSuccess(loginBean);
                    }
                }, new RxExceptionHandler<Throwable>(new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                        mLoginView.dissmissLoading();
                        mLoginView.loginError();
                    }
                }));
    }


    @Override
    public void attachView() {
        //登录不做任何操作

    }

    @Override
    public void detachView() {
        mLoginModel = null;
        mLoginView = null;
    }
}
