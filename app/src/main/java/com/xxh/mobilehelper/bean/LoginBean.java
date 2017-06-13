package com.xxh.mobilehelper.bean;

/**
 * Created by 解晓辉 on 2017/6/13.
 * 作用：
 */
public class LoginBean {
    private String token;
    private UserBean user;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }
}
