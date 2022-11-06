package com.example.prm_assignment.models;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import com.example.prm_assignment.entities.Attendance;
import com.example.prm_assignment.entities.Student;

public class StudentAttendance {
    @Embedded
    public Student student;
    @Relation(
            parentColumn = "ID",
            entityColumn = "Student_ID"
    )
    public Attendance attendance;
}
