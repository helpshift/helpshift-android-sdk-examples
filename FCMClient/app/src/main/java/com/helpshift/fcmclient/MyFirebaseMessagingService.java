package com.helpshift.fcmclient;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.helpshift.Core;

import java.util.Map;

/**
 * Created by deepanshudialani on 26/09/16.
 */
public class MyFirebaseMessagingService extends FirebaseMessagingService {

  private static final String TAG = "MyFirebaseMsgService";

  /**
   * Called when message is received.
   *
   * @param remoteMessage Object representing the message received from Firebase Cloud Messaging.
   */
  @Override
  public void onMessageReceived(RemoteMessage remoteMessage) {
    Map<String, String> data = remoteMessage.getData();
    Log.d(TAG, "onMessageReceived, data: " + data);
    String origin = data.get("origin");
    if (origin != null && origin.equals("helpshift")) {
      Core.handlePush(this, data);
    }
  }
}
