package com.example.prm_assignment.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.prm_assignment.dao.ClassDAO;
import com.example.prm_assignment.dao.StudentDAO;
import com.example.prm_assignment.entities.Class;
import com.example.prm_assignment.entities.Mentor;
import com.example.prm_assignment.entities.Student;
import com.example.prm_assignment.models.ClassModel;
import com.example.prm_assignment.room.CheckAttendanceDatabase;

import java.util.ArrayList;
import java.util.List;

public class ClassRepository {
    private ClassDAO classDAO;
    private StudentRepository studentRepository;
    public ClassRepository(Application application){
        CheckAttendanceDatabase db =  CheckAttendanceDatabase.getDatabase(application);
        studentRepository = new StudentRepository(application);
        classDAO = db.classDAO();
    }
    public ClassModel getClassModelByMentorId_RoomId(int mentor_id, int room_id){
        List<Student> students = studentRepository.getStudentsByClassId(room_id);
        Class room = classDAO.getClassById(room_id);
        ClassModel classModel = new ClassModel(room, mentor_id, students);
        return classModel;
    }
    public Class getClassById(int class_id){
        return classDAO.getClassById(class_id);
    }
    public List<ClassModel> getClassesByMentorId(int mentor_id){
        List<ClassModel> classes = new ArrayList<>();
        List<Class> rooms = classDAO.getClassesByMentor(mentor_id);
        for (Class room: rooms
        ) {
            ClassModel classModel = getClassModelByMentorId_RoomId(mentor_id, room.id);
            classes.add(classModel);
        }
        return classes;
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
