package com.example.prm_assignment.repository;

import android.app.Application;
import android.os.AsyncTask;

import com.example.prm_assignment.dao.AttendanceDAO;
import com.example.prm_assignment.dao.ClassDAO;
import com.example.prm_assignment.dao.MentorDAO;
import com.example.prm_assignment.entities.Attendance;
import com.example.prm_assignment.entities.Class;
import com.example.prm_assignment.entities.Student;
import com.example.prm_assignment.models.AttendanceFormModel;
import com.example.prm_assignment.models.AttendanceModel;
import com.example.prm_assignment.room.CheckAttendanceDatabase;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AttendanceRepository {
    private AttendanceDAO attendanceDAO;
    private StudentRepository studentRepository;
    private Date date;
    public AttendanceRepository(Application application){
        CheckAttendanceDatabase db =  CheckAttendanceDatabase.getDatabase(application);
        studentRepository = new StudentRepository(application);
        attendanceDAO = db.attendanceDAO();
    }
    private void setToday(){
        long millis = System.currentTimeMillis();
        date = new java.sql.Date(millis);
    }
    public AttendanceFormModel getAttendanceForm(Class room){
        AttendanceFormModel formModel = new AttendanceFormModel(room, getAttendanceModels(room));
        return  formModel;
    }
    private List<AttendanceModel> getAttendanceModels(Class room){
        List<Student> students = studentRepository.getStudentsByClassId(room.id);
        List<AttendanceModel> attendanceModels = new ArrayList<>();
        setToday();
        for (Student student: students
             ) {
            AttendanceModel attendanceModel = new AttendanceModel(student, room);
            attendanceModel.setDate(date);
            attendanceModels.add(attendanceModel);
        }
        return attendanceModels;
    }
    public boolean submitAttendanceForm(AttendanceFormModel formModel){
        boolean result = true;
        setToday();
        boolean check = attendanceDAO.checkAttendance(formModel.getRoom().id, date) != null;
        try {
            if (!check) {
                //insert
                for (AttendanceModel attendanceModel : formModel.getAttendances()
                ) {
                    Attendance attendance = attendanceModel.toAttendance();
                    attendance.date = date;
                    new insertAsync(attendanceDAO).execute(attendance);
                }
            } else {
                //update
                for (AttendanceModel attendanceModel : formModel.getAttendances()
                ) {
                    Attendance attendance = attendanceModel.toAttendance();
                    new updateAsync(attendanceDAO).execute(attendance);
                }
            }
        } catch (Exception e){
            result = false;
        }
        return result;
    }

    private static class insertAsync extends AsyncTask<Attendance, Void, Void> {

        private AttendanceDAO attendanceDAO;

        insertAsync(AttendanceDAO dao) {
            attendanceDAO = dao;
        }

        @Override
        protected Void doInBackground(final Attendance... params) {
            attendanceDAO.insertAttendance(params[0]);
            return null;
        }
    }
    private static class updateAsync extends AsyncTask<Attendance, Void, Void> {

        private AttendanceDAO attendanceDAO;

        updateAsync(AttendanceDAO dao) {
            attendanceDAO = dao;
        }

        @Override
        protected Void doInBackground(final Attendance... params) {
            attendanceDAO.updateAttendance(params[0]);
            return null;
        }
    }
}
