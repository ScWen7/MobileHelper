package com.xxh.mobilehelper.common.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by 解晓辉 on 2016/8/13.
 作用：
 */
public class SPUtils {

    public static String SP_NAME = "mobilehelper";

    public static void init(String name) {
        SP_NAME = name;
    }


    public static boolean getBoolean(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sp.getBoolean(key, false);
    }

    public static void putBoolean(Context context, String key, boolean b) {

        SharedPreferences sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, b).apply();

    }

    public static void putString(Context context, String key, String value) {

        SharedPreferences sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        sp.edit().putString(key, value).apply();

    }

    public static String getString(Context mContext, String key) {
        String result = "";

        SharedPreferences sp = mContext.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        result = sp.getString(key, "");
        return result;

    }
}
