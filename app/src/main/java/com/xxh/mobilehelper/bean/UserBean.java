package com.xxh.mobilehelper.bean;

import java.io.Serializable;

/**
 * Created by 解晓辉 on 2017/6/13.
 * 作用：
 */

public class UserBean implements Serializable{


    private static final long serialVersionUID = 54042874703697769L;
    private String id;
    private String email;
    private String logo_url;
    private String username;
    private String mobi;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogo_url() {
        return logo_url;
    }

    public void setLogo_url(String logo_url) {
        this.logo_url = logo_url;
    }

    public String getMobi() {
        return mobi;
    }

    public void setMobi(String mobi) {
        this.mobi = mobi;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
