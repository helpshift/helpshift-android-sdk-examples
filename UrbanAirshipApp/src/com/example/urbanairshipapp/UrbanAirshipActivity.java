package com.example.urbanairshipapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

import com.urbanairship.push.PushManager;
import com.helpshift.support.Support;
import com.helpshift.support.Log;

public class UrbanAirshipActivity extends Activity {
  protected final static String TAG = "UrbanAirshipAppDebug";
  Button helpButton;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    helpButton = (Button) findViewById(R.id.helpButton);
    helpButton.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
          Support.showFAQs(UrbanAirshipActivity.this);
        }
      });
  }
}
