package com.example.prm_assignment.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.prm_assignment.dao.AttendanceDAO;
import com.example.prm_assignment.dao.MentorDAO;
import com.example.prm_assignment.entities.Class;
import com.example.prm_assignment.entities.Mentor;
import com.example.prm_assignment.models.ClassAttendance;
import com.example.prm_assignment.models.MentorClasses;
import com.example.prm_assignment.room.CheckAttendanceDatabase;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

public class AttendanceRepository {
    private AttendanceDAO attendanceDAO;
    private Date date;
    public AttendanceRepository(Application application){
        CheckAttendanceDatabase db =  CheckAttendanceDatabase.getDatabase(application);
        attendanceDAO = db.attendanceDAO();
    }
    public void submitClassAttendance(Class classStudying){
        date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        //check if exists
        //if exists -> update
        //if non -> insert
    }
    public ClassAttendance getClassAttendance(int class_id){
        
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
