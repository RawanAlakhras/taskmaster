package com.example.taskmaster;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taskmaster.dummy.DummyContent;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class taskFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    private static final String ARG_PARAM1 = "taskTitle";
    private static final String ARG_PARAM2 = "taskBody";
    private static final String ARG_PARAM3 = "taskState";
    // TODO: Customize parameters
    private int mColumnCount = 3;
    private String title;
    private String body;
    private String state;


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public taskFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static taskFragment newInstance(int columnCount,String title,String body ,String state) {
        taskFragment fragment = new taskFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        args.putString(ARG_PARAM1, title);
        args.putString(ARG_PARAM2, body);
        args.putString(ARG_PARAM3, state);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
            title = getArguments().getString(ARG_PARAM1);
            body = getArguments().getString(ARG_PARAM2);
            state = getArguments().getString(ARG_PARAM3);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            // Create some data
//            List<Task> allTasks = new ArrayList<Task>();
//            allTasks.add(new Task("Reading","read class 29","new"));
//            allTasks.add(new Task("lab","lab class 28","in progress"));
//            allTasks.add(new Task("code challenge","challenge 28","assigned"));
//
//
//          recyclerView.setAdapter(new MyItemRecyclerViewAdapter(allTasks));
        }
        return view;
    }
}