package com.example.taskmaster;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.taskmaster.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

     List<DummyItem> mValues;
     List<Task> allTask=new ArrayList<>();

    public MyItemRecyclerViewAdapter(List<DummyItem> items, List<Task> allTask) {
        mValues = items;
        this.allTask = allTask;
    }
    public MyItemRecyclerViewAdapter(List<Task> task) {
        allTask = task;
    }

    // 3- create the ViewHolder class (Wraps the data and the view)
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // 4- The model object
        public Task task;
        // 5- view object
        View itemView;
        // + setting the itemView value


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
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
        title.setText(holder.task.title);
        body.setText(holder.task.body);
        state.setText(holder.task.state);

    }

    @Override
    public int getItemCount() {
        return allTask.size();
    }


}