package com.example.sampleapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.firebase.auth.FirebaseAuth

class InstructorEnrolledActivity : AppCompatActivity() {

    lateinit var javaSelected: TextView
    lateinit var logout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instructor_enrolled)

        javaSelected=findViewById(R.id.javaSelected);
        logout=findViewById(R.id.logout);

        javaSelected.setOnClickListener {
            val intent = Intent(this, InstructorOptionsActivity::class.java)
            startActivity(intent)
        }

        logout.setOnClickListener {
            FirebaseAuth.getInstance().signOut();
            val intent = Intent(this, ProfessorLogin::class.java)
            startActivity(intent)
            finish()
        }

    }


    override fun onBackPressed() {
        // super.onBackPressed()
    }
}