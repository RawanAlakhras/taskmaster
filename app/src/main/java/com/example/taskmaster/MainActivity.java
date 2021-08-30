package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String welcomeMessage = "Tasks ";
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        String username = sharedPreferences.getString("name", "my");
        TextView tv=findViewById(R.id.header);
        tv.setText(username +  welcomeMessage);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String welcomeMessage = "Tasks ";
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        String username = sharedPreferences.getString("name", "my");
        TextView tv=findViewById(R.id.header);
        tv.setText(username+"'s " +  welcomeMessage);

    }

    public void addTask(View view) {
        Intent i=new Intent(MainActivity.this,addTask.class);
        startActivity(i);
    }

    public void allTask(View view) {
        Intent i=new Intent(MainActivity.this,allTasks.class);
        startActivity(i);
    }
    public void  TaskDetail(View view){
        Intent i=new Intent(MainActivity.this,TaskDetail.class);
        Button btn = (Button) view;
        String title= (String) btn.getText();
        i.putExtra("title",title);
        startActivity(i);

    }
    public void setting(View view){
        Intent i=new Intent(MainActivity.this,Settings.class);
        startActivity(i);

    }
}