package com.example.sampleapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.firebase.auth.FirebaseAuth

class StudentEnrolledCoursesActivity : AppCompatActivity() {

    lateinit var javaSelected:TextView
    lateinit var logout:ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_enrolled_courses)

        javaSelected=findViewById(R.id.javaSelected);
        logout=findViewById(R.id.logout);

        javaSelected.setOnClickListener {
            val intent = Intent(this, StudentOptionsActivity::class.java)
            startActivity(intent)
        }

        logout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, StudentLogin::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
       // super.onBackPressed()
    }
}