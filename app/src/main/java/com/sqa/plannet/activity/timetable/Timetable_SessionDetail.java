package com.sqa.plannet.activity.timetable;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.PersistableBundle;

import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.sqa.plannet.R;

import com.sqa.plannet.adapter.calendar.SessionAdapter;

import com.sqa.plannet.model.Session;
import com.sqa.plannet.model.Task;

import java.util.ArrayList;
import java.util.List;

import static com.sqa.plannet.activity.home.HomeActivity.myDatabase;


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
    public static String TABLE_SESSION = "sessions";



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timetable_session_detail);

//        listSession = getAllSession();
//        adapter = new SessionAdapter(Timetable_SessionDetail.this, R.layout.calendar_view, listSession);
//        rvReminders.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
//
//        txtSessionNameValue = txtSessionNameValue.findViewById(R.id.txtSessionNameValue);
//
//        txtSessionNameValue.setText("abc");
//
            initUI();
//            onBackBtnClick();
//            onDeleteBtn();
            // TODO: fix the line below
//        setText(null);

            onBackBtnClick();
            onDeleteBtn();
        onEditBtnClick();
            loadData();




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


    private  void onEditBtnClick(){
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Timetable_SessionDetail.this, Timetable_SessionDetail_Edit.class));
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
//    public ArrayList<Session> getAllSession() {
//        ArrayList<Session> list = new ArrayList<>();
//        String sql_select = "SELECT * FROM " + TABLE_SESSION;
//        Cursor cs = myDatabase.rawQuery(sql_select);
//        list.clear();
//        while (cs.moveToNext()) {
//            int id = cs.getInt(0);
//            String title = cs.getString(1);
//            String type = cs.getString(2);
//            String location = cs.getString(3);
//            String startTime = cs.getString(4);
//            String endTime = cs.getString(5);
//            String dateOfWeek = cs.getString(6);
//
//        }
//        return list;
//    }
    private  void loadData(){
        List<Session> list = TimetableViewActivity.getAllSession();
        txtSessionNameValue.setText(list.get(0).getSessionTitle()+"");
        txtSessionDescriptionValue.setText(list.get(0).getType()+ "");
        txtSessionStartTimeValue.setText(list.get(0).getStartTime()+ "");
        txtSessionLocationValue.setText(list.get(0).getLocation()+ "");
        txtSessionEndTimeValue.setText(list.get(0).getEndTime()+ "");
        txtSessionColorValue.setText(list.get(0).getColor()+ "");
        txtSessionDayOfWeekValue.setText(list.get(0).getWeekDay() + "");
    }
}
