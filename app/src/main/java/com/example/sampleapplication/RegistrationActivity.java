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
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RegistrationActivity extends AppCompatActivity {


    TextView spinner_btn, text_studentid;
    ImageView back;
    EditText enterFirstName, enterLastName, enterStudentID, enterPassword, enterConfirmPassword;
    ConstraintLayout register;
    FirebaseAuth auth;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        text_studentid = findViewById(R.id.text_studentid);
        back = findViewById(R.id.id_back);
        register = findViewById(R.id.id_login);
        enterFirstName = findViewById(R.id.id_enterFirstName);
        enterLastName = findViewById(R.id.id_enterLastName);
        enterStudentID = findViewById(R.id.id_enterStudentID);
        enterPassword = findViewById(R.id.id_enterPassword);
        enterConfirmPassword = findViewById(R.id.id_enterconfirmPassword);

        spinner_btn = findViewById(R.id.spinner_btn);
        spinner_btn.setText("Select");


        spinner_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList list = new ArrayList<String>();
                list.add("Java (13800)");
                list.add("project Management (13898)");
                list.add("GDP-1 (13800)");
                list.add("BigData (13900)");

                getCourseList(spinner_btn, list);
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    progressDialog=new ProgressDialog(RegistrationActivity.this);
                    progressDialog.setMessage("Loading....");
                    String fname = enterFirstName.getText().toString();
                    String lname = enterLastName.getText().toString();
                    String sID = enterStudentID.getText().toString();
                    String pass = enterPassword.getText().toString();
                    String confirmpass = enterConfirmPassword.getText().toString();
                    String course="";
                    try {
                        course = spinner_btn.getText().toString();
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    String tsask=course;
                    if (TextUtils.isEmpty(fname)) {
                        Toast.makeText(RegistrationActivity.this, "Enter FirstName", Toast.LENGTH_LONG).show();
                    } else if (TextUtils.isEmpty(lname)) {
                        Toast.makeText(RegistrationActivity.this, "Enter LastName", Toast.LENGTH_LONG).show();
                    } else if (TextUtils.isEmpty(sID)) {
                        Toast.makeText(RegistrationActivity.this, "Enter id", Toast.LENGTH_LONG).show();
                    } else if (TextUtils.isEmpty(pass)) {
                        Toast.makeText(RegistrationActivity.this, "Enter password", Toast.LENGTH_LONG).show();
                    } else if (TextUtils.isEmpty(confirmpass)) {
                        Toast.makeText(RegistrationActivity.this, "Enter confirm password", Toast.LENGTH_LONG).show();
                    } else if (!(pass.equals(confirmpass))) {
                        Toast.makeText(RegistrationActivity.this, "password mismtach", Toast.LENGTH_LONG).show();
                    } else if (TextUtils.isEmpty(course)) {
                        Toast.makeText(RegistrationActivity.this, "select course ", Toast.LENGTH_LONG).show();
                    } else {

                        auth = FirebaseAuth.getInstance();
                        progressDialog.show();
                        auth.createUserWithEmailAndPassword(sID,pass)
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        progressDialog.cancel();
                                        if (task.isSuccessful()){
                                            Toast.makeText(RegistrationActivity.this,"Registration Successfull",Toast.LENGTH_LONG).show();

                                            try {
                                                FirebaseDatabase database = FirebaseDatabase.getInstance();
                                                DatabaseReference myRef = database.getReference("UserDetails").child("Student");
                                                String key = myRef.push().getKey();

                                                RegistrationModel registrationModel = new RegistrationModel(fname, lname, sID, pass,tsask);
                                                myRef.child(key).setValue(registrationModel);

                                            } catch (Exception e) {

                                            }

                                                              Intent intent = new Intent(RegistrationActivity.this, StudentLogin.class);
                                                            startActivity(intent);
                                                          finish();
                                        }else{
                                            Toast.makeText(RegistrationActivity.this,"Registration UnSuccessfull",Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });


                    /*    auth.createUserWithEmailAndPassword(sID, confirmpass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                                Toast.makeText(RegistrationActivity.this,"Registration Successfull",Toast.LENGTH_LONG).show();

                                    try {
                                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                                        DatabaseReference myRef = database.getReference("UserDetails").child("Student");
                                        String key = myRef.push().getKey();

                                        RegistrationModel registrationModel = new RegistrationModel(fname, lname, sID, pass);
                                        myRef.child(key).setValue(registrationModel);

                                    } catch (Exception e) {

                                    }

                  //                  Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                    //                startActivity(intent);
                      //              finish();

                                } else {
                                    Toast.makeText(RegistrationActivity.this, "Registration UnSuccessfull", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                    */}

                }catch (Exception exception){
                    Toast.makeText(RegistrationActivity.this,"Try again after sometime",Toast.LENGTH_LONG).show();
                }



            }
        });

    }

    private void getCourseList(TextView view1, ArrayList list) {
        final TextView b1 = (TextView) view1;
        androidx.appcompat.widget.PopupMenu menu = new PopupMenu(this, view1);
        if (list != null) {
            for (int y = 0; y < list.size(); y++) {
                menu.getMenu().add(list.get(y).toString());
            }
        }
        menu.show();
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                b1.setText(item.getTitle());
                return false;
            }
        });
    }
}
