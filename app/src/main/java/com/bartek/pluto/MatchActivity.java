package com.bartek.pluto;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

public class MatchActivity extends AppCompatActivity {

    String teamAName;
    String teamBName;
    String json;
    int[] actualPoints = new int[120];
    int[][] resultsOfSets = new int[5][2];
    Match match;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        Intent preMatch = getIntent();
        if (preMatch.getStringExtra("Marker").equals("Load")) {
            Gson gson = new Gson();
            json = preMatch.getStringExtra("match");
            match = gson.fromJson(json, Match.class);
            teamAName = match.getTeamAName();
            teamBName = match.getTeamBName();

            displayPointsA();
            displayPointsB();
            displaySetsA();
            displaySetsB();
        } else {
            teamAName = preMatch.getStringExtra("TeamAName");
            teamBName = preMatch.getStringExtra("TeamBName");
            match = new Match(teamAName, teamBName, 0, 0, 0, 0, actualPoints, resultsOfSets);
        }

        TextView teamANameTV = findViewById(R.id.teamAName);
        teamANameTV.setText(teamAName);
        TextView teamBNameTV = findViewById(R.id.teamBName);
        teamBNameTV.setText(teamBName);
        TextView teamANameBisTV = findViewById(R.id.teamANameBis);
        teamANameBisTV.setText(teamAName);
        TextView teamBNameBisTV = findViewById(R.id.teamBNameBis);
        teamBNameBisTV.setText(teamBName);
    }

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
        SharedPreferences mPrefs = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();

        TextView teamAName = findViewById(R.id.teamAName);
        TextView teamBName = findViewById(R.id.teamBName);

        match.setTeamAName(teamAName.getText().toString());
        match.setTeamBName(teamBName.getText().toString());

        Gson gson = new Gson();
        String json = gson.toJson(match);
        prefsEditor.putString("MyObject", json);
        prefsEditor.apply();
    }

    public void undo(View view) {
        if (match.getPointsA() + match.getPointsB() == 0) {
            Toast.makeText(this, "You can't undo when teams has no points!", Toast.LENGTH_SHORT).show();
        } else {
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

    public void endOfMatch() {
        if (match.endOfMatch()) {
            TextView teamAName = findViewById(R.id.teamAName);
            TextView teamBName = findViewById(R.id.teamBName);

            match.setTeamAName(teamAName.getText().toString());
            match.setTeamBName(teamBName.getText().toString());

            Intent afterMatch = new Intent(this, AftermatchActivity.class);

            Bundle bundle = new Bundle();
            bundle.putSerializable("match", match);
            bundle.putBoolean("endOfMatch", true);
            afterMatch.putExtras(bundle);

            finishAffinity();
            startActivity(afterMatch);
        }
    }
}
