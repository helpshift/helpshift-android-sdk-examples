package com.example.gcmapp;

import com.helpshift.Helpshift;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.android.gcm.GCMRegistrar;

public class GCMIntentReceiver extends BroadcastReceiver {
  private Helpshift hs = null;
  private final static String TAG = GCMActivity.TAG;

  @Override
  public void onReceive(Context context, Intent intent) {
    if (hs == null){
      hs = new Helpshift(context);
    }

    String action = intent.getAction();

    if(action.equals("HS_TOKEN_SEND")) {
      final String regId = GCMRegistrar.getRegistrationId(context);
      Log.d(TAG, "token inside intentreceiver: " + regId.toString());
      if(!regId.equals("")) {
        hs.setDeviceToken(regId);
      } else {
        hs.setDeviceToken("unreg");
      }
    } else if(action.equals("HS_ON_MESSAGE")) {
      Log.d(TAG, "GCMIntentReceiver - Message Received " + intent.toString());
      hs.handlePush(intent);
    }
  }
}
