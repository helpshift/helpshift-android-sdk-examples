package com.example.gcmclient;

import android.app.Application;
import android.content.Intent;

import com.helpshift.All;
import com.helpshift.Core;
import com.helpshift.support.Support;
import com.helpshift.exceptions.InstallException;

public class MainApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();

    // You initialize the library by calling Core.install(APPLICATION, API_KEY, DOMAIN,
    // APP_ID) in your application's onCreate(Bundle savedInstanceState)

    Core.init(All.getInstance());
    try {
      Core.install(this,
                   "<your api key>",
                   "<your domain>",
                   "<your app id>");
    } catch (InstallException e) {
      android.util.Log.e("Helpshift", "install call : ", e);
    }

    Intent tokenRegistrationIntent = new Intent(this, RegistrationIntentService.class);
    tokenRegistrationIntent.putExtra("tokenIntent", "register");
    startService(tokenRegistrationIntent);

  }
}
