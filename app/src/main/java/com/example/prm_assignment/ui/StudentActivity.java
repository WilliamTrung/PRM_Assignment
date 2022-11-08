package com.example.prm_assignment.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prm_assignment.R;
import com.example.prm_assignment.adapter.AttendListAdapter;
import com.example.prm_assignment.adapter.ClassAdapter;
import com.example.prm_assignment.entities.Attendance;
import com.example.prm_assignment.entities.Mentor;
import com.example.prm_assignment.entities.Student;
import com.example.prm_assignment.models.AttendanceFormModel;
import com.example.prm_assignment.models.AttendanceModel;
import com.example.prm_assignment.models.ClassModel;
import com.example.prm_assignment.repository.AttendanceRepository;
import com.example.prm_assignment.repository.ClassRepository;

import java.util.LinkedList;
import java.util.List;

public class StudentActivity extends AppCompatActivity {

    private TextView tvStudent;
    private CheckBox present;
    private CheckBox absent;
    private ClassModel classModel;
    RecyclerView rView;
    private ClassRepository classRepo;
    private AttendanceRepository repo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        initUi();

        classRepo = new ClassRepository(this.getApplication());
        repo = new AttendanceRepository(this.getApplication());

        Intent i = getIntent();
        String classIdText ="";
        int classId = 0;
        Mentor mentor = new Mentor();
        if(i != null){
            classIdText = i.getStringExtra("Class_Id");
        }else{
            Toast.makeText(StudentActivity.this, "Inner data failed!", Toast.LENGTH_SHORT);
        }
        if(TextUtils.isEmpty(classIdText)) {
            Toast.makeText(StudentActivity.this, "Inner data failed!", Toast.LENGTH_SHORT);
        }
        else {
            classId = Integer.parseInt(classIdText);
        }
        classModel = classRepo.getClassModelByMentorId_RoomId(classId);

        List<AttendanceModel> data = repo.getAttendanceModels(classModel.getRoom());

        rView = findViewById(R.id.mRecycleView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rView.setLayoutManager(linearLayoutManager);
        rView.setHasFixedSize(true);
        AttendListAdapter adapter = new AttendListAdapter();
        adapter.setData(data);
        rView.setAdapter(adapter);
    }

    public void SaveAdttend(View view) {
        int counter= 0;
        int maxCounter = rView.getChildCount();
        List<AttendanceModel> updated_Attend = new LinkedList<>();
        for(counter=0; counter<maxCounter; counter++){
            View tmp = rView.getChildAt(counter);

            String tmp1 = tmp.findViewById(R.id.id_student_name).toString().trim();
            boolean present = tmp.findViewById(R.id.Present).isActivated();
            boolean absent = tmp.findViewById(R.id.Absent).isActivated();
            String[] tmp2 = tmp1.split(",");
            int studenId = Integer.parseInt(tmp2[0]);
            String studentName = tmp2[1];

            Student student = new Student();
            student.id = studenId;
            student.name = studentName;
            AttendanceModel attendanceModel = new AttendanceModel(student, classModel.getRoom());
            if(present){
                attendanceModel.setStatus(true);
            }
            updated_Attend.add(attendanceModel);
        }
        AttendanceFormModel formModel = new AttendanceFormModel(classModel.getRoom(), updated_Attend);
        repo.submitAttendanceForm(formModel);
    }
    public void initUi(){
        tvStudent = findViewById(R.id.id_student_name);
        present = findViewById(R.id.Present);
        absent = findViewById(R.id.Absent);
    }
}