package com.example.prm_assignment.models;

import com.example.prm_assignment.entities.Class;
import com.example.prm_assignment.entities.Mentor;
import com.example.prm_assignment.entities.Student;

import java.util.List;

public class ClassModel {
    private Class room;
    private Mentor mentor;
    private List<Student> students;

    public Class getRoom() {
        return room;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    public ClassModel(Class room, Mentor mentor, List<Student> students){
        this.room = room;
        this.mentor = mentor;
        this.students = students;
    }
}
