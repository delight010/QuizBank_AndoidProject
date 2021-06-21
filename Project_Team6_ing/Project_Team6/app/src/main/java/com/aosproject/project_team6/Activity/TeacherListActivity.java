package com.aosproject.project_team6.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.aosproject.project_team6.Adapter.FragmentTeacherAdapter;
import com.aosproject.project_team6.R;
import com.google.android.material.tabs.TabLayout;

public class TeacherListActivity extends AppCompatActivity {

    ViewPager2 pager2;
    TabLayout tabLayout;
    FragmentTeacherAdapter adapter;
    ImageView iv_subscribe, iv_mypage, iv_home, iv_address, iv_seemore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("Message", "onCreate : TeacherListActivity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_list);

        //메뉴바 버튼
        iv_subscribe = findViewById(R.id.iv_subscribe);
        iv_mypage = findViewById(R.id.iv_mypage);
        iv_home = findViewById(R.id.iv_home);
        iv_address = findViewById(R.id.iv_address);
        iv_seemore = findViewById(R.id.iv_seemore);

        iv_subscribe.setOnClickListener(mClickListener);
        iv_mypage.setOnClickListener(mClickListener);
        iv_home.setOnClickListener(mClickListener);
        iv_address.setOnClickListener(mClickListener);
        iv_seemore.setOnClickListener(mClickListener);

        // ActionBar 숨기기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        tabLayout = findViewById(R.id.tabLayout);
        pager2 = findViewById(R.id.vp_t_do_quiz);

        FragmentManager fm = getSupportFragmentManager();
        adapter = new FragmentTeacherAdapter(fm, getLifecycle());
        pager2.setAdapter(adapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.v("Message", "TabSelect");
                pager2.setCurrentItem(tab.getPosition());


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        pager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });


    }//onCreate

    //메뉴 버튼 클릭시 이벤트 발생
    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent;
            switch (v.getId()){
                case R.id.iv_subscribe:

                case R.id.iv_mypage:

                case R.id.iv_home:

                case R.id.iv_address:

                case R.id.iv_seemore:

            }
        }
    };







}