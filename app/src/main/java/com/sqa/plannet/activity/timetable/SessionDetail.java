package com.sqa.plannet.activity.timetable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.sqa.plannet.R;
import com.sqa.plannet.adapter.calendar.SessionAdapter;
import com.sqa.plannet.model.Session;

import java.util.ArrayList;
import java.util.List;

public class SessionDetail extends AppCompatActivity {
    private ImageButton btnDelete;
    private ImageButton btnEdit;
    private ImageButton btnBack;
    public ListView rvReminders;
    private TextView txtSessionNameValue;
    private TextView txtSessionDescriptionValue;
    private TextView txtSessionLocationValue;
    private TextView txtSessionStartTimeValue;
    private TextView txtSessionEndTimeValue;
    private TextView txtSessionColorValue;
    private TextView txtSessionDayOfWeekValue;


    private CalendarView calendarView;

    ArrayList<Session> listSession = new ArrayList<>();
    SessionAdapter adapter;
    public static String TABLE_SESSION = "sessions";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timetable_session_detail);
//        loadData();
        btnBack = findViewById(R.id.btnBack);
        btnDelete = findViewById(R.id.btnDelete);
        btnEdit = findViewById(R.id.btnEdit);
        txtSessionNameValue = findViewById(R.id.txtSessionNameValue);
        txtSessionDescriptionValue = findViewById(R.id.txtSessionDescriptionValue);
        txtSessionLocationValue = findViewById(R.id.txtSessionLocationValue);
        txtSessionStartTimeValue = findViewById(R.id.txtSessionStartValue);
        txtSessionEndTimeValue = findViewById(R.id.txtSessionEndValue);
        txtSessionColorValue = findViewById(R.id.txtSessionColorValue);
        txtSessionDayOfWeekValue = findViewById(R.id.txtSessionDayOfWeekValue);



        txtSessionNameValue.setText( "Title: " );
        txtSessionDescriptionValue.setText("" );
        txtSessionStartTimeValue.setText("Time: " );
        txtSessionLocationValue.setText("Location: " );
        txtSessionEndTimeValue.setText("Abc");
        txtSessionColorValue.setText("Important: ");
        txtSessionDayOfWeekValue.setText("Remind: ");
    }
//    private  void loadData(){
//        List<Session> list = TimetableViewActivity.getAllSession();
//        txtSessionNameValue.setText( "Title: " +list.get(0).getSessionTitle());
//        txtSessionDescriptionValue.setText("" +list.get(0).getType()+ "");
//        txtSessionStartTimeValue.setText("Time: " +list.get(0).getStartTime()+ "");
//        txtSessionLocationValue.setText("Location: " +list.get(0).getLocation()+ "");
//        txtSessionEndTimeValue.setText("" +list.get(0).getEndTime()+ "");
//        txtSessionColorValue.setText("Important: " +list.get(0).getColor()+ "");
//        txtSessionDayOfWeekValue.setText("Remind: " +list.get(0).getWeekDay() + "");
//    }
}