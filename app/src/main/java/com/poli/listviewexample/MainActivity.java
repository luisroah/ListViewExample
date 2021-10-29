package com.poli.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

     public void loadNextActivity(View view){
        Intent listViewActivity = new Intent(this, ListaNombres.class);
        listViewActivity.putExtra("Test", 0);
        startActivity(listViewActivity);

     }
}