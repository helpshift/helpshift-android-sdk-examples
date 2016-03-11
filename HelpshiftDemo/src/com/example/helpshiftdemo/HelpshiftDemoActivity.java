package com.example.helpshiftdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

import com.helpshift.Core;
import com.helpshift.support.Support;

public class HelpshiftDemoActivity extends Activity {

  String TAG = "HelpshiftDemoDebug";
  Button helpButton;
  Button reportIssueButton;
  Button inboxButton;
  Button faqsButton;
  Button faqSectionButton;
  Button singleFaqButton;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    Core.init(Support.getInstance());
    // TODO: Initialize the library by uncommenting and filling the following -
    // Core.install(getApplication(), "<YOUR_API_KEY>", "<YOUR_COMPANY>.helpshift.com", "<YOUR_APP_ID>");

    helpButton = (Button) findViewById(R.id.helpButton);
    helpButton.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
          Support.showFAQs(HelpshiftDemoActivity.this);
        }
      });

    reportIssueButton = (Button) findViewById(R.id.reportIssueButton);
    reportIssueButton.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
          Support.showConversation(HelpshiftDemoActivity.this);
        }
      });

    faqSectionButton = (Button) findViewById(R.id.faqSectionButton);
    faqSectionButton.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
          Support.showFAQSection(HelpshiftDemoActivity.this, "SECTION_PUBLISH_ID");
        }
      });

    singleFaqButton = (Button) findViewById(R.id.singleFaqButton);
    singleFaqButton.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
          Support.showSingleFAQ(HelpshiftDemoActivity.this, "QUESTION_PUBLISH_ID");
        }
      });
  }
}
