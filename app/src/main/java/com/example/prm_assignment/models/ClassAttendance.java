package com.example.prm_assignment.models;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import com.example.prm_assignment.entities.Attendance;
import com.example.prm_assignment.entities.Student;

public class ClassAttendance {
    @Embedded
    public Class aClass;
    @Relation(
            entity = Attendance.class,
            parentColumn = "ID",
            entityColumn = "Class_ID"
    )
    public StudentAttendance studentAttendance;
}
