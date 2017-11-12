package com.bartek.pluto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

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

    }

    public void exit(View view){
        finishAffinity();
        System.exit(0);
    }

}
