package com.bartek.pluto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class PrematchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prematch);
    }



    public void go(View view){
        Intent newMatch = new Intent(this, MatchActivity.class);

        TextView teamAName = findViewById(R.id.nameA);
        TextView teamBName = findViewById(R.id.nameB);
        String nameA = teamAName.getText().toString();
        String nameB = teamBName.getText().toString();

        if (namesExceptions(nameA) && namesExceptions(nameB)){
            newMatch.putExtra("TeamAName", nameA);
            newMatch.putExtra("TeamBName", nameB);
            startActivity(newMatch);
        }
    }

    private boolean namesExceptions(String name) {
        boolean consent = true;
        if (name.length() == 0) {
            Toast.makeText(this, "Enter names of teams!", Toast.LENGTH_SHORT).show();
            consent = false;
        }
        else if (name.length() > 20) {
            Toast.makeText(this, "Names of teams must have at least 20 chars!", Toast.LENGTH_SHORT).show();
            consent = false;
        }
        return consent;
    }
}
