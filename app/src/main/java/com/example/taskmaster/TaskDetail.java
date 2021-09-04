package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TaskDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);
        Intent i =getIntent();
//        TextView tv=findViewById(R.id.title);
//        tv.setText(i.getExtras().getString("title"));
//        TextView tv2=findViewById(R.id.body);
//        tv.setText(i.getExtras().getString("body"));
//        TextView tv3=findViewById(R.id.state);
//        tv.setText(i.getExtras().getString("state"));



        String name = i.getExtras().getString("title");

        String price=i.getExtras().getString("body");
        String ingredients=i.getExtras().getString("state");
        TextView tv1=findViewById(R.id.title1);
        tv1.setText(name);
        TextView tv2=findViewById(R.id.body1);
        tv2.setText(price);
        TextView tv3=findViewById(R.id.state1);
        tv3.setText(ingredients);
    }
}