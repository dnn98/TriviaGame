package com.example.triviagame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView hello = findViewById(R.id.hello);
        //loading prefs
        SharedPreferences prefs = getSharedPreferences("last_launch", MODE_PRIVATE);
        String name = prefs.getString("dateTime", "No name defined");//"No name defined" is the default value.
        hello.setText("Last launch: "+name);

        SharedPreferences lastTime = getSharedPreferences("last_launch", MODE_PRIVATE);
        Date now = new Date();

        SimpleDateFormat format = new SimpleDateFormat ("EEE MMM dd HH:mm:ss zzz yyyy");

        Log.i(TAG, "In MainActivity");

        if (lastTime.contains("dateTime") == true) {
            String dateTime = lastTime.getString("dateTime", "Default");
            Log.i(TAG, "In MainActivity: " + dateTime);
        }
        SharedPreferences.Editor dateEditor = lastTime.edit();

        dateEditor.putString("dateTime",format.format(now));
        dateEditor.apply();
        dateEditor.commit();
    }
}
