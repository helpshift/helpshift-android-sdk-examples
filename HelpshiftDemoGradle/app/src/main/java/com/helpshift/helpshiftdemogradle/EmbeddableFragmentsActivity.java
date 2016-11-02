package com.helpshift.helpshiftdemogradle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EmbeddableFragmentsActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.embeddable_fragments_activity);

    ListView listView = (ListView) findViewById(R.id.list);
    final String[] options = {"Nav drawer - standalone toolbar."};
    listView.setAdapter(new ArrayAdapter<>(this,
                                           android.R.layout.simple_list_item_1,
                                           options));
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
          case 0:
            Intent intent = new Intent(EmbeddableFragmentsActivity.this,
                                       NavDrawerStandaloneToolbarActivity.class);
            startActivity(intent);
            break;
        }
      }
    });
  }
}
