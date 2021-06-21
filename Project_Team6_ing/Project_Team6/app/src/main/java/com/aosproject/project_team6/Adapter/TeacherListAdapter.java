package com.aosproject.project_team6.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.aosproject.project_team6.Bean.TeacherListBean;
import com.aosproject.project_team6.R;

import java.util.ArrayList;

public class TeacherListAdapter extends RecyclerView.Adapter<TeacherListAdapter.ViewHolder> {

    private Context mContext = null;
    private int layout = 0;
    private ArrayList<TeacherListBean> data = null;

    // Constructor
    public TeacherListAdapter(Context mContext, int layout, ArrayList<TeacherListBean> data) {
        this.mContext = mContext;
        this.layout = layout;
        this.data = data;
    }

    // ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView iv_teacher_subject_icon, iv_teacher_workbookmenu;
        public TextView tv_teacher_workbooktitle;

        public ViewHolder(View itemView) {
            super(itemView);

            iv_teacher_subject_icon = itemView.findViewById(R.id.iv_teacher_subject_icon);
            tv_teacher_workbooktitle = itemView.findViewById(R.id.tv_teacher_workbooktitle);
            iv_teacher_workbookmenu = itemView.findViewById(R.id.iv_teacher_workbookmenu);

        }


    }


    // ViewHolder 만들기
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_cardview_teacher_do_quiz, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tv_teacher_workbooktitle.setText(data.get(position).getWtitle());

        if (data.get(position).getSubject().equals("math")){
            holder.iv_teacher_subject_icon.setImageResource(R.drawable.icon_math);
        }else{
            holder.iv_teacher_subject_icon.setImageResource(R.drawable.icon_eng);

        }


    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
