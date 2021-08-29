package com.example.taskmaster;

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

    public void addTask(View view) {
        Intent i=new Intent(MainActivity.this,addTask.class);
        startActivity(i);
    }

    public void allTask(View view) {
        Intent i=new Intent(MainActivity.this,allTasks.class);
        startActivity(i);
    }
}