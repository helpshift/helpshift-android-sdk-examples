package com.example.urbanairshipapp;

import com.helpshift.Helpshift;

import android.content.Context;
import android.app.Notification;
import android.app.Application;

import java.util.Map;

import com.urbanairship.UAirship;
import com.urbanairship.push.BasicPushNotificationBuilder;

public class MyPushNotifBuilder extends BasicPushNotificationBuilder {

  public Notification buildNotification(String alert, Map<String, String> extras) {
    if(extras.get("origin").equals("helpshift")) {
      return null;
    }
    return super.buildNotification(alert, extras);
  }
}
