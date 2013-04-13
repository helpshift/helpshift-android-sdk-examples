package com.example.gcmapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

import com.helpshift.Helpshift;
import com.helpshift.Log;

public class GCMActivity extends Activity {

  String TAG = "GCMAppDebug";
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
    hs.install(this,
               "518c9d6472a68a2ab99a42c26567e24f",
               "test.helpshift.com",
               "test_platform_20121108053758969-8f405d202ca65d5");

    helpButton = (Button) findViewById(R.id.helpButton);
    helpButton.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
          hs.showSupport(GCMActivity.this);
        }
      });
  }
}
