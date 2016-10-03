package com.helpshift.fcmclient;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class FCMUtil {

  private static final String FCM_TOKEN = "fcm_token";

  public static void saveToken(Context context, String token) {
    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    sharedPreferences.edit().putString(FCM_TOKEN, token).apply();
  }

  public static String getFcmToken(Context context) {
    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    return sharedPreferences.getString(FCM_TOKEN, null);
  }
}
