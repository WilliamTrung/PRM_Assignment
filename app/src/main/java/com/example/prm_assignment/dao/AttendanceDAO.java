package com.example.prm_assignment.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.prm_assignment.entities.Attendance;

import java.sql.Date;
import java.util.List;

public interface AttendanceDAO {
    @Insert
    void insertAttendance(Attendance attendance);

    @Delete
    void deleteAttendance(Attendance attendance);

    @Update
    void updateAttendance(Attendance attendance);

    @Query("UPDATE Attendance set Status = (:status) WHERE Class_ID == (:class_id) AND Student_ID == (:student_id) AND Date == Date(:date)")
    Attendance checkAttendance (int class_id, int student_id, boolean status, Date date);
}