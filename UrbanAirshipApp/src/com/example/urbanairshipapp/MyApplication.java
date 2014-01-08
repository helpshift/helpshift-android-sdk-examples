package com.example.urbanairshipapp;

import android.app.Application;
import com.urbanairship.Logger;
import com.urbanairship.UAirship;
import com.urbanairship.push.PushManager;
import com.urbanairship.push.PushPreferences;
import com.urbanairship.AirshipConfigOptions;

public class MyApplication extends Application {

  @Override
  public void onCreate(){
    // Configure your application
    //
    // This can be done in code as illustrated here,
    // or you can add these settings to a properties file
    // called airshipconfig.properties
    // and place it in your "assets" folder
    // AirshipConfigOptions options = AirshipConfigOptions.loadDefaultOptions(this);
    // options.gcmSender = "Your Google API Project Number (allows multiple senders separated by commas)";
    // options.transport = "gcm";
    // options.developmentAppKey = "Your Development App Key";
    // options.developmentAppSecret = "Your Development App Secret";
    // options.inProduction = false; //determines which app key to use
    // UAirship.takeOff(this, options);

    PushManager.enablePush();
    PushManager.shared().setIntentReceiver(IntentReceiver.class);

    MyPushNotifBuilder nb = new MyPushNotifBuilder();
    nb.constantNotificationId = 100;
    PushManager.shared().setNotificationBuilder(nb);
  }
}
