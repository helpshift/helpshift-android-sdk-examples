package com.helpshift.helpshiftdemogradle;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.helpshift.support.ApiConfig;
import com.helpshift.support.Support;

public class NavDrawerStandaloneToolbarActivity extends AppCompatActivity
 implements AdapterView.OnItemClickListener {

  private static final String[] drawerOptions = new String[]{
   "FAQs Fragment",
   "Conversation Fragment",
   "Single Section Fragment",
   "Single Question Fragment"};

  private DrawerLayout drawerLayout;

  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.navigation_drawer_activity);
    setupToolbar();
    setupNavigationDrawer();
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.navigation_drawer);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.addDrawerListener(toggle);
    toggle.syncState();
  }

  private void setupToolbar() {
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    toolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);
    toolbar.setNavigationOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        onBackPressed();
      }
    });
  }

  private void setupNavigationDrawer() {
    drawerLayout = (DrawerLayout) findViewById(R.id.navigation_drawer);
    ListView drawerList = (ListView) findViewById(R.id.left_drawer);
    drawerList.setAdapter(new ArrayAdapter<>(this,
                                             android.R.layout.simple_list_item_1,
                                             drawerOptions));
    drawerList.setOnItemClickListener(this);
  }

  @Override
  public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
    switch (position) {
      case 0:
        getAndShowFAQsFragment();
        drawerLayout.closeDrawer(GravityCompat.START);
        break;
      case 1:
        getAndShowConversationFragment();
        drawerLayout.closeDrawer(GravityCompat.START);
        break;
      case 2:
        getAndShowSingleSectionFragment();
        drawerLayout.closeDrawer(GravityCompat.START);
        break;
      case 3:
        getAndShowSingleQuestionFragment();
        drawerLayout.closeDrawer(GravityCompat.START);
        break;
    }
  }

  private void getAndShowConversationFragment() {
    ApiConfig config = new ApiConfig.Builder()
                        .setToolbarId(R.id.toolbar)
                        .build();

    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    fragmentTransaction.add(R.id.fragment_container,
     Support.getConversationFragment(this, config));
    fragmentTransaction.commit();
  }

  private void getAndShowSingleSectionFragment() {
    ApiConfig config = new ApiConfig.Builder()
                        .setToolbarId(R.id.toolbar)
                        .build();

    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    fragmentTransaction.add(R.id.fragment_container,
     Support.getFAQSectionFragment(this, "sectionPublishId", config));
    fragmentTransaction.commit();
  }

  private void getAndShowSingleQuestionFragment() {
    ApiConfig config = new ApiConfig.Builder()
                        .setToolbarId(R.id.toolbar)
                        .build();

    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    fragmentTransaction.add(R.id.fragment_container,
     Support.getSingleFAQFragment(this, "questionPublishId", config));
    fragmentTransaction.commit();
  }

  private void getAndShowFAQsFragment() {
    ApiConfig config = new ApiConfig.Builder()
                        .setToolbarId(R.id.toolbar)
                        .build();

    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    fragmentTransaction.add(R.id.fragment_container,
     Support.getFAQsFragment(this, config));
    fragmentTransaction.commit();
  }
}
