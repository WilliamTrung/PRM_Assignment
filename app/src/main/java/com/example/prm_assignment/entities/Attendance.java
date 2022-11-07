package com.example.prm_assignment.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.sql.Date;

@Entity(foreignKeys =
        {
                @ForeignKey(entity = Student.class,
                        parentColumns = "ID",
                        childColumns = "Student_ID",
                        onDelete = ForeignKey.CASCADE
                ),

                @ForeignKey(entity = Class.class,
                        parentColumns = "ID",
                        childColumns = "Class_ID",
                        onDelete = ForeignKey.CASCADE
                )
        }
)

public class Attendance {
    @PrimaryKey
    @ColumnInfo(name = "Student_ID")
    public int student_id;

    @PrimaryKey
    @ColumnInfo(name = "Class_ID")
    public int class_id;

    @ColumnInfo(name = "Status")
    public boolean status;

    @ColumnInfo(name = "Date")
    public Date date;
}
