package com.example.prm_assignment.Model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Student {
    @PrimaryKey
    @ColumnInfo(name = "ID")
    public String id;

    @ColumnInfo(name = "Name")
    public String name;
}
