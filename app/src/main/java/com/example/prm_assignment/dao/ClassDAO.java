package com.example.prm_assignment.dao;

import android.arch.persistence.room.Transaction;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.prm_assignment.entities.Class;
import com.example.prm_assignment.entities.Mentor;

import java.util.List;

public interface ClassDAO {
    @Insert
    void insertClass(Class classroom);

    @Delete
    void deleteClass(Class classroom);

    @Update
    void updateClass(Class classroom);

    @Query("SELECT * from Class ORDER BY ID ASC")
    List<Class> getAllClass();

    @Query("SELECT * FROM Class WHERE Class.Mentor_ID == (:mentor_id)")
    List<Class> getClassesByMentor(int mentor_id);

    @Query("SELECT * FROM CLASS WHERE ID == (:id)")
    Class getClassById(int id);

    @Query("SELECT * FROM Mentor m left join Class c on m.ID == c.Mentor_ID AND c.ID == (:id)")
    Mentor getMentorByClassId(int id);
}
