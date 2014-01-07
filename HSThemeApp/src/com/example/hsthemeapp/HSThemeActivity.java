package com.example.hsthemeapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

import com.helpshift.Helpshift;
import com.helpshift.Log;

public class HSThemeActivity extends Activity {

  String TAG = "HelpshiftDemoDebug";
  Helpshift hs;
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

    hs = new Helpshift(HSThemeActivity.this);
    // You initialize the library by calling hs.install(APPLICATION_CONTEXT, API_KEY, DOMAIN,
    // APP_ID) in your activity's onCreate(Bundle savedInstanceState)
    // hs.install(this, "<YOUR_API_KEY>", "<yourcompany>.helpshift.com", "<YOUR_APP_ID>");

    helpButton = (Button) findViewById(R.id.helpButton);
    helpButton.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
          hs.showSupport(HSThemeActivity.this);
        }
      });

    reportIssueButton = (Button) findViewById(R.id.reportIssueButton);
    reportIssueButton.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
          hs.showReportIssue(HSThemeActivity.this);
        }
      });

    inboxButton = (Button) findViewById(R.id.inboxButton);
    inboxButton.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
          hs.showInbox(HSThemeActivity.this);
        }
      });

    faqsButton = (Button) findViewById(R.id.faqsButton);
    faqsButton.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
          hs.showFaqs(HSThemeActivity.this);
        }
      });

    faqSectionButton = (Button) findViewById(R.id.faqSectionButton);
    faqSectionButton.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
          hs.showSection(HSThemeActivity.this, "SECTION_PUBLISH_ID");
        }
      });

    singleFaqButton = (Button) findViewById(R.id.singleFaqButton);
    singleFaqButton.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
          hs.showQuestion(HSThemeActivity.this, "QUESTION_PUBLISH_ID");
        }
      });
  }
}
