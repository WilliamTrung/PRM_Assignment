package com.example.prm_assignment.dao;

import android.arch.persistence.room.Transaction;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.prm_assignment.entities.Class;
import com.example.prm_assignment.models.ClassStudying;

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

    @Query("SELECT * FROM Class WHERE Class.Mentor_ID == (:mentor_id)")
    LiveData<List<Class>> getClassesByMentor(int mentor_id);

    @Transaction
    @Query("SELECT * FROM Class WHERE Class.ID == (:class_id)")
    ClassStudying getClassStudents(int class_id);
}
