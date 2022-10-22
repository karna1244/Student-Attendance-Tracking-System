package com.example.sampleapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sampleapplication.student.StudentCourseAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

}

public class StudentEnrolledCoursesActivity extends AppCompatActivity {

    ImageView logout;
    RecyclerView student_recylerlview;
    private DatabaseReference mDatabase;
    StudentCourseAdapter studentCourseAdapter;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_enrolled_courses);
        logout = findViewById(R.id.id_logout);
        student_recylerlview = findViewById(R.id.student_recylerlview);
        student_recylerlview.setLayoutManager(new LinearLayoutManager(this));
    } 


    
