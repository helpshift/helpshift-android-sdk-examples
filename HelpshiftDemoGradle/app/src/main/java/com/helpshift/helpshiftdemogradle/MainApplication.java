package com.helpshift.helpshiftdemogradle;

import android.app.Application;
import android.widget.Toast;

import com.helpshift.Core;
import com.helpshift.All;
import com.helpshift.HelpshiftUser;
import com.helpshift.delegate.AuthenticationFailureReason;
import com.helpshift.support.Log;
import com.helpshift.support.Support;
import com.helpshift.InstallConfig;
import com.helpshift.exceptions.InstallException;

import java.io.File;

public class MainApplication extends Application implements Support.Delegate {

  private String TAG = "Helpshift";

  @Override
  public void onCreate() {
    super.onCreate();

    Core.init(All.getInstance());
    InstallConfig installConfig = new InstallConfig.Builder()
                               .setEnableInAppNotification(true)
                               .build();
    try {
      Core.install(this,
                   "<your api key>",
                   "<your domain>",
                   "<your app id>",
                   installConfig);
    } catch (InstallException e) {
      android.util.Log.e("Helpshift", "install call : ", e);
    }

    android.util.Log.d("Helpshift", Support.libraryVersion + " - is the version for gradle");

    //Set Helpshift Delegate
    Support.setDelegate(this);

  }

  @Override
  public void sessionBegan() {
    Toast.makeText(getApplicationContext(), "Helpshift session began", Toast.LENGTH_SHORT).show();
  }

  @Override
  public void sessionEnded() {
    Toast.makeText(getApplicationContext(), "Helpshift session ended", Toast.LENGTH_SHORT).show();
  }

  @Override
  public void newConversationStarted(String newConversationMessage) {
    Log.d(TAG, "new conversation started with message : " + newConversationMessage);
  }

  @Override
  public void conversationEnded() {
    Log.d(TAG, "conversationEnded");
  }

  @Override
  public void userRepliedToConversation(String newMessage) {
    Log.d(TAG, "user replied with message : " + newMessage);
  }

  @Override
  public void userCompletedCustomerSatisfactionSurvey(int rating, String feedback) {
    Log.d(TAG, "user completed csat with rating " + rating + " and feedback : " + feedback);
  }

  @Override
  public void displayAttachmentFile(File attachmentFile) {
    Log.d(TAG, "no apps can open this file " + attachmentFile.getAbsolutePath());
  }

  @Override
  public void didReceiveNotification(int newMessagesCount) {
    Log.d(TAG, "new messages count : " + newMessagesCount);
  }

  @Override
  public void authenticationFailed(HelpshiftUser helpshiftUser, AuthenticationFailureReason authenticationFailureReason) {
    Log.d(TAG, "Authentication failed for the user, identifier : " + helpshiftUser.getIdentifier() + ", email : " + helpshiftUser.getEmail() + " and reason : " + authenticationFailureReason);
  }
}
