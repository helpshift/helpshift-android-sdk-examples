package com.example.gcmclient;

import android.os.Bundle;

import com.google.android.gms.gcm.GcmListenerService;
import com.helpshift.Core;

public class MyGcmListenerService extends GcmListenerService {

  @Override
  public void onMessageReceived(String from, Bundle data) {
    String origin = data.getString("origin");
    if (origin != null && origin.equals("helpshift")) {
      Core.handlePush(this, data);
    }
  }
}
