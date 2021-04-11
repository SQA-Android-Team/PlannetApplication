package com.sqa.plannet.adapter.overview;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sqa.plannet.R;
import com.sqa.plannet.model.Task;

import java.util.ArrayList;

public class PendingEventAdapter extends RecyclerView.Adapter<PendingEventAdapter.PendingEventViewHolder>{
    Context context;
    ArrayList<Task> eventList;

    public PendingEventAdapter(ArrayList<Task> eventList) {
        this.context = context;
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public PendingEventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.overview_event_row,parent,false);
        return new PendingEventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PendingEventViewHolder holder, int position) {
        holder.eventName.setText(eventList.get(position).getTitle());
        holder.eventDate.setText(eventList.get(position).getDate()); }


    @Override
    public int getItemCount() {
        return eventList.size();
    }

    class PendingEventViewHolder extends RecyclerView.ViewHolder
    {
        TextView eventName, eventDate;
        public PendingEventViewHolder(@NonNull View itemView)
        {
            super(itemView);
            eventName = itemView.findViewById(R.id.event_name);
            eventDate = itemView.findViewById(R.id.event_date);
        }
    }

}

//public class PendingEventAdapter extends RecyclerView.Adapter<PendingEventAdapter.PendingEventViewHolder> {
//
//    Context context;
//    List<PendingEventData> pendingEventDataList;
//
//    public PendingEventAdapter(Context context, List<PendingEventData> pendingEventDataList) {
//        this.context = context;
//        this.pendingEventDataList = pendingEventDataList;
//    }
//
//    @NonNull
//    @Override
//    public PendingEventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//        View view = LayoutInflater.from(context).inflate(R.layout.overview_event_row, parent, false);
//
//        //  create a recyclerview row item layout file
//        return new PendingEventViewHolder(view);
//    }
//
//
//    @Override
//    public void onBindViewHolder(@NonNull PendingEventViewHolder holder, int position) {
//
//        holder.dateEvent.setText(pendingEventDataList.get(position).getDateEvent());
//        holder.nameEvent.setText(pendingEventDataList.get(position).getNameEvent());
//    }
//
//    @Override
//    public int getItemCount() {
//        return pendingEventDataList.size();
//    }
//
//    public static final class PendingEventViewHolder extends RecyclerView.ViewHolder{
//
//        TextView dateEvent, nameEvent;
//
//        public PendingEventViewHolder (@NonNull View itemView) {
//            super(itemView);
//
//            dateEvent = itemView.findViewById(R.id.event_date);
////            monthEvent = itemView.findViewById(R.id.month);
//            nameEvent = itemView.findViewById(R.id.event_name);
//
//        }
//    }
//}
