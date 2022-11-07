package com.example.prm_assignment.models;

import com.example.prm_assignment.entities.Attendance;
import com.example.prm_assignment.entities.Class;
import com.example.prm_assignment.entities.Mentor;
import com.example.prm_assignment.entities.Student;

import java.util.List;

public class AttendanceModel {
    private Student student;
    private boolean status;
    private Class room;

    public Student getStudent() {
        return student;
    }

    public boolean isStatus() {
        return status;
    }

    public Class getRoom() {
        return room;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public AttendanceModel(Student student, Class room){
        this.student = student;
        this.room = room;
        status = false;
    }
}
