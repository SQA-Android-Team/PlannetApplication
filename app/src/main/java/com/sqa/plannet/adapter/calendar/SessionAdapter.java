package com.sqa.plannet.adapter.calendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.sqa.plannet.R;
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
        Session classes1 = classes.get(position);
        holder.bind(classes1);

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
        private LinearLayout todayEvent;
        private Context context;

        public ClassesHolder(@NonNull View itemView, Context context) {
            super(itemView);
            this.context = context;
            txtTitle =itemView.findViewById(R.id.txtTitle);
            txtType =itemView.findViewById(R.id.txtType);
            txtDay =itemView.findViewById(R.id.txtDay);

            txtLocation = itemView.findViewById(R.id.txtLocation);
            txtStartTime = itemView.findViewById(R.id.txtStartTime);
            todayEvent = itemView.findViewById(R.id.todayEvent);



        }
        public void  bind(Session classes1){
            txtTitle.setText(classes1.getSessionTitle());
            txtType.setText(classes1.getType());
            txtLocation.setText(classes1.getLocation());
            txtStartTime.setText(classes1.getStartTime());
            txtDay.setText(classes1.getDate());


            // handle onclick

            todayEvent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Intent intent = new Intent(CalendarViewActivity.this, TodoActivity.this);
//                    intent.putExtra("DATE", (Serializable) txtDay);
//                    intent.putExtra("MONTH", (Serializable) txtMonth);
//
//                    context.startActivity(intent);

                }
            });

        }
    }

}

