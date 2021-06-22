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

public class MyPageTeacherActivity extends AppCompatActivity {

    String msg = "Message";

    TextView tv_MyPage_teacher_name, tv_Mypage_teacher_AccountInfo, tv_Mypage_teacher_Attend,
            tv_MyPage_teacher_AddressEdit, tv_MyPage_teacher_privacy, tv_MyPage_teacher_version, tv_Mypage_teacher_Logout, tv_MyPage_teacher_DeleteMyAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page_teacher);

        tv_MyPage_teacher_name = findViewById(R.id.tv_MyPage_teacher_name);
        tv_Mypage_teacher_AccountInfo = findViewById(R.id.tv_Mypage_teacher_AccountInfo);
        tv_Mypage_teacher_Attend = findViewById(R.id.tv_Mypage_teacher_Attend);
        tv_MyPage_teacher_AddressEdit = findViewById(R.id.tv_MyPage_teacher_AddressEdit);
        tv_MyPage_teacher_privacy = findViewById(R.id.tv_MyPage_teacher_privacy);
        tv_MyPage_teacher_version = findViewById(R.id.tv_MyPage_teacher_version);
        tv_Mypage_teacher_Logout = findViewById(R.id.tv_Mypage_teacher_Logout);
        tv_MyPage_teacher_DeleteMyAccount = findViewById(R.id.tv_MyPage_teacher_DeleteMyAccount);



        tv_MyPage_teacher_AddressEdit.setOnClickListener(mOnClickListener);
        tv_MyPage_teacher_privacy.setOnClickListener(mOnClickListener);
        tv_MyPage_teacher_version.setOnClickListener(mOnClickListener);
        tv_Mypage_teacher_Logout.setOnClickListener(mOnClickListener);
        tv_MyPage_teacher_DeleteMyAccount.setOnClickListener(mOnClickListener);


    }//onCreate

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = null;

            switch (v.getId()){
                case R.id.tv_MyPage_teacher_AddressEdit:
                    intent = new Intent(MyPageTeacherActivity.this, MyPageAddressActivity.class);
                    startActivity(intent);
                    break;
                case R.id.tv_MyPage_teacher_privacy:
                    break;
                case R.id.tv_MyPage_teacher_version:
                    break;
                case R.id.tv_Mypage_teacher_Logout:
                    new AlertDialog.Builder(MyPageTeacherActivity.this)
                            .setTitle("확인") // title
                            .setMessage("로그아웃 하시겠습니까?") // content
                            .setIcon(R.mipmap.ic_launcher) // icon
                            .setCancelable(false) // 버튼을 눌러야만 창이 닫아짐
                            .setPositiveButton("로그아웃",mLogout)
                            .setNegativeButton("취소",mLogout)
                            .show();
                    break;
                case R.id.tv_MyPage_teacher_DeleteMyAccount:
                    new AlertDialog.Builder(MyPageTeacherActivity.this)
                            .setTitle("확인") // title
                            .setMessage("탈퇴 하시겠습니까?") // content
                            .setIcon(R.mipmap.ic_launcher) // icon
                            .setCancelable(false) // 버튼을 눌러야만 창이 닫아짐
                            .setPositiveButton("탈퇴",mDeleteAccount)
                            .setNegativeButton("취소",mDeleteAccount)
                            .show();
                    break;
                default:
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



}