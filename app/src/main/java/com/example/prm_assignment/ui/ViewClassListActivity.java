package com.example.prm_assignment.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prm_assignment.R;
import com.example.prm_assignment.adapter.ClassAdapter;
import com.example.prm_assignment.entities.Mentor;
import com.example.prm_assignment.models.ClassModel;
import com.example.prm_assignment.models.MentorModel;
import com.example.prm_assignment.repository.ClassRepository;
import com.example.prm_assignment.repository.MentorRepository;

import java.util.List;

public class ViewClassListActivity extends AppCompatActivity {

    private TextView tvMentor;
    private TextView tvClass;

    private RecyclerView recyclerView;
    private ClassModel model;
    private ClassRepository repo;
    private MentorRepository mentorRepo;
    private MentorModel mentorModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_class_list);
        initUi();

        mentorRepo = new MentorRepository(this.getApplication());
        repo = new ClassRepository(this.getApplication());

        Intent i = getIntent();
        String userName ="";
        String password ="";
        Mentor mentor = new Mentor();
        if(i != null){
            userName = i.getStringExtra("User_Name");
            password = i.getStringExtra("User_Password");
        }else{
            Toast.makeText(ViewClassListActivity.this, "Inner data failed!", Toast.LENGTH_SHORT);
        }
        if(TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)) {
            Toast.makeText(ViewClassListActivity.this, "Inner data failed!", Toast.LENGTH_SHORT);
        }
        else {
            mentor.name = userName;
            mentor.password = password;
        }
        mentorModel = mentorRepo.getMentorModel(mentor);
        if(model == null) Toast.makeText(ViewClassListActivity.this, "Inner data failed!", Toast.LENGTH_SHORT);

        List<ClassModel> data = repo.getClassesByMentorId(mentorModel.getMentor().id);
        recyclerView = findViewById(R.id.mRecycleViewforClass);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        ClassAdapter adapter = new ClassAdapter();
        adapter.setData(data);
        recyclerView.setAdapter(adapter);
    }
    public void OnClick(View view){
        Intent i = new Intent(ViewClassListActivity.this, StudentActivity.class);
        String selectedClass = tvClass.toString();
        i.putExtra("Class_Id", selectedClass);
        startActivity(i);
    }
    public void initUi(){
        tvClass = findViewById(R.id.id_class_code);
        tvMentor = findViewById(R.id.id_mentor_name);
    }
}