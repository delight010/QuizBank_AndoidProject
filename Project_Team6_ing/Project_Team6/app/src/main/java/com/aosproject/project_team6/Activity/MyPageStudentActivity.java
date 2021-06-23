package com.aosproject.project_team6.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.aosproject.project_team6.R;

public class MyPageStudentActivity extends AppCompatActivity {

    TextView tv_MyPage_student_name, tv_MyPage_student_DivisionEdit, tv_MyPage_student_privacy, tv_MyPage_student_version,
            tv_Mypage_student_Logout, tv_MyPage_student_DeleteMyAccount;

    String sid = "s01";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page_student);

        tv_MyPage_student_name = findViewById(R.id.tv_MyPage_student_name);
        tv_MyPage_student_DivisionEdit = findViewById(R.id.tv_MyPage_student_DivisionEdit);
        tv_MyPage_student_privacy = findViewById(R.id.tv_MyPage_student_privacy);
        tv_Mypage_student_Logout = findViewById(R.id.tv_Mypage_student_Logout);
        tv_MyPage_student_DeleteMyAccount = findViewById(R.id.tv_MyPage_student_DeleteMyAccount);

        tv_MyPage_student_DivisionEdit.setOnClickListener(mOnClickListener);
        tv_MyPage_student_privacy.setOnClickListener(mOnClickListener);
        tv_Mypage_student_Logout.setOnClickListener(mOnClickListener);
        tv_MyPage_student_DeleteMyAccount.setOnClickListener(mOnClickListener);

    }//onCreate


    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.tv_MyPage_student_DivisionEdit:
                    intent = new Intent(MyPageStudentActivity.this, MyPageDivisionActivity.class);
                    intent.putExtra("sid", sid);
                    startActivity(intent);

                    break;
                case R.id.tv_MyPage_student_privacy:
                    break;
                case R.id.tv_Mypage_student_Logout:
                    new AlertDialog.Builder(MyPageStudentActivity.this)
                            .setTitle("확인") // title
                            .setMessage("로그아웃 하시겠습니까?") // content
                            .setIcon(R.mipmap.ic_launcher) // icon
                            .setCancelable(false) // 버튼을 눌러야만 창이 닫아짐
                            .setPositiveButton("로그아웃",mLogout)
                            .setNegativeButton("취소",mLogout)
                            .show();
                    break;
                case R.id.tv_MyPage_student_DeleteMyAccount:
                    new AlertDialog.Builder(MyPageStudentActivity.this)
                            .setTitle("확인") // title
                            .setMessage("탈퇴 하시겠습니까?") // content
                            .setIcon(R.mipmap.ic_launcher) // icon
                            .setCancelable(false) // 버튼을 눌러야만 창이 닫아짐
                            .setPositiveButton("탈퇴",mDeleteAccount)
                            .setNegativeButton("취소",mDeleteAccount)
                            .show();
                    break;
            }
        }
    };


    //Dialog Logout
    DialogInterface.OnClickListener mLogout = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if(which == DialogInterface.BUTTON_POSITIVE){

            }else{

            };

        }
    };

    //Dialog DeleteAccount
    DialogInterface.OnClickListener mDeleteAccount = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if(which == DialogInterface.BUTTON_POSITIVE){

            }else{

            };

        }
    };


    //    private void connectGetdata() {
//        try {
//
//            Workbook_NetworkTask networkTask = new Workbook_NetworkTask(MyPageDivisionActivity.this, urlAddr, "select");
//            Object obj = networkTask.execute().get();
//            members = (ArrayList<StudentMyPage>) obj;
//
//            adapter = new StudentAdapter(MyPageDivisionActivity.this, R.layout.activity_my_page_division, members);
//            listView.setAdapter(adapter);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }



}