package com.example.prm_assignment.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.prm_assignment.entities.Student;

import java.util.List;

public interface StudentDAO {
    @Insert
    void insertStudent(Student student);

    @Delete
    void deleteStudent(Student student);

    @Update
    void updateStudent(Student student);

    @Query("SELECT * from Student ORDER BY ID ASC")
    LiveData<List<Student>> getAllStudent();
}
