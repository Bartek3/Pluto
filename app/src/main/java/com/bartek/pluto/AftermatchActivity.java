package com.bartek.pluto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

public class AftermatchActivity extends AppCompatActivity {

    HistoryDatabaseHelper db = new HistoryDatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aftermatch);

        Match match = (Match) getIntent().getSerializableExtra("match");
        Boolean endOfMatch = getIntent().getBooleanExtra("endOfMatch", false);

        if (match != null) {

            if (endOfMatch) {
                Gson gson = new Gson();
                String json = gson.toJson(match);
                db.insertData(json);
                Toast.makeText(this, "Match has ended", Toast.LENGTH_SHORT).show();
            }

            TextView teamA = findViewById(R.id.teamAName);
            TextView teamB = findViewById(R.id.teamBName);
            TextView result = findViewById(R.id.result);
            TextView set1results = findViewById(R.id.set1);
            TextView set2results = findViewById(R.id.set2);
            TextView set3results = findViewById(R.id.set3);
            TextView set4results = findViewById(R.id.set4);
            TextView set5results = findViewById(R.id.set5);

            int[][] res = match.getResultsOfSets();
            String A = match.getTeamAName();
            String B = match.getTeamBName();

            teamA.setText(A);
            teamB.setText(B);
            result.setText(String.valueOf(match.getSetsA()) + " : " + String.valueOf(match.getSetsB()));
            set1results.setText(String.valueOf(res[0][0]) + " : " + String.valueOf(res[0][1]));
            set2results.setText(String.valueOf(res[1][0]) + " : " + String.valueOf(res[1][1]));
            set3results.setText(String.valueOf(res[2][0]) + " : " + String.valueOf(res[2][1]));

            if (res[3][0] > 0 && res[3][1] > 0) {
                set4results.setText(String.valueOf(res[3][0]) + " : " + String.valueOf(res[3][1]));
                if (res[4][0] > 0 && res[4][1] > 0) {
                    set5results.setText(String.valueOf(res[4][0]) + " : " + String.valueOf(res[4][1]));
                }
            }
        }


    }

    public void go(View view) {
        Intent exit = new Intent(this, MenuActivity.class);
        finishAffinity();
        startActivity(exit);
    }
}
