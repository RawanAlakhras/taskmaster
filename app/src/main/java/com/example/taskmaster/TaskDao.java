package com.example.taskmaster;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TaskDao {
    @Query("SELECT * FROM task")
    List<Task> getAll();

//    @Query("SELECT * FROM task WHERE id IN (id)")
//    List<Task> loadAllByIds(int[] dishIds);

    @Query("SELECT * FROM task WHERE title LIKE :title LIMIT 1")
    Task findByName(String title);

    @Insert
    void insertAll(Task... tasks);

    @Delete
    void delete(Task task);

    @Insert
    void insertOne(Task task);
}
