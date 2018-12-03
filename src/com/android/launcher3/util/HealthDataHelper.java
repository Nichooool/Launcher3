package com.android.launcher3.util;

import android.content.Context;
import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.LinkedList;

import static com.android.launcher3.util.HealthDataHelper.IKey.APP_NAME;
import static com.android.launcher3.util.HealthDataHelper.IKey.WHITE_PACKEAGE;

/***
 ** @author nieyihe
 **/
public class HealthDataHelper {

    public static LinkedList<String> getConfigAppNames(Context context) {
        LinkedList<String> appList = new LinkedList<String>();
        String appArray = HealthUtils.getHealthConfigString(context, APP_NAME, "[]");
        if (!TextUtils.isEmpty(appArray)) {
            try {
                JSONArray array = new JSONArray(appArray);
                for (int i = 0; i < array.length(); i++) {
                    String appName = (String) array.get(i);
                    if (TextUtils.isEmpty(appName)) {
                        continue;
                    }
                    appList.add(appName);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return appList;
    }

    public static LinkedList<String> getConfigWhitePkg(Context context) {
        LinkedList<String> appList = new LinkedList<String>();
        String appArray = HealthUtils.getHealthConfigString(context, WHITE_PACKEAGE, "[]");
        if (!TextUtils.isEmpty(appArray)) {
            try {
                JSONArray array = new JSONArray(appArray);
                for (int i = 0; i < array.length(); i++) {
                    String appName = (String) array.get(i);
                    if (TextUtils.isEmpty(appName)) {
                        continue;
                    }
                    appList.add(appName);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return appList;
    }

    public static int getConfigStartTime(Context context) {
        return HealthUtils.getHealthConfigInt(context, IKey.START_TIME, 5);
    }

    public static int getConfigEndTime(Context context) {
        return HealthUtils.getHealthConfigInt(context, IKey.END_TIME, 23);
    }

    interface IKey {
        String APP_NAME = "IKEY_APP_NAME";
        String START_TIME = "IKEY_START_TIME";
        String END_TIME = "IKEY_END_TIME";
        String WHITE_PACKEAGE = "IKEY_WHITE_PACKAGE";
    }
}
