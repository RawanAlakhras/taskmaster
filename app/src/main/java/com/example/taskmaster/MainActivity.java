package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

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

        TaskDatabase db = Room.databaseBuilder(getApplicationContext(),TaskDatabase.class, "task_item3").allowMainThreadQueries().build();
       TaskDao taskDao=db.taskDao();
        List<Task> allTasks = taskDao.getAll();
//        allTasks.add(new Task("Reading","read class 29","new"));
//        allTasks.add(new Task("lab","lab class 28","in progress"));
//        allTasks.add(new Task("code challenge","challenge 28","assigned"));
//         get the recycler view
        RecyclerView allStudentsRecuclerView = findViewById(R.id.ListRecyclerView);
        // set a layout manager for this view
        allStudentsRecuclerView.setLayoutManager(new LinearLayoutManager(this));
        // set the adapter for this recyclerView
        allStudentsRecuclerView.setAdapter(new MyItemRecyclerViewAdapter(allTasks));

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
        TextView btn = (TextView) view;
        String title= (String) btn.getText();
        i.putExtra("title",title);
        startActivity(i);

    }
    public void setting(View view){
        Intent i=new Intent(MainActivity.this,Settings.class);
        startActivity(i);

    }
}