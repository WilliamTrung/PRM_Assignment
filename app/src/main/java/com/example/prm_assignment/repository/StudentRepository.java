package com.example.prm_assignment.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.prm_assignment.dao.StudentDAO;
import com.example.prm_assignment.entities.Student;
import com.example.prm_assignment.room.CheckAttendanceDatabase;

import java.util.List;

public class StudentRepository {
    private StudentDAO studentDAO;

    public StudentRepository(Application application){
        CheckAttendanceDatabase db =  CheckAttendanceDatabase.getDatabase(application);
        studentDAO = db.studentDAO();
    }
    public List<Student> getStudentsByClassId(int class_id){
        return studentDAO.getStudentsByClassId(class_id);
    }
    public void updateMultiple(List<Student> students){
        for (Student student : students
             ) {
            update(student);
        }
    }
    public void insertMultiple(List<Student> students){
        for (Student student : students
             ) {
            insert(student);
        }
    }
    public void insert(Student student){
        new insertAsync(studentDAO).execute(student);
    }
    public void update(Student student){
        new updateAsync(studentDAO).execute(student);
    }
    private static class insertAsync extends AsyncTask<Student, Void, Void> {

        private StudentDAO studentDAO;

        insertAsync(StudentDAO dao) {
            studentDAO = dao;
        }

        @Override
        protected Void doInBackground(final Student... params) {
            studentDAO.insertStudent(params[0]);
            return null;
        }
    }
    private static class updateAsync extends AsyncTask<Student, Void, Void> {

        private StudentDAO studentDAO;

        updateAsync(StudentDAO dao) {
            studentDAO = dao;
        }

        @Override
        protected Void doInBackground(final Student... params) {
            studentDAO.updateStudent(params[0]);
            return null;
        }
    }
}
