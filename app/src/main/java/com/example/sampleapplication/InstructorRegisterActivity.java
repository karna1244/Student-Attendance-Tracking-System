package com.example.sampleapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class InstructorRegisterActivity extends AppCompatActivity {


    TextView spinner_btn, text_studentid;
    ImageView back;
    EditText enterFirstName, enterLastName, enterStudentID, enterPassword, enterConfirmPassword;
    ConstraintLayout register;
    FirebaseAuth auth;
    ProgressDialog progressDialog;
    MaterialCheckBox javaCourse, pmCourse, gdpCourse, bigdataCourse;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor_registration);

        text_studentid = findViewById(R.id.text_studentid);
        back = findViewById(R.id.id_back);
        register = findViewById(R.id.id_login);
        enterFirstName = findViewById(R.id.id_enterFirstName);
        enterLastName = findViewById(R.id.id_enterLastName);
        enterStudentID = findViewById(R.id.id_enterStudentID);
        enterPassword = findViewById(R.id.id_enterPassword);
        enterConfirmPassword = findViewById(R.id.id_enterconfirmPassword);
        javaCourse = findViewById(R.id.javaCourse);
        pmCourse = findViewById(R.id.pmCourse);
        gdpCourse = findViewById(R.id.gdpCourse);
        bigdataCourse = findViewById(R.id.bigdataCourse);

        auth = FirebaseAuth.getInstance();


        