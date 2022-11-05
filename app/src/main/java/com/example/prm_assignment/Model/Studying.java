package com.example.prm_assignment.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

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
public class Studying {
    @PrimaryKey
    @ColumnInfo(name = "Student_ID")
    public String student_id;

    @PrimaryKey
    @ColumnInfo(name = "Class_ID")
    public String class_id;

    @ColumnInfo(name = "Status")
    public boolean status;
}
