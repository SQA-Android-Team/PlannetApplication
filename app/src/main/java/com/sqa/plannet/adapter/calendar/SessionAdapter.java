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
import com.sqa.plannet.activity.subject.SubjectDetailActivity;
import com.sqa.plannet.activity.subject.SubjectViewActivity;
import com.sqa.plannet.activity.timetable.Timetable_SessionDetail;
import com.sqa.plannet.model.Session;

import java.util.List;

public class SessionAdapter extends RecyclerView.Adapter<SessionAdapter.ClassesHolder> {

    List<Session> classes;

    public SessionAdapter(List<Session> classes) {
        this.classes = classes;
    }

    @NonNull
    @Override
    public ClassesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // activity to display
        Context context = parent.getContext();

        // xml => java object
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.calendar_class, parent, false);



        return new ClassesHolder(itemView, context);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassesHolder holder, int position) {
        Session newClasses = classes.get(position);
        holder.bind(newClasses);

    }

    @Override
    public int getItemCount() {
        return classes.size();
    }

    public class ClassesHolder extends RecyclerView.ViewHolder{
        private TextView txtTitle;
        private TextView txtType;
        private TextView txtDay;
        //        private TextView txtMonth;
        private TextView txtLocation;
        private TextView txtStartTime;
        private LinearLayout Session;
        private Context context;

        public ClassesHolder(@NonNull View itemView, Context context) {
            super(itemView);
            this.context = context;
            txtTitle =itemView.findViewById(R.id.txtTitle);
            txtType =itemView.findViewById(R.id.txtType);
            txtDay =itemView.findViewById(R.id.txtDay);

            txtLocation = itemView.findViewById(R.id.txtLocation);
            txtStartTime = itemView.findViewById(R.id.txtStartTime);
            Session = itemView.findViewById(R.id.Session);



        }
        public void  bind(Session classes){
            txtTitle.setText(classes.getSessionTitle());
            txtType.setText(classes.getType());
            txtLocation.setText(classes.getLocation());
            txtStartTime.setText(classes.getStartTime());
            txtDay.setText(classes.getWeekDay());


            // handle onclick

           Session.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                  Context context = v.getContext();
                  Intent intent = new Intent(context, Timetable_SessionDetail.class);
                  context.startActivity(intent);

               }
           });

        }
    }

}

