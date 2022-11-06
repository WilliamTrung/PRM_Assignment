package com.example.prm_assignment.models;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import com.example.prm_assignment.entities.Class;
import com.example.prm_assignment.entities.Mentor;

import java.util.List;

public class MentorClasses {
    @Embedded
    public Mentor mentor;
    @Relation(
            parentColumn = "ID",
            entityColumn = "Mentor_Id"
    )
    public List<Class> classes;
}
