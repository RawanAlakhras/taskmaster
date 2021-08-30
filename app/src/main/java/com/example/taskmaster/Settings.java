package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

    }
    public void save(View v){
        EditText ed=findViewById(R.id.name);
        String name=ed.getText().toString();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(Settings.this);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        sharedPreferencesEditor.putString("name", name);
        sharedPreferencesEditor.apply();

    }
}