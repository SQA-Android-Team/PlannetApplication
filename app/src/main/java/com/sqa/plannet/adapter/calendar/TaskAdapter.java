package com.sqa.plannet.adapter.calendar;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sqa.plannet.R;
import com.sqa.plannet.activity.calendar.CalendarViewActivity;
import com.sqa.plannet.activity.subject.SubjectDetailActivity;
import com.sqa.plannet.activity.subject.SubjectViewActivity;
import com.sqa.plannet.activity.todo.TodoMainActivity;
import com.sqa.plannet.model.Task;

import java.util.List;

public class TaskAdapter extends  RecyclerView.Adapter<TaskAdapter.EventsHolder> {

    private List<Task> events;

    public TaskAdapter(List<Task> events) {
        this.events = events;
    }

    @NonNull
    @Override
    public EventsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // activity to display
        Context context = parent.getContext();

        // xml => java object
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.calendar_todayevent, parent, false);



        return new EventsHolder(itemView);
    }



    @Override
    public void onBindViewHolder(@NonNull EventsHolder holder, int position) {
          Task newEvent=  events.get(position);
          // bind data with template
            holder.bind(newEvent);

    }

    @Override
    public int getItemCount() {
        return  events.size();
    }

    public class EventsHolder extends  RecyclerView.ViewHolder {

        private TextView txtTitle;
        private TextView txtType;


        private LinearLayout todayEvent;




        public EventsHolder(@NonNull View itemView) {
            super(itemView);
            todayEvent = itemView.findViewById(R.id.todayEvent);
            txtTitle =itemView.findViewById(R.id.txtTitle);
            txtType =itemView.findViewById(R.id.txtType);




        }
        public void bind(Task events){
            txtTitle.setText(events.getTaskTitle());
            txtType.setText(events.getTaskType());


            // handle onclick
            todayEvent.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  Context  context = v.getContext();
                                                  Intent intent = new Intent(context,
                                                          SubjectDetailActivity.class);

                                                  context.startActivity(intent);

                                              }
                                          }
            );


        }

    }
}
