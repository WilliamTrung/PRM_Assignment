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

    @Query("SELECT * FROM Student s left join Studying sing on s.ID == sing.Student_ID AND sing.Class_ID == (:class_id)")
    List<Student> getStudentsByClassId(int class_id);
}
