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
  Button helpButton;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    // You initialize the library by calling Helpshift.install(APPLICATION, API_KEY, DOMAIN,
    // APP_ID) in your activity's onCreate(Bundle savedInstanceState)
    // Helpshift.install(getApplication(), "<YOUR_API_KEY>", "<yourcompany>.helpshift.com", "<YOUR_APP_ID>");

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
          Helpshift.showFAQs(GCMActivity.this);
        }
      });
  }
}
