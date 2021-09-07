package com.example.taskmaster;

import android.content.Intent;
import android.os.Bundle;

import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Todo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.room.Room;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class addTask extends AppCompatActivity {
    public static final String TASK_ITEM = "task_item3";
    public TaskDatabase db;
    public  TaskDao taskDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        db = Room.databaseBuilder(getApplicationContext(),
                TaskDatabase.class, TASK_ITEM).allowMainThreadQueries()
                .build();
        taskDao = db.taskDao();

    }

    public void submitted(View view) {


        //get data from edit text
        EditText et1=findViewById(R.id.title);
        EditText et2=findViewById(R.id.body);
        EditText et3=findViewById(R.id.state);

        Todo todo = Todo.builder()
                .title(et1.getText().toString())
                .body(et2.getText().toString())
                .state(et3.getText().toString())
                .build();

        Amplify.API.mutate(
                ModelMutation.create(todo),
                response -> Log.i("MyAmplifyApp", "Added Todo with id: " + response.getData().getId()),
                error -> Log.e("MyAmplifyApp", "Create failed", error)
        );

        //create new object and add data to it

        //Task newTask=new Task(et1.getText().toString(),et2.getText().toString(),et3.getText().toString());

        //save new object in dataBase
       // taskDao.insertOne(newTask);
        Toast.makeText(this,"the task saved you can see it in home",Toast.LENGTH_SHORT).show();
    }

    public void home(View view) {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}