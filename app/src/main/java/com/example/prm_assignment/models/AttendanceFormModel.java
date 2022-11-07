package com.example.prm_assignment.models;

import com.example.prm_assignment.entities.Attendance;
import com.example.prm_assignment.entities.Class;
import com.example.prm_assignment.entities.Student;

import java.util.ArrayList;
import java.util.List;

public class AttendanceFormModel {
    private Class room;
    private List<AttendanceModel> attendances;

    public AttendanceFormModel(Class room, List<AttendanceModel> attendances){
        this.room = room;
        this.attendances = attendances;
    }
    public Class getRoom(){
        return room;
    }
    public List<AttendanceModel> getAttendances() {
        return attendances;
    }
    public boolean checkStudent(Student student){
        for (AttendanceModel attendanceModel: attendances
             ) {
            if(attendanceModel.getStudent().id == student.id){
                return true;
            }
        }
        return false;
    }

    public void addAttendance(AttendanceModel attendanceModel){
        if(!checkStudent(attendanceModel.getStudent())){
            attendances.add(attendanceModel);
        }
    }
}
