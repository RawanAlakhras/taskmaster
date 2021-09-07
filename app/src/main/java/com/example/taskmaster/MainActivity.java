package com.example.taskmaster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Todo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            // Add these lines to add the AWSApiPlugin plugins
            Amplify.addPlugin(new AWSApiPlugin());
            Amplify.configure(getApplicationContext());

            Log.i("MyAmplifyApp", "Initialized Amplify");
        } catch (AmplifyException error) {
            Log.e("MyAmplifyApp", "Could not initialize Amplify", error);
        }
        String welcomeMessage = "Tasks ";
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        String username = sharedPreferences.getString("name", "my");
        TextView tv=findViewById(R.id.header);
        tv.setText(username +  welcomeMessage);

        RecyclerView allStudentsRecuclerView = findViewById(R.id.ListRecyclerView);
        List <Todo> allTasks = new ArrayList<>();
        //handler
        Handler handler=new Handler(Looper.getMainLooper(), new Handler.Callback() {
            @Override
            public boolean handleMessage(@NonNull Message msg) {
                allStudentsRecuclerView.getAdapter().notifyDataSetChanged();

                return false;
            }
        });

        //database


        // set a layout manager for this view
        allStudentsRecuclerView.setLayoutManager(new LinearLayoutManager(this));
        // set the adapter for this recyclerView


        Amplify.API.query(
                ModelQuery.list(Todo.class),
                response -> {
                    for (Todo todo : response.getData()) {
                        Log.i("MyAmplifyApp", todo.getTitle());
                        allTasks.add(todo);
//                        Log.i("My",allTasks.toString());
//                        Log.i("My",allTasks.toString());
//                        Log.i("My",allTasks.toString());
//                        Log.i("My",allTasks.toString());
                    }

                },
                error -> Log.e("MyAmplifyApp", "Query failure", error)
        );

        allStudentsRecuclerView.setAdapter(new MyItemRecyclerViewAdapter(allTasks));

//        TaskDatabase db = Room.databaseBuilder(getApplicationContext(),TaskDatabase.class, "task_item3").allowMainThreadQueries().build();
//       TaskDao taskDao=db.taskDao();




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