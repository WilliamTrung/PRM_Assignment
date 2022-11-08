package com.example.prm_assignment.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prm_assignment.R;
import com.example.prm_assignment.entities.Mentor;
import com.example.prm_assignment.models.MentorModel;
import com.example.prm_assignment.repository.MentorRepository;

public class LoginActivity extends AppCompatActivity {
    private EditText txtUserName;
    private EditText txtPassword;
    private Button btnLogin;
    private MentorRepository repo;
    private MentorModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initUi();

        repo = new MentorRepository(this.getApplication());

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(userLogin()){
                    Toast.makeText(LoginActivity.this, "Login Success!", Toast.LENGTH_SHORT);
                    Intent i = new Intent(LoginActivity.this, ViewClassListActivity.class);

                    i.putExtra("User_Name", model.getMentor().name);
                    i.putExtra("User_Password", model.getMentor().password);

                    startActivity(i);
                }
                else{
                    Toast.makeText(LoginActivity.this, "Wrong username or password!", Toast.LENGTH_SHORT);
                }

            }
        });
    }

    private boolean userLogin() {
        String userName = txtUserName.getText().toString().trim();
        String password = txtPassword.getText().toString().trim();
        if(TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)) return false;
        Mentor mentor = new Mentor();
        mentor.name = userName;
        mentor.password = password;
        model = repo.getMentorModel(mentor);
        if(model != null){
            return true;
        }
        return false;
    }

    private void initUi(){
        txtPassword = findViewById(R.id.password);
        txtUserName = findViewById(R.id.username);
        btnLogin = findViewById(R.id.loginbutton);
    }
}