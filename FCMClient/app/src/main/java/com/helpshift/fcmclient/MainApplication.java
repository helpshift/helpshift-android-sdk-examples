package com.helpshift.fcmclient;

import android.app.Application;

import com.helpshift.All;
import com.helpshift.Core;
import com.helpshift.exceptions.InstallException;

import java.util.HashMap;
import java.util.Map;

public class MainApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();

    // Create Helpshift config
    Map config = new HashMap();

    // Initialize and install Helpshift
    Core.init(All.getInstance());
    try {
      Core.install(this,
                   "518c9d6472a68a2ab99a42c26567e24f",
                   "test.helpshift.com",
                   "test_platform_20121108053758969-8f405d202ca65d5",
                   config);
    } catch (InstallException e) {
      e.printStackTrace();
    }

    // Send FCM token if it's already saved and onTokenRefresh hasn't been called
    String fcmToken = FCMUtil.getFcmToken(this);
    if(fcmToken != null) {
      Core.registerDeviceToken(this, fcmToken);
    }
  }


}
