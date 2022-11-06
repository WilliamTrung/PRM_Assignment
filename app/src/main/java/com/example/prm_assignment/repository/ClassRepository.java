package com.example.prm_assignment.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.prm_assignment.dao.AttendanceDAO;
import com.example.prm_assignment.dao.ClassDAO;
import com.example.prm_assignment.dao.MentorDAO;
import com.example.prm_assignment.dao.StudyingDAO;
import com.example.prm_assignment.entities.Attendance;
import com.example.prm_assignment.entities.Class;
import com.example.prm_assignment.entities.Mentor;
import com.example.prm_assignment.models.ClassStudying;
import com.example.prm_assignment.models.MentorClasses;
import com.example.prm_assignment.models.StudyingStudents;
import com.example.prm_assignment.room.CheckAttendanceDatabase;

import java.util.List;

public class ClassRepository {
    private ClassDAO classDAO;
    private LiveData<List<Class>> classes;

    public ClassRepository(Application application, Mentor mentor){
        CheckAttendanceDatabase db =  CheckAttendanceDatabase.getDatabase(application);
        classDAO = db.classDAO();
        classes = classDAO.getClassesByMentor(mentor.id);
    }
    public ClassStudying getClassStudents(int class_id){
        return classDAO.getClassStudents(class_id);
    }
    public void insert(Class classStudying){
        new ClassRepository.insertAsync(classDAO).execute(classStudying);
    }
    public void update(Class classStudying, Mentor mentor){

    }
    private static class insertAsync extends AsyncTask<Class, Void, Void> {

        private ClassDAO classDAO;

        insertAsync(ClassDAO dao) {
            classDAO = dao;
        }

        @Override
        protected Void doInBackground(final Class... params) {
            classDAO.insertClass(params[0]);
            return null;
        }
    }
    private static class deleteAsync extends AsyncTask<Class, Void, Void> {

        private ClassDAO classDAO;

        deleteAsync(ClassDAO dao) {
            classDAO = dao;
        }

        @Override
        protected Void doInBackground(final Class... params) {
            classDAO.deleteClass(params[0]);
            return null;
        }
    }
}
