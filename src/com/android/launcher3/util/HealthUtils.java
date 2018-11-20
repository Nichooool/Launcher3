package com.android.launcher3.util;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

/***
 ** @author nieyihe
 *  健康数据管理器
 **/
public class HealthUtils {

    static final String GET_CONFIG_INT = "getConfigInt";
    static final String GET_CONFIG_STRING = "getConfigString";
    static final String GET_CONFIG_LONG = "getConfigLong";
    static final String CONFIG_VALUE = "config_value";
    static final String SET_CONFIG_INT = "setConfigInt";
    static final String SET_CONFIG_STRING = "setConfigString";
    static final String SET_CONFIG_LONG = "setConfigLong";

    static final Uri AUTHORITIES_URI = Uri.parse("content://" + "me.nichool.configContentProvider");

    public static boolean setHealthConfigInt(Context context, String key, int value) {
        String method = SET_CONFIG_INT;
        Bundle arg = new Bundle();
        arg.putString(method, key);
        arg.putInt(CONFIG_VALUE, value);
        Bundle result = context.getContentResolver().call(AUTHORITIES_URI, method, null, arg);
        if (result == null) {
            return false;
        }
        return result.getBoolean(method);
    }

    public static boolean setHealthConfigString(Context context, String key, String value) {
        String method = SET_CONFIG_STRING;
        Bundle arg = new Bundle();
        arg.putString(method, key);
        arg.putString(CONFIG_VALUE, value);
        Bundle result = context.getContentResolver().call(AUTHORITIES_URI, method, null, arg);
        if (result == null) {
            return false;
        }
        return result.getBoolean(method);
    }

    public static boolean setHealthConfigLong(Context context, String key, long value) {
        String method = SET_CONFIG_LONG;
        Bundle arg = new Bundle();
        arg.putString(method, key);
        arg.putLong(CONFIG_VALUE, value);
        Bundle result = context.getContentResolver().call(AUTHORITIES_URI, method, null, arg);
        if (result == null) {
            return false;
        }
        return result.getBoolean(method);
    }

    public static int getHealthConfigInt(Context context, String key, int value) {
        String method = GET_CONFIG_INT;
        Bundle arg = new Bundle();
        arg.putString(method, key);
        arg.putInt(CONFIG_VALUE, value);
        Bundle result = context.getContentResolver().call(AUTHORITIES_URI, method, null, arg);
        if (result == null) {
            return value;
        }
        return result.getInt(method);
    }

    public static String getHealthConfigString(Context context, String key, String value) {
        String method = GET_CONFIG_STRING;
        Bundle arg = new Bundle();
        arg.putString(method, key);
        arg.putString(CONFIG_VALUE, value);
        Bundle result = context.getContentResolver().call(AUTHORITIES_URI, method, null, arg);
        if (result == null) {
            return value;
        }
        return result.getString(method);
    }

    public static Long getHealthConfigLong(Context context, String key, long value) {
        String method = GET_CONFIG_LONG;
        Bundle arg = new Bundle();
        arg.putString(method, key);
        arg.putLong(CONFIG_VALUE, value);
        Bundle result = context.getContentResolver().call(AUTHORITIES_URI, method, null, arg);
        if (result == null) {
            return value;
        }
        return result.getLong(method);
    }
}
