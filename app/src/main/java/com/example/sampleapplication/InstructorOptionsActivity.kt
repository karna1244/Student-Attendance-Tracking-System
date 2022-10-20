package com.example.sampleapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout

class InstructorOptionsActivity : AppCompatActivity() {

    lateinit var id_scanQRCode: ConstraintLayout
    lateinit var id_showAttendence: ConstraintLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instructor_options)


        id_showAttendence = findViewById(R.id.id_showAttendence)
        id_scanQRCode = findViewById(R.id.id_scanQRCode)

        id_scanQRCode.setOnClickListener {
            val intent = Intent(this, QRGeneratorActivity::class.java)
            startActivity(intent)
        }

        id_showAttendence.setOnClickListener {
            val intent = Intent(this, AllStudentsAttendence::class.java)
            startActivity(intent)
        }

    }
}