package com.example.prm_assignment.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.prm_assignment.dao.MentorDAO;
import com.example.prm_assignment.dao.StudentDAO;
import com.example.prm_assignment.entities.Mentor;
import com.example.prm_assignment.entities.Student;
import com.example.prm_assignment.models.MentorClasses;
import com.example.prm_assignment.room.CheckAttendanceDatabase;

import java.util.List;

public class MentorRepository {
    private MentorDAO mentorDAO;
    private LiveData<List<MentorClasses>> mentorClasses;
    private LiveData<List<Mentor>> mentors;

    public MentorRepository(Application application){
        CheckAttendanceDatabase db =  CheckAttendanceDatabase.getDatabase(application);
        mentorDAO = db.mentorDAO();
        mentors = mentorDAO.getAllMentor();
    }

    public LiveData<MentorClasses> login(String name, String password){
        return mentorDAO.login(name, password);
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
