package com.bartek.pluto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class AftermatchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aftermatch);

/*        TextView teamA = findViewById(R.id.teamAName);
        TextView teamB = findViewById(R.id.teamBName);
        TextView result = findViewById(R.id.result);
        TextView set1results = findViewById(R.id.set1);
        TextView set2results = findViewById(R.id.set2);
        TextView set3results = findViewById(R.id.set3);
        TextView set4results = findViewById(R.id.set4);
        TextView set5results = findViewById(R.id.set5);

        int[][] res = thisMatch.getResultsOfSets();

        teamA.setText(thisMatch.getTeamAName());
        teamB.setText(thisMatch.getTeamBName());
        result.setText("HAHA");
        set1results.setText(String.valueOf(res[0][0]) + " : " + String.valueOf(res[0][1]));
        set2results.setText(String.valueOf(res[1][0]) + " : " +  String.valueOf(res[1][1]));
        set3results.setText(String.valueOf(res[2][0]) + " : " +  String.valueOf(res[2][1]));

        if (res[3][0] > 0 && res[3][1] > 0){
            set4results.setText(String.valueOf(res[3][0]) + " : " +  String.valueOf(res[3][1]));
            if (res[4][0] > 0 && res[4][1] > 0){
                set5results.setText(String.valueOf(res[4][0]) + " : " +  String.valueOf(res[4][1]));
            }
        }

        Toast.makeText(this, "Match has ended", Toast.LENGTH_SHORT).show();*/
    }
}
