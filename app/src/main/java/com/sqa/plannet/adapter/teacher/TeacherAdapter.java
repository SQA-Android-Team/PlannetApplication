package com.sqa.plannet.adapter.teacher;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sqa.plannet.R;
import com.sqa.plannet.activity.teacher.TeacherDetailActivity;
import com.sqa.plannet.model.Task;
import com.sqa.plannet.model.Teacher;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class TeacherAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<Teacher> list ;
    Teacher teacher;

    public TeacherAdapter(Activity context, int todo_item_does, ArrayList<Teacher> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.teacher_item, null);
        LinearLayout lnTeacher = view.findViewById(R.id.lnTeacher);
        TextView teacherName = view.findViewById(R.id.teacherNameTxv);
        teacher = list.get(position);
        teacherName.setText(teacher.getTeacherName());
        return null;
    }
}
