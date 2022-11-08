package com.example.prm_assignment.room;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.prm_assignment.dao.AttendanceDAO;
import com.example.prm_assignment.dao.ClassDAO;
import com.example.prm_assignment.dao.MentorDAO;
import com.example.prm_assignment.dao.StudentDAO;
import com.example.prm_assignment.dao.StudyingDAO;
import com.example.prm_assignment.entities.Attendance;
import com.example.prm_assignment.entities.Mentor;
import com.example.prm_assignment.entities.Student;
import com.example.prm_assignment.entities.Studying;

public abstract class CheckAttendanceDatabase extends RoomDatabase {

    public abstract MentorDAO mentorDAO();
    public abstract StudentDAO studentDAO();
    public abstract ClassDAO classDAO();
    public abstract StudyingDAO studyingDAO();
    public abstract AttendanceDAO attendanceDAO();

    private static CheckAttendanceDatabase INSTANCE;

    public static CheckAttendanceDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CheckAttendanceDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), CheckAttendanceDatabase.class, "check_attendance_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return  INSTANCE;
    }
}
