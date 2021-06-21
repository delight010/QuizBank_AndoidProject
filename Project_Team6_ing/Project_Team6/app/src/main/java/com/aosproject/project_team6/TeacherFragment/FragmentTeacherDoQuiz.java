package com.aosproject.project_team6.TeacherFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.aosproject.project_team6.Adapter.TeacherListAdapter;
import com.aosproject.project_team6.Bean.TeacherListBean;
import com.aosproject.project_team6.NetworkTask.Workbook_NetworkTask;
import com.aosproject.project_team6.R;

import java.util.ArrayList;


public class FragmentTeacherDoQuiz extends Fragment {

    private View view;

    String myIP = "192.168.35.145";
    String urlAddr = "http://"+myIP+":8080/teacherlist/workbookSelectList.jsp?";

    ArrayList<TeacherListBean> workbooks;
    TeacherListAdapter adapter;
    Button btn_new_workbook;


    RecyclerView recyclerView = null;
    RecyclerView.LayoutManager layoutManager = null;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {




        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.v("Message", "FragmentTeacherDoQuiz Start");
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_teacher_do_quiz, container, false);



        recyclerView = view.findViewById(R.id.rv_teacher_lists_before);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        btn_new_workbook = view.findViewById(R.id.btn_new_workbook);

        connectGetData();

        return view;
    }

    private void connectGetData(){
        Log.v("Message", "METHOD : connectGetData Start");

        try{
            Log.v("Message", "  - Before start NetworkTask");

            Workbook_NetworkTask networkTask = new Workbook_NetworkTask(getActivity(), urlAddr, "select");
            Object obj = networkTask.execute().get();
            workbooks = (ArrayList<TeacherListBean>) obj;
            Log.v("Message", "  - workbooks(arraylist) : " + workbooks);


            adapter = new TeacherListAdapter(getActivity(), R.layout.custom_cardview_teacher_do_quiz, workbooks);

            Log.v("Message", "  - adapter is... : " + adapter);
            recyclerView.setAdapter(adapter);



        }catch(Exception e){
            e.printStackTrace();
        }


    }









}