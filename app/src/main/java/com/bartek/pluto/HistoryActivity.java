package com.bartek.pluto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        HistoryDatabaseHelper db = new HistoryDatabaseHelper(this);
        ArrayList<Match> matches = db.getMatchesFromDB();

        MatchAdapter adapter = new MatchAdapter(this, matches);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
