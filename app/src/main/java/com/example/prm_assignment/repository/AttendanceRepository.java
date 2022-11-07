package com.example.prm_assignment.repository;

import android.app.Application;
import android.os.AsyncTask;

import com.example.prm_assignment.dao.AttendanceDAO;
import com.example.prm_assignment.dao.ClassDAO;
import com.example.prm_assignment.dao.MentorDAO;
import com.example.prm_assignment.entities.Attendance;
import com.example.prm_assignment.entities.Class;
import com.example.prm_assignment.entities.Mentor;
import com.example.prm_assignment.entities.Student;
import com.example.prm_assignment.models.AttendanceFormModel;
import com.example.prm_assignment.models.AttendanceModel;
import com.example.prm_assignment.room.CheckAttendanceDatabase;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AttendanceRepository {
    private AttendanceDAO attendanceDAO;
    private ClassRepository classRepository;
    private StudentRepository studentRepository;
    private Date date;
    public AttendanceRepository(Application application){
        CheckAttendanceDatabase db =  CheckAttendanceDatabase.getDatabase(application);
        classRepository = new ClassRepository(application);
        studentRepository = new StudentRepository(application);
        attendanceDAO = db.attendanceDAO();
    }
    public AttendanceFormModel getAttendanceForm(Class room){

    }
    public List<AttendanceModel> getAttendanceModels(Class room){
        List<Student> students = studentRepository.getStudentsByClassId(room.id);
        List<AttendanceModel> attendanceModels = new ArrayList<>();
        for (Student student: students
             ) {
            AttendanceModel attendanceModel = new AttendanceModel(student, room);
            attendanceModels.add(attendanceModel);
        }
        return attendanceModels;
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
