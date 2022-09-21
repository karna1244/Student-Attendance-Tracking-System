package com.example.sampleapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class StudentOptionsActivity extends AppCompatActivity {

    ConstraintLayout id_scanQRCode,id_showAttendence;
    TextView id_selectedCourse;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_options);


        id_showAttendence = findViewById(R.id.id_showAttendence);
        id_selectedCourse = findViewById(R.id.id_selectedCourse);
        id_scanQRCode = findViewById(R.id.id_scanQRCode);

        try {
            String course=getIntent().getStringExtra("CourseType");
            id_selectedCourse.setText(course);
        }catch (Exception e){
            e.printStackTrace();
        }

        id_scanQRCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(StudentOptionsActivity.this, QRScannerActivity.class);
                startActivity(intent);
            }
        });

        id_showAttendence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(StudentOptionsActivity.this, StudentAttendenceActivity.class);
                startActivity(intent);
            }
        });


    }
}
