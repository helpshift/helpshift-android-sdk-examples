package com.helpshift.fcmclient;

import android.app.Application;

import com.helpshift.support.Support;
import com.helpshift.Core;
import com.helpshift.InstallConfig;
import com.helpshift.exceptions.InstallException;

public class MainApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    // Initialize and install Helpshift
    Core.init(Support.getInstance());

    // Create Helpshift config
    InstallConfig installConfig = new InstallConfig.Builder()
                               .build();
    try {
      Core.install(this,
                   "<your api key>",
                   "<your domain>",
                   "<your app id>",
                   installConfig);


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
