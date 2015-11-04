package com.example.gcmclient;

import android.app.IntentService;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;
import com.helpshift.Core;

import java.io.IOException;

public class RegistrationIntentService  extends IntentService {

  private static final String TAG = "RegIntentService";

  public RegistrationIntentService() {
    super(TAG);
  }

  @Override
  protected void onHandleIntent(Intent intent) {
 // Make a call to Instance API
    InstanceID instanceID = InstanceID.getInstance(this);
    String senderId = "Your-Sender-ID";
    try {
      // request token that will be used by the server to send push notifications
      String tokenIntent = intent.getStringExtra("tokenIntent");
      String token = "";
      if (tokenIntent.equals("register")) {
        token = instanceID.getToken(senderId, GoogleCloudMessaging.INSTANCE_ID_SCOPE);
      } else {
        instanceID.deleteToken(senderId, GoogleCloudMessaging.INSTANCE_ID_SCOPE);
      }

      Log.d(TAG, "GCM Registration Token: " + token);

      // pass along this data
      sendRegistrationToServer(token);
      saveToken(token);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  private void saveToken(String token) {
    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    sharedPreferences.edit().putString("token", token).apply();
  }

  private void sendRegistrationToServer(String token) {
    // Add custom implementation, as needed.
    Core.registerDeviceToken(this, token);
  }
}
