package com.example.prm_assignment.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {@ForeignKey(entity = Mentor.class,
        parentColumns = "ID",
        childColumns = "Mentor_ID",
        onDelete = ForeignKey.CASCADE)
})
public class Class {
    @PrimaryKey
    @ColumnInfo(name = "ID")
    public String id;

    @ColumnInfo(name = "Mentor_ID")
    public String mentor_id;
}