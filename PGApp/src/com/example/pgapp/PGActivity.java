package com.example.pgapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

import com.helpshift.Helpshift;
import com.helpshift.Log;

public class PGActivity extends Activity {

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

    hs = new Helpshift(PGActivity.this);
    // You initialize the library by calling hs.install(APPLICATION_CONTEXT, API_KEY, DOMAIN,
    // APP_ID) in your activity's onCreate(Bundle savedInstanceState)
    // hs.install(this, "<YOUR_API_KEY>", "<yourcompany>.helpshift.com", "<YOUR_APP_ID>");

    helpButton = (Button) findViewById(R.id.helpButton);
    helpButton.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
          hs.showSupport(PGActivity.this);
        }
      });

    reportIssueButton = (Button) findViewById(R.id.reportIssueButton);
    reportIssueButton.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
          hs.showReportIssue(PGActivity.this);
        }
      });

    inboxButton = (Button) findViewById(R.id.inboxButton);
    inboxButton.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
          hs.showInbox(PGActivity.this);
        }
      });

    faqsButton = (Button) findViewById(R.id.faqsButton);
    faqsButton.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
          hs.showFaqs(PGActivity.this);
        }
      });

    faqSectionButton = (Button) findViewById(R.id.faqSectionButton);
    faqSectionButton.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
          hs.showSection(PGActivity.this, "SECTION_PUBLISH_ID");
        }
      });

    singleFaqButton = (Button) findViewById(R.id.singleFaqButton);
    singleFaqButton.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
          hs.showQuestion(PGActivity.this, "QUESTION_PUBLISH_ID");
        }
      });
  }
}
