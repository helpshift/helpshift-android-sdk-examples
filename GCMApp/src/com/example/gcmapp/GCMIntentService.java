package com.example.gcmapp;

import com.helpshift.Helpshift;

import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.util.Log;
import android.app.AlertDialog;

import java.util.Set;
import java.util.Iterator;

import com.google.android.gcm.GCMBaseIntentService;

public class GCMIntentService extends GCMBaseIntentService {

  private final static String TAG = GCMActivity.TAG;
  private final static String senderId = GCMActivity.senderId;

  public GCMIntentService() {
    super(senderId);
  }

  @Override
  protected void onRegistered(Context context, String registrationId) {
    Intent intent = new Intent();
    intent.setAction("HS_TOKEN_SEND");
    sendBroadcast(intent);
    Log.d(TAG, "GCMIntentService Registeration complete: " + registrationId);
    Log.d(TAG, "GCMIntentService Context: " + context.toString());
  }

  @Override
  protected void onUnregistered(Context context, String registrationId) {
    Log.d(TAG, "Unregistered: " + registrationId);
  }

  @Override
  protected boolean onRecoverableError (Context context, String errorId) {
    Log.d(TAG, "Recoverable Error: " + errorId);
    return true;
  }

  @Override
  public void onError(Context context, String errorId) {
    Log.d(TAG, "Error: " + errorId);
  }

  @Override
  protected void onMessage(Context context, Intent intent) {
    Log.d(TAG, "onMessage() Extras: " + intent.getExtras().toString());

    if(intent.getExtras().getString("origin").equals("helpshift")) {
      Intent i = new Intent();
      i.setAction("HS_ON_MESSAGE");
      i.putExtras(intent);
      sendBroadcast(i);
    }
  }

  private void generateNotification(Context context, Intent i) {
    PendingIntent intent = null;
    int icon = R.drawable.ic_launcher;
    Bundle extras = i.getExtras();
    String message = extras.getString("alert");
    long when = System.currentTimeMillis();

    Notification notification = new Notification(icon, message, when);
    String title = context.getString(R.string.app_name);
    notification.setLatestEventInfo(context, title, message, intent);
    notification.flags |= Notification.FLAG_AUTO_CANCEL;

    NotificationManager notificationManager = (NotificationManager)
      context.getSystemService(Context.NOTIFICATION_SERVICE);
    notificationManager.notify(0, notification);
  }
}
