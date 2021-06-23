package com.aosproject.project_team6.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.aosproject.project_team6.Adapter.StudentMyPageAdapter;
import com.aosproject.project_team6.Bean.StudentMyPage;
import com.aosproject.project_team6.Common.ShareVar;
import com.aosproject.project_team6.NetworkTask.Workbook_NetworkTask;
import com.aosproject.project_team6.R;

import java.util.ArrayList;

public class MyPageDivisionActivity extends AppCompatActivity {

    //변수
    String urlAddr = null;
    String macIP, sid, sdivision;
    String msg = "Message";
    ArrayList<StudentMyPage> members;
    StudentMyPageAdapter adapter;

    TextView tv_division;
    Button btn_MyPage_Division_Edit, btn_MyPage_Division_Remove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page_division);

        Intent intent = getIntent();
        sid = "s01";
        macIP = ShareVar.IPAddress;
        urlAddr = "http://" + macIP + ":8080/test/quizbank_MyPageStudent_DivisionSelect.jsp?sid=" + sid ;



        btn_MyPage_Division_Edit = findViewById(R.id.btn_MyPage_Division_Edit);
        btn_MyPage_Division_Remove = findViewById(R.id.btn_MyPage_Division_Remove);
        tv_division = findViewById(R.id.tv_MyPage_Division);

        btn_MyPage_Division_Edit.setOnClickListener(mOnClickListener);
        btn_MyPage_Division_Remove.setOnClickListener(mOnClickListener);


    }//onCreate

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_MyPage_Division_Edit:
                    Log.v(msg, "소속 등록/변경 버튼 Click");
                    EditText editText = new EditText(MyPageDivisionActivity.this);

                    AlertDialog.Builder dlg = new AlertDialog.Builder(MyPageDivisionActivity.this)
                            .setTitle("소속 입력")
                            .setView(editText)
                            .setIcon(R.mipmap.ic_launcher_round)
                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    sdivision = editText.getText().toString();
                                    tv_division.setText(sdivision);
                                    // ******** 여기에 DB 관련 작업 내용도 넣어야 함!! ******
                                    urlAddr = urlAddr + "sdivision=" + sdivision + "&sid=" + sid;
                                    String result = connectInsertData();
                                    if(result.equals("1")){
                                        // 정상인 경우 ( 1만 정상이라는 것은 jsp 에서 판단 할 수 있도록 만들 예정임. )
                                        Toast.makeText(MyPageDivisionActivity.this, "소속이 입력되었습니다", Toast.LENGTH_SHORT).show();
                                    }else  {/*에러걸렸으면*/
                                        Toast.makeText(MyPageDivisionActivity.this, "소속 입력이 실패되었습니다.",  Toast.LENGTH_SHORT).show();
                                    }
                                }
                            })
                            .setNegativeButton("취소", mDivisionCancel);
                            dlg.show();
                    break;
                case R.id.btn_MyPage_Division_Remove:
                    AlertDialog.Builder dlg2 = new AlertDialog.Builder(MyPageDivisionActivity.this);
                            dlg2.setTitle("소속 삭제 확인")
                            .setIcon(R.mipmap.ic_launcher_round)
                            .setPositiveButton("삭제", mDivisionRemove)
                            .setNegativeButton("취소", mDivisionRemove)
                            .show();
                    break;
            }
        }
    };

    //Dialog Division Edit
    DialogInterface.OnClickListener mDivisionCancel = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if(which == DialogInterface.BUTTON_NEGATIVE){

            }else{

            };

        }
    };

    //Dialog Division Edit
    DialogInterface.OnClickListener mDivisionRemove = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if(which == DialogInterface.BUTTON_POSITIVE){
                tv_division.setText("");
                //********여기에 DB 내용 넣어야 함 ********
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
            Workbook_NetworkTask networkTask = new Workbook_NetworkTask(MyPageDivisionActivity.this, urlAddr, "update");
            Object obj = networkTask.execute().get();
            result = (String) obj;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }



}