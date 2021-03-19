package com.sqa.plannet.adapter.calendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sqa.plannet.R;
import com.sqa.plannet.model.Task;

import java.util.List;

public class EventsAdapter extends  RecyclerView.Adapter<EventsAdapter.EventsHolder> {

    private List<Task> events;

    public EventsAdapter(List<Task> events) {
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
        private TextView txtDay;
//        private TextView txtMonth;



        public EventsHolder(@NonNull View itemView) {
            super(itemView);

            txtTitle =itemView.findViewById(R.id.txtTitle);
            txtType =itemView.findViewById(R.id.txtType);
            txtDay =itemView.findViewById(R.id.txtDay);
//            txtMonth= itemView.findViewById(R.id.txtMonth);


        }
        public void bind(Task events){
            txtTitle.setText(events.getTaskTitle());
            txtType.setText(events.getTaskType());
            txtDay.setText(events.getDueDate().toString());
            // handle onclick

        }

    }
}
