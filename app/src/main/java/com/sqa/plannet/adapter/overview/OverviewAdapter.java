package com.sqa.plannet.adapter.overview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sqa.plannet.R;
import com.sqa.plannet.activity.todo.DetailActivity;
import com.sqa.plannet.model.Task;

import java.util.ArrayList;
import java.util.List;

public class OverviewAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<Task> list ;

    public OverviewAdapter(Activity context, ArrayList<Task> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }



    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) { return list.get(position); }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.overview_event_row, null);
        TextView titledoes =  view.findViewById(R.id.event_name);
        TextView datedoes =  view.findViewById(R.id.event_date);
        LinearLayout lntask = view.findViewById(R.id.no_event);

        Task task = list.get(position);
        titledoes.setText(task.getTitle());
        datedoes.setText(task.getDate());



        lntask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                context.startActivity(intent);
            }
        });

        return view;
    }

}
