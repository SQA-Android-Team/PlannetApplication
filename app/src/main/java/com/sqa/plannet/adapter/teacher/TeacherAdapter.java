package com.sqa.plannet.adapter.teacher;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sqa.plannet.R;
import com.sqa.plannet.model.Teacher;

import java.util.List;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.TeacherViewHolder> {
    private List<Teacher> listTeacher;

    public void setData(List<Teacher> list){
        this.listTeacher = list;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public TeacherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.teacher_item, parent, false);
        return new TeacherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherAdapter.TeacherViewHolder holder, int position) {
        Teacher teacher = listTeacher.get(position);
        if (teacher == null){
            return;
        }

        holder.teacherName.setText(teacher.getTeacherName());
    }

    @Override
    public int getItemCount() {
        if (this.listTeacher != null){
            return this.listTeacher.size();
        }
        return 0;
    }

    public class TeacherViewHolder extends RecyclerView.ViewHolder {

        private TextView teacherName;
        public TeacherViewHolder(@NonNull View view){
            super(view);
            teacherName = view.findViewById(R.id.teacherNameTxv);
        }


    }
}
