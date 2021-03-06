//package com.sqa.plannet.adapter.calendar;
//
//import android.content.Context;
//import android.content.Intent;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//
//import com.sqa.plannet.R;
//import com.sqa.plannet.activity.subject.SubjectDetailActivity;
//import com.sqa.plannet.activity.subject.SubjectViewActivity;
//import com.sqa.plannet.activity.timetable.Timetable_SessionDetail;
//import com.sqa.plannet.model.Session;
//
//import java.util.List;
//
//public class SessionAdapter extends RecyclerView.Adapter<SessionAdapter.ClassesHolder> {
//
//    List<Session> classes;
//
//    public SessionAdapter(List<Session> classes) {
//        this.classes = classes;
//    }
//
//    @NonNull
//    @Override
//    public ClassesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        // activity to display
//        Context context = parent.getContext();
//
//        // xml => java object
//        LayoutInflater inflater = LayoutInflater.from(context);
//        View itemView = inflater.inflate(R.layout.calendar_class, parent, false);
//
//
//
//        return new ClassesHolder(itemView, context);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ClassesHolder holder, int position) {
//        Session newClasses = classes.get(position);
//        holder.bind(newClasses);
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return classes.size();
//    }
//
//    public class ClassesHolder extends RecyclerView.ViewHolder{
//        private TextView txtTitle;
//        private TextView txtType;
//        private TextView txtDay;
//        //        private TextView txtMonth;
//        private TextView txtLocation;
//        private TextView txtStartTime;
//        private LinearLayout Session;
//        private Context context;
//
//        public ClassesHolder(@NonNull View itemView, Context context) {
//            super(itemView);
//            this.context = context;
//            txtTitle =itemView.findViewById(R.id.txtTitle);
//            txtType =itemView.findViewById(R.id.txtType);
//            txtDay =itemView.findViewById(R.id.txtDay);
//
//            txtLocation = itemView.findViewById(R.id.txtLocation);
//            txtStartTime = itemView.findViewById(R.id.txtStartTime);
//            Session = itemView.findViewById(R.id.Session);
//
//
//
//        }
//        public void  bind(Session classes){
//            txtTitle.setText(classes.getSessionTitle());
//            txtType.setText(classes.getType());
//            txtLocation.setText(classes.getLocation());
//            txtStartTime.setText(classes.getStartTime());
//            txtDay.setText(classes.getWeekDay());
//
//
//            // handle onclick
//
//           Session.setOnClickListener(new View.OnClickListener() {
//               @Override
//               public void onClick(View v) {
//                  Context context = v.getContext();
//                  Intent intent = new Intent(context, Timetable_SessionDetail.class);
//                  context.startActivity(intent);
//
//               }
//           });
//
//        }
//    }
//
//}
//

package com.sqa.plannet.adapter.calendar;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sqa.plannet.R;

import com.sqa.plannet.activity.calendar.CalendarViewActivity;
import com.sqa.plannet.activity.timetable.Timetable_SessionDetail;

import com.sqa.plannet.model.Session;

import java.util.List;

public class SessionAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<Session> list ;

    public SessionAdapter(Context context, int layout, List<Session> list) {
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
        convertView = inflater.inflate(R.layout.calendar_class, null);

        TextView txtTitle = convertView.findViewById(R.id.txtTitle);
        TextView txtType = convertView.findViewById(R.id.txtType);
        TextView txtStartTime = convertView.findViewById(R.id.txtStartTime);
        TextView txtLocation = convertView.findViewById(R.id.txtLocation);
        TextView txtDay = convertView.findViewById(R.id.txtDay);
        LinearLayout Session = convertView.findViewById(R.id.Session);

        Session session = list.get(position);
        txtStartTime.setText(session.getStartTime());
        txtTitle.setText(session.getSessionTitle());
        txtType.setText(session.getType());
        txtLocation.setText(session.getLocation());
        txtDay.setText(session.getWeekDay());

        Session.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Timetable_SessionDetail.class);
                context.startActivity(intent);
            }
        });




        return  convertView;
    }
}

