package com.aosproject.project_team6.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.aosproject.project_team6.R;

import net.daum.mf.map.api.MapView;

public class MyPageAddressActivity extends AppCompatActivity {

    Button btn_edit, btn_remove;
    LinearLayout linearLayout_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page_address);

        btn_edit = findViewById(R.id.btn_MyPage_AddressAPI_Edit);
//        btn_remove = findViewById(R.id.btn_MyPage_Remove);
//        linearLayout_address = findViewById(R.id.linearLayout_MyPage_AddressAPI);


        btn_edit.setOnClickListener(onClickListener);
//        linearLayout_address.setOnClickListener(onClickListener);

//        MapView mapView = new MapView(this);
//        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
//        mapViewContainer.addView(mapView);




    }//onCreate

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_MyPage_AddressAPI_Edit:
                    intent = new Intent(MyPageAddressActivity.this, MyPageAddressEditActivity.class);
                    startActivity(intent);
//                    if(linearLayout_address.getVisibility()==View.INVISIBLE){
//                        linearLayout_address.setVisibility(View.VISIBLE);
//                    }else{
//                        linearLayout_address.setVisibility(View.INVISIBLE);
//                    }
                    break;
                case R.id.btn_MyPage_AddressAPI_Remove:
                    break;
            }

        }
    };

}