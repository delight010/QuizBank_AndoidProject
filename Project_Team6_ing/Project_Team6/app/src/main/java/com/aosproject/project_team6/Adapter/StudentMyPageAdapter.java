package com.aosproject.project_team6.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.aosproject.project_team6.Bean.StudentMyPage;

import java.util.ArrayList;

public class StudentMyPageAdapter extends BaseAdapter {

    private Context mContext = null;
    private  int layout = 0;
    private ArrayList<StudentMyPage> data = null;
    private LayoutInflater inflater = null;

    public StudentMyPageAdapter(Context mContext, int layout, ArrayList<StudentMyPage> data) {
        this.mContext = mContext;
        this.layout = layout;
        this.data = data;
        this.inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position).getSid();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
