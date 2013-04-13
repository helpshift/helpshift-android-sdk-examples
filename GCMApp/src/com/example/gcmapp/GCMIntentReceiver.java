package com.example.gcmapp;

import com.helpshift.Helpshift;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.android.gcm.GCMRegistrar;

public class GCMIntentReceiver extends BroadcastReceiver {
  private Helpshift hs = null;

  @Override
  public void onReceive(Context context, Intent intent) {
    if (hs == null){
      hs = new Helpshift(context);
    }

    final String regId = GCMRegistrar.getRegistrationId(context);
    hs.setDeviceToken(regId);
  }
}
