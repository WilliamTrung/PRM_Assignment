package com.example.prm_assignment.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.prm_assignment.entities.Mentor;

import java.util.List;

public interface MentorDAO {
    @Insert
    void insertMentor(Mentor mentor);

    @Delete
    void deleteMentor(Mentor mentor);

    @Update
    void updateMentor(Mentor mentor);

    @Query("SELECT * from Mentor ORDER BY ID ASC")
    List<Mentor> getAllMentor();

    @Query("SELECT * FROM MENTOR WHERE ID == (:mentor_name) AND Password == (:password)")
    Mentor login (String mentor_name, String password);

    @Query("INSERT INTO MENTOR (Name, Password) VALUES ((:name), (:password))")
    void insertMentor (String name, String password);
}