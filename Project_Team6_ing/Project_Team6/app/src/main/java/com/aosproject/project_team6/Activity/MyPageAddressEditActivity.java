package com.aosproject.project_team6.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import com.aosproject.project_team6.Common.ShareVar;
import com.aosproject.project_team6.R;

public class MyPageAddressEditActivity extends AppCompatActivity {

    private static final int SEARCH_ADDRESS_ACTIVITY = 10000;

    WebView webView;
    EditText et_mypage_addressEdit1, et_mypage_addressEdit2;
    Button btn_Mypage_AddressEdit_OK, btn_Mypage_AddressEdit_Cancel;
    String macIP = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page_address_edit);

        macIP = ShareVar.IPAddress;

        et_mypage_addressEdit1 = findViewById(R.id.et_mypage_addressEdit1);
        et_mypage_addressEdit2 = findViewById(R.id.et_mypage_addressEdit2);
        btn_Mypage_AddressEdit_OK = findViewById(R.id.btn_Mypage_AddressEdit_OK);
        btn_Mypage_AddressEdit_Cancel = findViewById(R.id.btn_Mypage_AddressEdit_Cancel);

        et_mypage_addressEdit1.setOnClickListener(onClickListener);
        btn_Mypage_AddressEdit_OK.setOnClickListener(onClickListener);

    }//onCreate

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.et_mypage_addressEdit1:
                    intent = new Intent(MyPageAddressEditActivity.this, MyPageAddressWebViewActivity.class);
                    startActivityForResult(intent, SEARCH_ADDRESS_ACTIVITY);
                    startActivity(intent);
                case R.id.btn_Mypage_AddressEdit_OK:
//                    intent = new Intent(MyPageAddressEditActivity.this, MyPageAddressActivity.class);
//                    String address = et_mypage_addressEdit1.getText().toString() + et_mypage_addressEdit2.getText().toString();
//                    //*************  DB  작업 ***************
//
//                    startActivity(intent);


            }

        }
    };

    public void onActivityResult(int requestCode, int resultCode, Intent intent)
    {
        super.onActivityResult(requestCode, resultCode, intent);
        switch (requestCode) {
            case SEARCH_ADDRESS_ACTIVITY:
                if (resultCode == RESULT_OK) {
                    String data = intent.getExtras().getString("data");
                    if (data != null) {
                        et_mypage_addressEdit1.setText(data);
                    }
                }
                break;
        }
    }


}