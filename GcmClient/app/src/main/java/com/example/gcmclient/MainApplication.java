package com.example.gcmclient;

import android.app.Application;
import android.content.Intent;

import com.helpshift.Core;
import com.helpshift.support.Support;

public class MainApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();

    // You initialize the library by calling Core.install(APPLICATION, API_KEY, DOMAIN,
    // APP_ID) in your application's onCreate(Bundle savedInstanceState)

    Core.init(Support.getInstance());
    Core.install(this,
     "<your api key>",
     "<your domain>",
     "<your app id>");

    Intent tokenRegistrationIntent = new Intent(this, RegistrationIntentService.class);
    tokenRegistrationIntent.putExtra("tokenIntent", "register");
    startService(tokenRegistrationIntent);

  }
}
