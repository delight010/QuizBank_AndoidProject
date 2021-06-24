package com.aosproject.project_team6.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.aosproject.project_team6.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button btn_teacher, btn_student, btn_mypage_teacher, btn_mypage_student, btn_auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_teacher = findViewById(R.id.btn_teacher_start);
        btn_mypage_teacher = findViewById(R.id.btn_mypage_teacher);
        btn_mypage_student = findViewById(R.id.btn_mypage_student);
        btn_auth = findViewById(R.id.btn_auth);

        btn_teacher.setOnClickListener(onClickListener);
        btn_mypage_teacher.setOnClickListener(onClickListener);
        btn_mypage_student.setOnClickListener(onClickListener);
        btn_auth.setOnClickListener(onClickListener);



    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent;
            switch (v.getId()){
                case R.id.btn_teacher_start:
                    intent = new Intent(MainActivity.this, TeacherListActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_student_start:
                    intent = new Intent(MainActivity.this, StudentListActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_mypage_teacher:
                    //오늘 날짜 계산
                    Date date = new Date();
                    SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-mm-dd");
                    String strDate = sdformat.format(date);
                    Log.v("Date", strDate);
                    Toast.makeText(MainActivity.this, strDate, Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, MyPageTeacherActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_mypage_student:
                    intent = new Intent(MainActivity.this, MyPageStudentActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_auth:
                    intent = new Intent(MainActivity.this, AuthActivity.class);
                    startActivity(intent);
                    break;

            }
        }
    };


}