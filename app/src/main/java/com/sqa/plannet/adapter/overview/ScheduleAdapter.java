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

import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder> {

    Context context;
    List<ScheduleData> scheduleDataList;

    public ScheduleAdapter(Context context, List<ScheduleData> scheduleDataList) {
        this.context = context;
        this.scheduleDataList = scheduleDataList;
    }

    @NonNull
    @Override
    public ScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.overview_schedule_row, parent, false);

        // here we create a recyclerview row item layout file
        return new ScheduleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleViewHolder holder, int position) {

        holder.courseName.setText(scheduleDataList.get(position).getCourseName());
        holder.professor.setText(scheduleDataList.get(position).getProfessor());
        holder.room.setText(scheduleDataList.get(position).getRoom());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context, DetailsActivity.class);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return scheduleDataList.size();
    }

    public static final class ScheduleViewHolder extends RecyclerView.ViewHolder{

        TextView courseName, professor, room;

        public ScheduleViewHolder (@NonNull View itemView) {
            super(itemView);

            courseName = itemView.findViewById(R.id.date);
            professor = itemView.findViewById(R.id.professor);
            room = itemView.findViewById(R.id.room);

        }
    }
}
