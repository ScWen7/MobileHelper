package com.xxh.mobilehelper.presenter;

import com.xxh.mobilehelper.bean.LoginBean;
import com.xxh.mobilehelper.data.model.LoginModel;
import com.xxh.mobilehelper.data.rxhelper.RxExceptionHandler;
import com.xxh.mobilehelper.ui.view.LoginView;

import org.greenrobot.eventbus.EventBus;

import io.reactivex.functions.Consumer;

/**
 * Created by 解晓辉 on 2017/6/13.
 * 作用：
 */

public class LoginPresenter extends BasePresenter<LoginModel, LoginView> {


    public LoginPresenter(LoginView loginView) {
        super(loginView);
    }

    public void login(String email, String pasword) {
        mView.showLoading();
        mModel.login(email, pasword)
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean loginBean) throws Exception {
                        mView.dismissLoading();
                        mModel.saveToken(loginBean.getToken());
                        mModel.saveUser(loginBean.getUser());
                        EventBus.getDefault().post(loginBean.getUser());
                        mView.loginSuccess(loginBean);
                    }
                }, new RxExceptionHandler<Throwable>(mContext, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                        mView.dismissLoading();
                        mView.loginError();
                    }
                }));
    }


    @Override
    protected LoginModel createModel() {
        return new LoginModel(getContext());
    }

    @Override
    public void detachView() {
        mModel = null;
        mView = null;
    }
}
