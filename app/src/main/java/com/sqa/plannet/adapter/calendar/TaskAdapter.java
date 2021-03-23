package com.sqa.plannet.adapter.calendar;

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

import com.sqa.plannet.activity.calendar.CalendarViewActivity;
import com.sqa.plannet.activity.subject.SubjectDetailActivity;
import com.sqa.plannet.activity.subject.SubjectViewActivity;
import com.sqa.plannet.activity.timetable.Timetable_SessionDetail;

import com.sqa.plannet.activity.todo.CreateActivity;
import com.sqa.plannet.activity.todo.DetailActivity;
import com.sqa.plannet.activity.todo.TodoMainActivity;
import com.sqa.plannet.model.Task;

import java.util.List;

public class TaskAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<Task> list ;

    public TaskAdapter(Context context, int layout, List<Task> list) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.calendar_todayevent, null);
        TextView txtTitle = convertView.findViewById(R.id.txtTitle);
        TextView txtType = convertView.findViewById(R.id.txtType);
        LinearLayout todayEvent = convertView.findViewById(R.id.todayEvent);

        Task task = list.get(position);
        txtTitle.setText(task.getTitle());
        txtType.setText(task.getType());

        todayEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                context.startActivity(intent);
            }
        });




return  convertView;
    }
}
