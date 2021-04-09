package com.sqa.plannet.activity.timetable;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageButton;

import com.sqa.plannet.R;
import com.sqa.plannet.adapter.calendar.SessionAdapter;
import com.sqa.plannet.model.Session;

import java.util.ArrayList;
import java.util.List;

public class Timetable_SessionDetail_Edit extends AppCompatActivity {
    private EditText txtSessionNameValue;
    private EditText txtSessionDescriptionValue;
    private EditText txtSessionLocationValue;
    private EditText txtSessionStartValue;
    private EditText txtSessionEndValue;
    private EditText txtSessionColorValue;
    private EditText txtSessionDayOfWeekValue;
    private ImageButton btnCancel;
    private ImageButton btnConfirm;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timetable_session_detail_edit);

        initUI();
        onBackBtnClick();
        onEditBtnClick();
        loadData();
    }
    /**
     * TODO: initialise all necessary UI elements
     */
    private void initUI(){
        txtSessionNameValue = findViewById(R.id.txtSessionNameValue);
        txtSessionDescriptionValue = findViewById(R.id.txtSessionDescriptionValue);
        txtSessionLocationValue = findViewById(R.id.txtSessionLocationValue);
        txtSessionStartValue = findViewById(R.id.txtSessionStartValue);
        txtSessionEndValue = findViewById(R.id.txtSessionEndValue);
        txtSessionColorValue = findViewById(R.id.txtSessionColorValue);
        txtSessionDayOfWeekValue = findViewById(R.id.txtSessionDayOfWeekValue);

        btnCancel = findViewById(R.id.btnCancel);
        btnConfirm = findViewById(R.id.btnConfirm);


    }

    /**
     * TODO:  add event listener for backBtn
     */
    private void onBackBtnClick() {
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    private  void onEditBtnClick(){
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // todo : update data into database
            }
        });
    }
    private  void loadData(){
        List<Session> list = TimetableViewActivity.getAllSession();

        txtSessionNameValue.setHint(list.get(0).getSessionTitle()+"");
        txtSessionDescriptionValue.setHint(list.get(0).getType()+ "");
        txtSessionStartValue.setHint(list.get(0).getStartTime()+ "");
        txtSessionLocationValue.setHint(list.get(0).getLocation()+ "");
        txtSessionEndValue.setHint(list.get(0).getEndTime()+ "");
        txtSessionColorValue.setHint(list.get(0).getColor()+ "");
        txtSessionDayOfWeekValue.setHint(list.get(0).getWeekDay() + "");
    }


}