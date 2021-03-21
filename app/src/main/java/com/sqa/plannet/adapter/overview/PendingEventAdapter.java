package com.sqa.plannet.adapter.overview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.sqa.plannet.R;
import com.sqa.plannet.model.PendingEventData;

import java.util.List;


public class PendingEventAdapter extends RecyclerView.Adapter<PendingEventAdapter.PendingEventViewHolder> {

    Context context;
    List<PendingEventData> pendingEventDataList;

    public PendingEventAdapter(Context context, List<PendingEventData> pendingEventDataList) {
        this.context = context;
        this.pendingEventDataList = pendingEventDataList;
    }

    @NonNull
    @Override
    public PendingEventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.overview_event_row, parent, false);

        //  create a recyclerview row item layout file
        return new PendingEventViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull PendingEventViewHolder holder, int position) {

        holder.dateEvent.setText(pendingEventDataList.get(position).getDateEvent());
        holder.monthEvent.setText(pendingEventDataList.get(position).getMonthEvent());
        holder.nameEvent.setText(pendingEventDataList.get(position).getNameEvent());
    }

    @Override
    public int getItemCount() {
        return pendingEventDataList.size();
    }

    public static final class PendingEventViewHolder extends RecyclerView.ViewHolder{

        TextView dateEvent, monthEvent, nameEvent;

        public PendingEventViewHolder (@NonNull View itemView) {
            super(itemView);

            dateEvent = itemView.findViewById(R.id.date);
            monthEvent = itemView.findViewById(R.id.month);
            nameEvent = itemView.findViewById(R.id.event_name);

        }
    }
}
