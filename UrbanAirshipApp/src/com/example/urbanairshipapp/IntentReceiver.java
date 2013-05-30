package com.example.urbanairshipapp;

import com.helpshift.Helpshift;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.urbanairship.UAirship;
import com.urbanairship.push.PushManager;

public class IntentReceiver extends BroadcastReceiver {
  private static final String TAG = UrbanAirshipActivity.TAG;
  private Helpshift hs = null;

  @Override
  public void onReceive(Context context, Intent intent) {
    if (hs == null){
      hs = new Helpshift(UAirship.shared().getApplicationContext());
    }

    String action = intent.getAction();

    if (action.equals(PushManager.ACTION_PUSH_RECEIVED)) {
      if(intent.getExtras().getString("origin").equals("helpshift")) {
        hs.handlePush(intent);
      }

      int id = intent.getIntExtra(PushManager.EXTRA_NOTIFICATION_ID, 0);

      Log.i(TAG, "Received push notification. Alert: "
            + intent.getStringExtra(PushManager.EXTRA_ALERT)
            + " [NotificationID="+id+"]");

    } else if (action.equals(PushManager.ACTION_NOTIFICATION_OPENED)) {

      if(intent.getExtras().getString("origin").equals("helpshift")) {
        hs.showSupportOnPush(intent);
      }

    } else if (action.equals(PushManager.ACTION_REGISTRATION_FINISHED)) {
      hs.setDeviceToken(PushManager.shared().getAPID());
      Log.i(TAG, "Registration complete. APID:" +
            intent.getStringExtra(PushManager.EXTRA_APID) +
            ". Valid: " +
            intent.getBooleanExtra(PushManager.EXTRA_REGISTRATION_VALID,
                                   false));
    }

  }
}
