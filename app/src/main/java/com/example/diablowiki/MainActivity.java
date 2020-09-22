package com.example.diablowiki;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
//THIS ACTIVITY IS FOR APP INTRO
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchFirstActivity(View view){
        Intent intent = new Intent(this, FirstActivity.class);
        startActivity(intent);
    }
}
