package org.hello;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

import com.helpshift.Helpshift;

public class HelloActivity extends Activity {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.hello_layout);

    // You initialize the library by calling Helpshift.install(APPLICATION, API_KEY, DOMAIN,
    // APP_ID) in your activity's onCreate(Bundle savedInstanceState)
    // Helpshift.install(getApplication(), "<YOUR_API_KEY>", "<yourcompany>.helpshift.com", "<YOUR_APP_ID>");

    Button helpBtn = (Button) findViewById(R.id.helpBtn);
    helpBtn.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
          Helpshift.showFAQs(HelloActivity.this);
        }
      });
  }
}
