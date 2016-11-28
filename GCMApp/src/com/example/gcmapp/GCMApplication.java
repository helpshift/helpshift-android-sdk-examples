package com.example.gcmapp;

import android.app.Application;

import com.helpshift.Core;
import com.helpshift.All;
import com.helpshift.support.Support;
import com.helpshift.InstallConfig;
import com.helpshift.exceptions.InstallException;

public class GCMApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    // You initialize the library by calling Core.install(APPLICATION, API_KEY, DOMAIN,
    // APP_ID) in your application's onCreate()

    Core.init(All.getInstance());
    InstallConfig installConfig = new InstallConfig.Builder()
                               .setEnableInAppNotification(true)
                               .build();
    try {
      Core.install(this,
                   "<your api key>",
                   "<your domain>",
                   "<your app id>",
                   installConfig);
    } catch (InstallException e) {
      android.util.Log.e("Helpshift", "install call : ", e);
    }

    android.util.Log.d("Helpshift", Support.libraryVersion + " - is the version for gradle");

  }
}
