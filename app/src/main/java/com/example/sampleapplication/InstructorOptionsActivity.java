package com.example.sampleapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class InstructorOptionsActivity extends AppCompatActivity {


    ConstraintLayout id_scanQRCode,id_showAttendence;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor_options);

        id_showAttendence = findViewById(R.id.id_showAttendence);
        id_scanQRCode = findViewById(R.id.id_scanQRCode);

        id_scanQRCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(InstructorOptionsActivity.this,QRGeneratorActivity.class);
                startActivity(intent);

            }
        });

        id_showAttendence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(InstructorOptionsActivity.this,AllStudentsAttendence.class);
                startActivity(intent);
            }
        });
    }

}
