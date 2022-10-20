package com.example.sampleapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class ResetActivity : AppCompatActivity() {
    lateinit var backButton: ImageView
    lateinit var showconfirmpassword: ImageView
    lateinit var showpassword: ImageView
    lateinit var enterNewPasswordFaculty: EditText
    lateinit var enterconfirmPasswordFaculty: EditText
    lateinit var text_facultyID: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset)
        backButton = findViewById(R.id.id_back)
        showconfirmpassword = findViewById(R.id.id_showconfirmpassword)
        showpassword = findViewById(R.id.id_showpassword)
        text_facultyID = findViewById(R.id.text_facultyID)
        enterconfirmPasswordFaculty = findViewById(R.id.id_enterConfirmPasswordFaculty)
        enterNewPasswordFaculty = findViewById(R.id.id_enterNewPasswordFaculty)


        val isFrom = intent.getStringExtra("RESET")

        if(isFrom.equals("PROFESSOR")){
            text_facultyID.setText("Faculty ID (@nwmissouri.edu)*")
        }else{
            text_facultyID.setText("Sid (@nwmissouri.edu)*")
        }


        showpassword.setOnClickListener {
            if(showpassword.getTag().equals("close")){
                showpassword.setTag("open")
                enterNewPasswordFaculty.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                showpassword.setImageDrawable(getResources().getDrawable(R.drawable.eye_open_password))

            }else{
                showpassword.setTag("close")
                enterNewPasswordFaculty.setTransformationMethod(PasswordTransformationMethod.getInstance());
                showpassword.setImageDrawable(getResources().getDrawable(R.drawable.eye_close_password))

            }
        }
        showconfirmpassword.setOnClickListener {
            if(showconfirmpassword.getTag().equals("close")){
                showconfirmpassword.setTag("open")
                enterconfirmPasswordFaculty.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                showconfirmpassword.setImageDrawable(getResources().getDrawable(R.drawable.eye_open_password))

            }else{
                showconfirmpassword.setTag("close")
                enterconfirmPasswordFaculty.setTransformationMethod(PasswordTransformationMethod.getInstance());
                showconfirmpassword.setImageDrawable(getResources().getDrawable(R.drawable.eye_close_password))

            }
        }



        backButton.setOnClickListener {
            finish()
        }
    }
}