package com.example.prm_assignment.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.prm_assignment.dao.ClassDAO;
import com.example.prm_assignment.dao.MentorDAO;
import com.example.prm_assignment.dao.StudentDAO;
import com.example.prm_assignment.entities.Class;
import com.example.prm_assignment.entities.Mentor;
import com.example.prm_assignment.entities.Student;
import com.example.prm_assignment.models.ClassModel;
import com.example.prm_assignment.models.MentorModel;
import com.example.prm_assignment.room.CheckAttendanceDatabase;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

public class MentorRepository {
    private MentorDAO mentorDAO;
    private ClassRepository classRepository;

    public MentorRepository(Application application){
        CheckAttendanceDatabase db =  CheckAttendanceDatabase.getDatabase(application);
        mentorDAO = db.mentorDAO();
        classRepository = new ClassRepository(application);
    }
    public MentorModel getMentorModel(Mentor mentor){
        Mentor login = mentorDAO.login(mentor.id, mentor.password);
        MentorModel result = null;
        if(login != null){
            List<ClassModel> classes = classRepository.getClassesByMentorId(login.id);
            result = new MentorModel(login, classes);
        }
        return null;
    }
    public void insert(Mentor mentor){
        new MentorRepository.insertAsync(mentorDAO).execute(mentor);
    }
    public void update(Mentor mentor){
        new MentorRepository.updateAsync(mentorDAO).execute(mentor);
    }
    private static class insertAsync extends AsyncTask<Mentor, Void, Void> {

        private MentorDAO mentorDAO;

        insertAsync(MentorDAO dao) {
            mentorDAO = dao;
        }

        @Override
        protected Void doInBackground(final Mentor... params) {
            mentorDAO.insertMentor(params[0]);
            return null;
        }
    }
    private static class updateAsync extends AsyncTask<Mentor, Void, Void> {

        private MentorDAO mentorDAO;

        updateAsync(MentorDAO dao) {
            mentorDAO = dao;
        }

        @Override
        protected Void doInBackground(final Mentor... params) {
            mentorDAO.updateMentor(params[0]);
            return null;
        }
    }
}
