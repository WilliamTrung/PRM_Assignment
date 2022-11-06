package com.example.prm_assignment.models;

import com.example.prm_assignment.entities.Class;
import com.example.prm_assignment.entities.Mentor;

import java.util.List;

public class MentorModel {
    private Mentor mentor;
    private List<ClassModel> classes;

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    public List<ClassModel> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassModel> classes) {
        this.classes = classes;
    }
    public MentorModel(Mentor mentor, List<ClassModel> classes){
        this.mentor = mentor;
        this.classes = classes;
    }
}
