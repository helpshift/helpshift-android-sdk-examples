package com.example.gcmapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.helpshift.Core;
import com.google.android.gcm.GCMRegistrar;

public class GCMIntentReceiver extends BroadcastReceiver {
  private final static String TAG = GCMActivity.TAG;

  @Override
  public void onReceive(Context context, Intent intent) {
    String action = intent.getAction();

    if(action.equals("HS_TOKEN_SEND")) {
      final String regId = GCMRegistrar.getRegistrationId(context);
      Log.d(TAG, "token inside intentreceiver: " + regId.toString());
      if(!regId.equals("")) {
        Core.registerDeviceToken(context, regId);
      } else {
        Core.registerDeviceToken(context, "unreg");
      }
    } else if(action.equals("HS_ON_MESSAGE")) {
      Log.d(TAG, "GCMIntentReceiver - Message Received " + intent.toString());
      Core.handlePush(context, intent);
    }
  }
}
