package com.example.notificationcountapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

import com.helpshift.Helpshift;
import com.helpshift.Log;

public class NotificationCountActivity extends Activity
{
  String TAG = "NotificationCountAppDebug";
  Helpshift hs;
  Button helpButton;

  private Handler countHandler = new Handler() {
      public void handleMessage(Message msg) {
        super.handleMessage(msg);
        Bundle countData = (Bundle) msg.obj;
        Log.d(TAG, countData.getInt("value") + " " +
              countData.getBoolean("cache"));
        helpButton.setText("Help " + countData.getInt("value"));
      }
    };

  private Handler failHandler = new Handler() {
      public void handleMessage(Message msg) {
        super.handleMessage(msg);
        Log.d(TAG, msg.toString());
      }
    };

  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    hs = new Helpshift(NotificationCountActivity.this);
    // You initialize the library by calling hs.install(APPLICATION_CONTEXT, API_KEY, DOMAIN,
    // APP_ID) in your activity's onCreate(Bundle savedInstanceState)
    // hs.install(APPLICATION_CONTEXT, API_KEY, DOMAIN, APP_ID)

    helpButton = (Button) findViewById(R.id.helpButton);
    helpButton.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
          hs.showSupport(NotificationCountActivity.this);
        }
      });
  }

  @Override
  public void onPause() {
    super.onPause();
    hs.stopNotifCountPolling ();
  }

  @Override
  public void onResume() {
    super.onPause();
    hs.startNotifCountPolling(countHandler, failHandler, 3);
  }
}
