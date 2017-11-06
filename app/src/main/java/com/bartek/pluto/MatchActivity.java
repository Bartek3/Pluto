package com.bartek.pluto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MatchActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        Intent preMatch = getIntent();
        String teamAName = preMatch.getStringExtra("TeamAName");
        String teamBName = preMatch.getStringExtra("TeamBName");

        TextView teamANameTV = findViewById(R.id.teamAName);
        TextView teamBNameTV = findViewById(R.id.teamBName);
        TextView teamANameBisTV = findViewById(R.id.teamANameBis);
        TextView teamBNameBisTV = findViewById(R.id.teamBNameBis);

        teamANameTV.setText(teamAName);
        teamANameBisTV.setText(teamAName);

        teamBNameTV.setText(teamBName);
        teamBNameBisTV.setText(teamBName);
    }

    int gemsA;
    int gemsB;
    int setsA;
    int setsB;
    int[][] resultsOfSets = new int[5][2];

    public void gemForA(View view) {
        gemsA += 1;
        displayGemsA();
        if (endOfSet(gemsA, gemsB, setsA, setsB)) {
            setsA += 1;
            displaySetsA();
            addGemsToResults();
            resetGems();
            if (endOfMatch(setsA)) {
                endOfMatchActivity();
            }
        }
    }

    public void gemForB(View view) {
        gemsB += 1;
        displayGemsB();
        if (endOfSet(gemsB, gemsA, setsA, setsB)) {
            setsB += 1;
            displaySetsB();
            addGemsToResults();
            resetGems();
            if (endOfMatch(setsB)) {
                endOfMatchActivity();
            }
        }
    }

    public void displayGemsA() {
        TextView gemsOfA = findViewById(R.id.gemsA);
        gemsOfA.setText(String.valueOf(gemsA));
    }

    public void displayGemsB() {
        TextView gemsOfB = findViewById(R.id.gemsB);
        gemsOfB.setText(String.valueOf(gemsB));
    }

    public void displaySetsA() {
        TextView setsOfA = findViewById(R.id.setsA);
        setsOfA.setText(String.valueOf(setsA));
    }

    public void displaySetsB() {
        TextView setsOfB = findViewById(R.id.setsB);
        setsOfB.setText(String.valueOf(setsB));
    }

    public void resetGems() {
        gemsA = 0;
        gemsB = 0;
        displayGemsA();
        displayGemsB();
    }

    public boolean endOfSet(int gems1, int gems2, int setsA, int setsB) {
        if (setsA + setsB != 4) {
            if (gems1 >= 25 && gems1 - gems2 >= 2) {
                Toast.makeText(this, "Set " + (1 + setsA + setsB) + ". has ended", Toast.LENGTH_SHORT).show();
                return true;
            }
        } else if (gems1 >= 15 && gems1 - gems2 >= 2) {
            return true;
        }
        return false;
    }

    public void addGemsToResults(){
        resultsOfSets[setsA+setsB-1][0] = gemsA;
        resultsOfSets[setsA+setsB-1][1] = gemsB;
    }

    private static boolean endOfMatch(int sets) {
        if (sets == 3) {
            return true;
        } else return false;
    }

    private void endOfMatchActivity() {
        Intent afterMatch = new Intent(this, AftermatchActivity.class);

        Intent preMatch = getIntent();
        String teamAName = preMatch.getStringExtra("TeamAName");
        String teamBName = preMatch.getStringExtra("TeamBName");
        String result = (setsA + ":" + setsB);

        Match thisMatch = new Match(teamAName, teamBName, null, null, result, resultsOfSets);
        afterMatch.putExtra("Match", thisMatch);
        startActivity(afterMatch);
    }
}
