package com.example.prm_assignment.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.prm_assignment.entities.Studying;

import java.util.List;

public interface StudyingDAO {
    @Insert
    void insertStudying(Studying studying);

    @Delete
    void deleteStudying(Studying studying);

    @Update
    void updateStudying(Studying studying);

    @Query("SELECT * from Studying ORDER BY Class_ID ASC")
    LiveData<List<Studying>> getAllStudying();

    @Query("UPDATE Studying set Status = status")
    LiveData<Studying> updateStatus(String student_id, String class_id, boolean status);

}