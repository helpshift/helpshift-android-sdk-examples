package com.example.gcmapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

import com.google.android.gcm.GCMRegistrar;

import com.helpshift.Helpshift;
import com.helpshift.Log;

public class GCMActivity extends Activity {

  protected final static String TAG = "GCMAppDebug";
  protected final static String senderId = "YOUR_SENDER_ID";
  Helpshift hs;
  Button helpButton;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    hs = new Helpshift(GCMActivity.this);
    // You initialize the library by calling hs.install(APPLICATION_CONTEXT, API_KEY, DOMAIN,
    // APP_ID) in your activity's onCreate(Bundle savedInstanceState)
    // hs.install(this, "<YOUR_API_KEY>", "<yourcompany>.helpshift.com", "<YOUR_APP_ID>");

    GCMRegistrar.checkDevice(this);
    GCMRegistrar.checkManifest(this);
    final String regId = GCMRegistrar.getRegistrationId(this);
    if (regId.equals("")) {
      GCMRegistrar.register(this, senderId);
    } else {
      Log.d(TAG, "Already registered: " + regId.toString());
    }

    helpButton = (Button) findViewById(R.id.helpButton);
    helpButton.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
          hs.showSupport(GCMActivity.this);
        }
      });
  }
}
