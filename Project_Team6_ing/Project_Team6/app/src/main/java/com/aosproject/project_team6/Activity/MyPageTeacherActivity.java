package com.aosproject.project_team6.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.aosproject.project_team6.Common.ShareVar;
import com.aosproject.project_team6.NetworkTask.Workbook_NetworkTask;
import com.aosproject.project_team6.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyPageTeacherActivity extends AppCompatActivity {

    //변수
    String urlAddr = null;
    String urlAddrUpdate = null;
    String tid = "t01"; // 선생님 tid값
    String macIP, taddress;
    String msg = "Message";
    String tdeletedate = null;

    TextView tv_MyPage_teacher_name, tv_Mypage_teacher_AccountInfo, tv_Mypage_teacher_Attend,
            tv_MyPage_teacher_AddressEdit, tv_MyPage_teacher_privacy, tv_MyPage_teacher_version, tv_Mypage_teacher_Logout, tv_MyPage_teacher_DeleteMyAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page_teacher);

        macIP = ShareVar.IPAddress;
        //등록되어있는 정보 보여주기
//        urlAddr = "http://" + macIP + ":8080/test/quizbank_MyPageTeacher_AddressSelect.jsp?tid=" + tid ;
        //업데이트용 jsp
        urlAddrUpdate = "http://" + macIP + ":8080/test/quizbank_MyPageTeacher_DeleteUpdate.jsp?";

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
            Intent intent = null;
            if(which == DialogInterface.BUTTON_POSITIVE){
//                //오늘 날짜 계산
//                Date date = new Date();
//                SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd"); // mm은 minute, MM은 Month
//                tdeletedate = sdformat.format(date).toString();
//                Log.v("Date", tdeletedate);
//                Toast.makeText(MyPageTeacherActivity.this, sdformat.toString(), Toast.LENGTH_SHORT).show();

                //********여기에 DB 내용 넣어야 함 ********
                urlAddrUpdate = urlAddrUpdate + "tid=" + tid;
                String result = connectInsertData();
//                if(result.equals("1")){
//                    // 정상인 경우 ( 1만 정상이라는 것은 jsp 에서 판단 할 수 있도록 만들 예정임. )
//                    Toast.makeText(MyPageTeacherActivity.this, "탈퇴되었습니다", Toast.LENGTH_SHORT).show();
////                    intent = new Intent(MyPageTeacherActivity.this, MainActivity.class);
////                    startActivity(intent);
//                }else  {/*에러걸렸으면*/
//                    Toast.makeText(MyPageTeacherActivity.this, "탈퇴가 실패되었습니다.",  Toast.LENGTH_SHORT).show();
//                }
                intent = new Intent(MyPageTeacherActivity.this, MainActivity.class);
                startActivity(intent);
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


    private String connectInsertData(){
        String result = null;
        try{
            Workbook_NetworkTask networkTask = new Workbook_NetworkTask(MyPageTeacherActivity.this, urlAddrUpdate, "update");
            Object obj = networkTask.execute().get();
            result = (String) obj;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

}