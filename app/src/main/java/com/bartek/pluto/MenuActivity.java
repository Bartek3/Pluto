package com.bartek.pluto;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void newMatch(View view){
        Intent goToPrematch = new Intent(this, PrematchActivity.class);
        startActivity(goToPrematch);
    }

    public void load(View view){
        Intent newMatch = new Intent(this, MatchActivity.class);
        SharedPreferences mPrefs = getSharedPreferences("prefs", MODE_PRIVATE);

        String json;
        json = mPrefs.getString("MyObject", "");

        if (json.length() > 0) {
            newMatch.putExtra("Marker", "Load");
            newMatch.putExtra("match", json);
            startActivity(newMatch);
        }

        else {
            Toast.makeText(this, "Nothing to load", Toast.LENGTH_SHORT).show();}
    }

    public void exit(View view){
        finishAffinity();
        System.exit(0);
    }

}
