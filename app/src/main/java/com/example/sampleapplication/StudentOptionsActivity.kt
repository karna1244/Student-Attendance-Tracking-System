package com.example.sampleapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout

class StudentOptionsActivity : AppCompatActivity() {

    lateinit var id_scanQRCode: ConstraintLayout
    lateinit var id_showAttendence: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_options)

        id_showAttendence = findViewById(R.id.id_showAttendence)
        id_scanQRCode = findViewById(R.id.id_scanQRCode)

        id_scanQRCode.setOnClickListener {
            val intent = Intent(this, QRScannerActivity::class.java)
            startActivity(intent)
        }

        id_showAttendence.setOnClickListener {
            val intent = Intent(this, StudentAttendenceActivity::class.java)
            startActivity(intent)
        }

    }
}