package com.example.prm_assignment.Room;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.prm_assignment.DAO.AttendanceDAO;
import com.example.prm_assignment.DAO.ClassDAO;
import com.example.prm_assignment.DAO.MentorDAO;
import com.example.prm_assignment.DAO.StudentDAO;
import com.example.prm_assignment.DAO.StudyingDAO;
import com.example.prm_assignment.Model.Attendance;
import com.example.prm_assignment.Model.Mentor;
import com.example.prm_assignment.Model.Student;
import com.example.prm_assignment.Model.Studying;

@android.arch.persistence.room.Database(
        entities = {
                Mentor.class,
                Student.class,
                Class.class,
                Studying.class,
                Attendance.class
        },
        version = 1
)
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
