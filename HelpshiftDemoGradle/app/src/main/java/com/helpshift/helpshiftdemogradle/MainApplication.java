package com.helpshift.helpshiftdemogradle;

import android.app.Application;

import com.helpshift.Core;
import com.helpshift.All;
import com.helpshift.support.Support;

public class MainApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();

    Core.init(All.getInstance());
    Core.install(this,
                 "<your api key>",
                 "<your domain>",
                 "<your app id>");

    android.util.Log.d("Helpshift", Support.libraryVersion + " - is the version for gradle");

  }
}
