package com.aosproject.project_team6.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.aosproject.project_team6.Common.ShareVar;
import com.aosproject.project_team6.NetworkTask.Workbook_NetworkTask;
import com.aosproject.project_team6.R;

import net.daum.mf.map.api.MapView;

public class MyPageAddressActivity extends AppCompatActivity {

    //변수
    String urlAddr = null;
    String urlAddrUpdate = null;
    String tid = "t01"; // 선생님 tid값
    String macIP, taddress;


    TextView tv_address;
    Button btn_edit, btn_remove;
    WebView webView_map;
    LinearLayout linearLayout_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page_address);

        macIP = ShareVar.IPAddress;
        //등록되어있는 정보 보여주기
//        urlAddr = "http://" + macIP + ":8080/test/quizbank_MyPageTeacher_AddressSelect.jsp?tid=" + tid ;
        //업데이트용 jsp
        urlAddrUpdate = "http://" + macIP + ":8080/test/quizbank_MyPageTeacher_AddressUpdate.jsp?";


        btn_edit = findViewById(R.id.btn_MyPage_AddressAPI_Edit);
        btn_remove = findViewById(R.id.btn_MyPage_AddressAPI_Remove);
        tv_address = findViewById(R.id.tv_MyPage_teacher_Address);
        webView_map = findViewById(R.id.webview_map);
//        linearLayout_address = findViewById(R.id.linearLayout_MyPage_AddressAPI);


        btn_edit.setOnClickListener(onClickListener);
        btn_remove.setOnClickListener(onClickListener);
//        linearLayout_address.setOnClickListener(onClickListener);


        //Web Setting
        WebSettings webSettings = webView_map.getSettings();
        webSettings.setJavaScriptEnabled(true); // JavaScript 사용 여부
        webSettings.setBuiltInZoomControls(true); // 확대 축소 사용 여부
        webSettings.setDisplayZoomControls(false); // 돋보기 사용 여부
        webView_map.getSettings().setJavaScriptEnabled(true);
        webView_map.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView_map.setWebChromeClient(new WebChromeClient()); // web client 를 chrome 으로 설정
        webView_map.loadUrl("http://" + macIP + ":8080/test/quizbank_AddressWebView.jsp");



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
                    AlertDialog.Builder dlg2 = new AlertDialog.Builder(MyPageAddressActivity.this);
                    dlg2.setTitle("주소 삭제 확인")
                            .setIcon(R.mipmap.ic_launcher_round)
                            .setMessage("주소를 삭제하시겠습니까?")
                            .setPositiveButton("삭제", mAddressRemove)
                            .setNegativeButton("취소", mAddressRemove)
                            .show();
                    break;
            }

        }
    };



    //Dialog Division Edit ( 선생님 주소 내용 삭제 )
    DialogInterface.OnClickListener mAddressRemove = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if(which == DialogInterface.BUTTON_POSITIVE){ //확인 눌렀을 때
                tv_address.setText("");
                //********여기에 DB 내용 넣어야 함 ********
                taddress = "";
                urlAddrUpdate = urlAddrUpdate + "taddress=" + taddress +"&tid=" + tid;
                String result = connectInsertData();
                if(result.equals("1")){
                    // 정상인 경우 ( 1만 정상이라는 것은 jsp 에서 판단 할 수 있도록 만들 예정임. )
                    Toast.makeText(MyPageAddressActivity.this, "주소가 삭제되었습니다", Toast.LENGTH_SHORT).show();
                }else  {/*에러걸렸으면*/
                    Toast.makeText(MyPageAddressActivity.this, "주소 삭제가 실패되었습니다.",  Toast.LENGTH_SHORT).show();
                }
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
            Workbook_NetworkTask networkTask = new Workbook_NetworkTask(MyPageAddressActivity.this, urlAddrUpdate, "update");
            Object obj = networkTask.execute().get();
            result = (String) obj;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

}