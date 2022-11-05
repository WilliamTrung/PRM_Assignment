package com.example.prm_assignment.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public interface ClassDAO {
    @Insert
    void insertClass(Class classroom);

    @Delete
    void deleteClass(Class classroom);

    @Update
    void updateClass(Class classroom);

    @Query("SELECT * from Class ORDER BY ID ASC")
    LiveData<List<Class>> getAllClass();
}
