package com.xxh.mobilehelper.bean;

/**
 * Created by 解晓辉  on 2017/6/4 13:54 *
 * QQ  ：811733738
 * 作用:
 */

public class BaseResult<T> {

    public static final int SUCCESS = 1;
    public static final int TOKEN_MISS = 10010;


    private int status;
    private String message;
    private T data;


    public boolean isSuccess() {
        return (status == SUCCESS);
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
