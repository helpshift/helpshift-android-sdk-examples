package com.example.urbanairshipapp;

import com.helpshift.Helpshift;

import android.content.Context;
import android.app.Notification;
import android.app.Application;

import java.util.Map;

import com.urbanairship.UAirship;
import com.urbanairship.push.BasicPushNotificationBuilder;

public class MyPushNotifBuilder extends BasicPushNotificationBuilder {

  private Helpshift hs = null;

  public Notification buildNotification(String alert, Map<String, String> extras) {

    Context c = UAirship.shared().getApplicationContext();
    if (hs == null){
      hs = new Helpshift(c);
    }

    if(!hs.isForeground()) {
      return super.buildNotification(alert, extras);
    } else {
      return null;
    }
  }
}
