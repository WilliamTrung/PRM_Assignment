package com.example.prm_assignment.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.prm_assignment.entities.Attendance;

import java.util.List;

public interface AttendanceDAO {
    @Insert
    void insertAttendance(Attendance attendance);

    @Delete
    void deleteAttendance(Attendance attendance);

    @Update
    void updateAttendance(Attendance attendance);

    @Query("SELECT * from Attendance ORDER BY Class_ID ASC")
    LiveData<List<Attendance>> getAllAttendance();

    @Query("UPDATE Studying set Status = status")
    LiveData<Attendance> updateStatus(String student_id, String class_id, boolean status);
}