package com.example.urbanairshipapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import com.helpshift.Helpshift;
import com.helpshift.Log;

public class UrbanAirshipActivity extends Activity {
  String TAG = "UrbanAirshipAppDebug";
  Helpshift hs;
  Button helpButton;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    hs = new Helpshift(UrbanAirshipActivity.this);
    // You initialize the library by calling hs.install(APPLICATION_CONTEXT, API_KEY, DOMAIN,
    // APP_ID) in your activity's onCreate(Bundle savedInstanceState)
    // hs.install(this, "<YOUR_API_KEY>", "<yourcompany>.helpshift.com", "<YOUR_APP_ID>");

    helpButton = (Button) findViewById(R.id.helpButton);
    helpButton.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
          hs.showSupport(UrbanAirshipActivity.this);
        }
      });
  }
}
