package com.sqa.plannet.activity.timetable;
//
//import android.os.Bundle;
//import android.os.PersistableBundle;
//
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.sqa.plannet.R;
//
//public class Timetable_SessionDetail extends AppCompatActivity{
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
//        super.onCreate(savedInstanceState, persistentState);
//        setContentView(R.layout.timetable_session_details);
//    }
//}
//
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.sqa.plannet.R;
import com.sqa.plannet.activity.calendar.CalendarViewActivity;
import com.sqa.plannet.adapter.calendar.SessionAdapter;
import com.sqa.plannet.adapter.calendar.TaskAdapter;
import com.sqa.plannet.database.MyDatabase;
import com.sqa.plannet.model.Session;
import com.sqa.plannet.model.Task;

import java.util.ArrayList;


public class Timetable_SessionDetail extends AppCompatActivity{

    private ImageButton btnDelete;
    private ImageButton btnEdit;
    private ImageButton btnBack;
    public ListView  rvReminders;
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
    public static MyDatabase myDatabase;
    public static String TABLE_NAME = "sessions";



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.timetable_session_detail);

        myDatabase = new MyDatabase(Timetable_SessionDetail.this, "manageSession.sqlite", null, 1);
        String sql_create_table = "create table  if not exists tasks(id integer primary key autoincrement NOT NULL, " +
                "title varchar(100) NOT NULL, " +
                "type varchar(15) NOT NULL, " +
                "location varchar(50) NOT NULL, " +
                "timeStart varchar(20) NOT NULL, " +
                "timeEnd varchar(20), " +
                "day varchar(10),";
        myDatabase.excuteSQL(sql_create_table);

        listSession = getAllSession();
        adapter = new SessionAdapter(Timetable_SessionDetail.this, R.layout.calendar_view, listSession);
        rvReminders.setAdapter(adapter);
        adapter.notifyDataSetChanged();
//
//        txtSessionNameValue = txtSessionNameValue.findViewById(R.id.txtSessionNameValue);
//
//        txtSessionNameValue.setText("abc");

        try {
            initUI();
            // TODO: fix the line below
//        setText(null);

            onBackBtnClick();
            onDeleteBtn();
        } catch (Exception e) {
            Log.i(e.getMessage(), "onCreate: ");
        }




    }
    /**
     * TODO: initialise all necessary UI elements
     */
    private void initUI(){
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

    }
    /**
     * TODO:  add event listener for backBtn
     */
    private void onBackBtnClick() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    /**
     * TODO: add event listener for delete button
     * INCOMPLETE
     */
    private void onDeleteBtn(){
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog deleteConfirm = new AlertDialog.Builder(Timetable_SessionDetail.this)
                        .setTitle("Confirmation")
                        .setMessage("Do you really want to delete this Session?")
                        .setIcon(R.drawable.ic_baseline_delete_24)
                        .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                // deleting code
                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                dialog.dismiss();
                            }
                        })
                        .create();

                deleteConfirm.show();

            }
        });
    }
    public ArrayList<Session> getAllSession() {
        ArrayList<Session> list = new ArrayList<>();
        String sql_select = "SELECT * FROM " + TABLE_NAME;
        Cursor cs = myDatabase.rawQuery(sql_select);
        list.clear();
        while (cs.moveToNext()) {
            int id = cs.getInt(0);
            String title = cs.getString(1);
            String type = cs.getString(2);
            String location = cs.getString(3);
            String startTime = cs.getString(4);
            String endTime = cs.getString(5);
            String dateOfWeek = cs.getString(6);
            Session session = new Session(id, title, type, location, startTime, endTime, dateOfWeek);
            Toast.makeText(this, "" + session, Toast.LENGTH_SHORT).show();
            list.add(session);
        }
        return list;
    }
}
