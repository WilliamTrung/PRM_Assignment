package com.example.prm_assignment.entities;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Mentor {
    @PrimaryKey
    @ColumnInfo(name = "ID")
    public String id;

    @ColumnInfo(name = "Name")
    public String name;

    @ColumnInfo(name = "Password")
    public String password;
}
