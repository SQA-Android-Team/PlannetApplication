package com.sqa.plannet.adapter.overview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.sqa.plannet.R;
import com.sqa.plannet.activity.overview.DetailsActivity;
import com.sqa.plannet.model.ScheduleData;
import com.sqa.plannet.model.Session;

import java.util.ArrayList;
import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder> {

    Context context;
    ArrayList<Session> listSession;

    public ScheduleAdapter(ArrayList<Session> listSession) {
        this.context = context;
        this.listSession = listSession;
    }



    @NonNull
    @Override
    public ScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.overview_schedule_row,parent,false);

        // here we create a recyclerview row item layout file
        return new ScheduleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleViewHolder holder, int position) {

        holder.startTime.setText(listSession.get(position).getStartTime());
        holder.endTime.setText(listSession.get(position).getEndTime());
        holder.sessionName.setText(listSession.get(position).getSessionTitle());
        holder.sessDesc.setText(listSession.get(position).getType());


//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(context, DetailsActivity.class);
//                context.startActivity(i);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return listSession.size();
    }

    public static final class ScheduleViewHolder extends RecyclerView.ViewHolder{

        TextView startTime, endTime, sessionName, sessDesc;

        public ScheduleViewHolder (@NonNull View itemView) {
            super(itemView);

            startTime = itemView.findViewById(R.id.start_time);
            endTime = itemView.findViewById(R.id.end_time);
            sessionName = itemView.findViewById(R.id.session_name);
            sessDesc = itemView.findViewById(R.id.description);

        }
    }
}
