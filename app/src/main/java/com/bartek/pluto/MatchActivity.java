package com.bartek.pluto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MatchActivity extends AppCompatActivity {

    String teamAName;
    String teamBName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        Intent preMatch = getIntent();
        teamAName = preMatch.getStringExtra("TeamAName");
        teamBName = preMatch.getStringExtra("TeamBName");

        TextView teamANameTV = findViewById(R.id.teamAName);
            teamANameTV.setText(teamAName);
        TextView teamBNameTV = findViewById(R.id.teamBName);
            teamBNameTV.setText(teamBName);
        TextView teamANameBisTV = findViewById(R.id.teamANameBis);
            teamANameBisTV.setText(teamAName);
        TextView teamBNameBisTV = findViewById(R.id.teamBNameBis);
            teamBNameBisTV.setText(teamBName);
    }

    int[] actualPoints = new int[120];
    int[][] resultsOfSets = new int[5][2];

    Match match = new Match(teamAName, teamBName, 0, 0, 0,0, actualPoints, resultsOfSets);

    public void gemForA(View view) {
        match.pointForA();
        displayPointsA();
        displayPointsB();
        displaySetsA();
        endOfMatch();
    }

    public void gemForB(View view) {
        match.pointForB();
        displayPointsA();
        displayPointsB();
        displaySetsB();
        endOfMatch();
    }

    public void save(View view) {

    }

    public void undo(View view) {
        if (match.getPointsA() + match.getPointsB() == 0){
            Toast.makeText(this, "You can't undo when teams has no points!", Toast.LENGTH_SHORT).show();
        }
        else {
            match.undo();
            displayPointsA();
            displayPointsB();
        }
    }

    public void exit(View view) {
        Intent exit = new Intent(this, MenuActivity.class);
        finishAffinity();
        startActivity(exit);
    }

    public void displayPointsA() {
        TextView pointsA = findViewById(R.id.gemsA);
        pointsA.setText(String.valueOf(match.getPointsA()));
    }

    public void displayPointsB() {
        TextView pointsB = findViewById(R.id.gemsB);
        pointsB.setText(String.valueOf(match.getPointsB()));
    }

    public void displaySetsA() {
        TextView setsA = findViewById(R.id.setsA);
        setsA.setText(String.valueOf(match.getSetsA()));
    }

    public void displaySetsB() {
        TextView setsB = findViewById(R.id.setsB);
        setsB.setText(String.valueOf(match.getSetsB()));
    }

    public void endOfMatch(){
        if (match.endOfMatch()){
            Intent afterMatch = new Intent(this, AftermatchActivity.class);
            afterMatch.putExtra("Match", match);
            finishAffinity();
            startActivity(afterMatch);
        }
    }
}
