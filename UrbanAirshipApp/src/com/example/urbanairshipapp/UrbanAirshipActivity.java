package com.example.urbanairshipapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

import com.helpshift.Helpshift;
import com.helpshift.Log;

import com.urbanairship.push.PushManager;

public class UrbanAirshipActivity extends Activity {
  protected final static String TAG = "UrbanAirshipAppDebug";
  Button helpButton;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    // You initialize the library by calling Helpshift.install(APPLICATION, API_KEY, DOMAIN,
    // APP_ID) in your activity's onCreate(Bundle savedInstanceState)
    // Helpshift.install(getApplication(), "<YOUR_API_KEY>", "<yourcompany>.helpshift.com", "<YOUR_APP_ID>");

    helpButton = (Button) findViewById(R.id.helpButton);
    helpButton.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
          Helpshift.showFAQs(UrbanAirshipActivity.this);
        }
      });
  }
}
