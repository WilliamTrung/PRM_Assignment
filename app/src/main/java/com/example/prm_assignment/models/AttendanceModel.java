package com.example.prm_assignment.models;

import com.example.prm_assignment.entities.Attendance;
import com.example.prm_assignment.entities.Class;
import com.example.prm_assignment.entities.Mentor;
import com.example.prm_assignment.entities.Student;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class AttendanceModel {
    private Student student;
    private boolean status;
    private Class room;
    private Date date;

    public Student getStudent() {
        return student;
    }

    public boolean isStatus() {
        return status;
    }

    public Class getRoom() {
        return room;
    }
    public Date getDate() { return date; }
    public void setDate(Date date){
        this.date = date;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public AttendanceModel(Student student, Class room){
        this.student = student;
        this.room = room;
        status = false;
    }
    public Attendance toAttendance(){
        Attendance attendance = new Attendance();
        attendance.class_id = room.id;
        attendance.student_id = student.id;
        attendance.status = status;
        return attendance;
    }
}
