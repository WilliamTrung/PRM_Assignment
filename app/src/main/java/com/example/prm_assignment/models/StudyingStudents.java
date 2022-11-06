package com.example.prm_assignment.models;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import com.example.prm_assignment.entities.Student;
import com.example.prm_assignment.entities.Studying;

import java.util.List;

public class StudyingStudents {
    @Embedded
    public Studying studying;
    @Relation(
            parentColumn = "Student_ID",
            entityColumn = "ID"
    )
    public List<Student> students;
}
