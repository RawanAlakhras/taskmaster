package com.example.taskmaster;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amplifyframework.datastore.generated.model.Todo;
import com.example.taskmaster.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

     List<DummyItem> mValues;
     List<Todo> allTask=new ArrayList<>();

    public MyItemRecyclerViewAdapter(List<DummyItem> items, List<Todo> allTask) {
        mValues = items;
        this.allTask = allTask;
    }
    public MyItemRecyclerViewAdapter(List<Todo> task) {
        allTask = task;
    }

    // 3- create the ViewHolder class (Wraps the data and the view)
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // 4- The model object
        public Todo task;
        // 5- view object
        View itemView;
        // + setting the itemView value


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            //set on click on fragement to handel item's click
            itemView.findViewById(R.id.frag);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(), TaskDetail.class);
                    //send data to taskDescription activity
                    i.putExtra("title", task.getTitle());
                    i.putExtra("body", task.getBody());
                    i.putExtra("state", task.getState());
                    v.getContext().startActivity(i);
                }
            });

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_task, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.task = allTask.get(position);
        TextView title = holder.itemView.findViewById(R.id.title);
        TextView body = holder.itemView.findViewById(R.id.body);
        TextView state=holder.itemView.findViewById(R.id.state);
        title.setText(holder.task.getTitle());
        body.setText(holder.task.getBody());
        state.setText(holder.task.getState());

    }

    @Override
    public int getItemCount() {
        return allTask.size();
    }


}