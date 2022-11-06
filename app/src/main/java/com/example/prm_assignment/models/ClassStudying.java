package com.example.prm_assignment.models;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import com.example.prm_assignment.entities.Class;
import com.example.prm_assignment.entities.Studying;

import java.util.List;

public class ClassStudying {
    @Embedded
    public Class studyingClass;
    @Relation(
            entity = Studying.class,
            parentColumn = "ID",
            entityColumn = "Class_ID"
    )
    public List<StudyingStudents> studyingList;
}
