package com.helpshift.helpshiftdemogradle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.helpshift.support.ApiConfig;
import com.helpshift.support.Support;

public class DemoActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_demo);

    Button helpButton = (Button) findViewById(R.id.help);
    helpButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        ApiConfig.Builder configBuilder = new ApiConfig.Builder();
        configBuilder.setRequireEmail(true);
        configBuilder.setEnableTypingIndicator(true);
        Support.showFAQs(DemoActivity.this, configBuilder.build());
      }
    });

    Button embeddableFragments = (Button) findViewById(R.id.embeddable_fragments);
    embeddableFragments.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent embeddableFragmentsIntent = new Intent(DemoActivity.this,
                                                      EmbeddableFragmentsActivity.class);
        startActivity(embeddableFragmentsIntent);
      }
    });
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.demo, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
