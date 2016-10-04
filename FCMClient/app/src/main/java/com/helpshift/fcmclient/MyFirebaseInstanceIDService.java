package com.helpshift.fcmclient;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.helpshift.Core;

/**
 * Created by deepanshudialani on 26/09/16.
 */
public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
  private static final String TAG = "MyFirebaseIIDService";

  /**
   * Called if InstanceID token is updated. This may occur if the security of
   * the previous token had been compromised. Note that this is called when the InstanceID token
   * is initially generated so this is where you would retrieve the token.
   */
  @Override
  public void onTokenRefresh() {
    String refreshedToken = FirebaseInstanceId.getInstance().getToken();
    Log.d(TAG, "Refreshed token: " + refreshedToken);
    FCMUtil.saveToken(this, refreshedToken);
    sendFCMTokenToHelpshift(refreshedToken);
  }

  private void sendFCMTokenToHelpshift(String token) {
    Core.registerDeviceToken(this, token);
  }
}
