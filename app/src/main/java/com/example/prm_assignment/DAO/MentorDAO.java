package com.example.prm_assignment.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.prm_assignment.Model.Mentor;

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
}