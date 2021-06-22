package com.aosproject.project_team6.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.aosproject.project_team6.R;

public class MyPageDivisionActivity extends AppCompatActivity {

    String msg = "Message";

    TextView tv_division;
    Button btn_MyPage_Division_Edit, btn_MyPage_Division_Remove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page_division);

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
                                    tv_division.setText(editText.getText().toString());
                                    // ******** 여기에 DB 관련 작업 내용도 넣어야 함!! ******
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




}