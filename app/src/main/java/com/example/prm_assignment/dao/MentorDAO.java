package com.example.prm_assignment.dao;

import android.arch.persistence.room.Transaction;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.prm_assignment.entities.Mentor;
import com.example.prm_assignment.models.MentorClasses;

import java.util.List;

public interface MentorDAO {
    @Insert
    void insertMentor(Mentor mentor);

    @Delete
    void deleteMentor(Mentor mentor);

    @Update
    void updateMentor(Mentor mentor);

    @Query("SELECT * from Mentor ORDER BY ID ASC")
    LiveData<List<Mentor>> getAllMentor();

    @Transaction
    @Query("SELECT * FROM Mentor WHERE Mentor.Name == (:name) AND Mentor.Password == (:password)")
    public LiveData<MentorClasses> login(String name, String password);
}