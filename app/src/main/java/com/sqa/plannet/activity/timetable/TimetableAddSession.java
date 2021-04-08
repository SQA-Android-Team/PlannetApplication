package com.sqa.plannet.activity.timetable;

import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.navigation.NavigationView;
import com.sqa.plannet.R;
import com.sqa.plannet.activity.home.HomeActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimetableAddSession extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private TextView txtStartTimePicker, txtEndTimePicker, txtDateOfWeekPicker, txtFinish, txtCancel;
    private AppBarLayout appBarLayout;
    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Spinner spDateOfWeekPicker, sessionNamePicker;
    private ImageButton btnBack;
    private EditText edtSessionName,edtSessionDesc, edtLocation;
    ArrayAdapter<String> spinnerArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timetable_add_session);
        initUI();
        initToolbar();
        mapping();

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Add Session");
        drawerLayout.bringToFront();


        ArrayAdapter<CharSequence> adapterName = ArrayAdapter.createFromResource(this, R.array.subjectName, android.R.layout.simple_spinner_item);
        adapterName.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sessionNamePicker.setAdapter(adapterName);
        sessionNamePicker.setOnItemSelectedListener(this);

        // date of week picker
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.dateOfWeek, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDateOfWeekPicker.setAdapter(adapter);
        spDateOfWeekPicker.setOnItemSelectedListener(this);

        //start Time picker
        txtStartTimePicker = findViewById(R.id.txtStartTimePicker);
        txtStartTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeStartPicker();
            }
        });

        //endTime picker
        txtEndTimePicker = findViewById(R.id.txtEndTimePicker);
        txtEndTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeEndPicker();
            }
        });
    }

    private void mapping() {
        drawerLayout = findViewById(R.id.addClassViewDrawer);
        navigationView = findViewById(R.id.navView);
        edtSessionDesc = findViewById(R.id.edtSessionDesc);
        sessionNamePicker = findViewById(R.id.sessionNamePicker);
        txtStartTimePicker = findViewById(R.id.txtStartTimePicker);
        txtEndTimePicker = findViewById(R.id.txtEndTimePicker);
        btnBack = findViewById(R.id.btnBack);
        txtFinish = findViewById(R.id.txtFinish);
        edtLocation = findViewById(R.id.edtLocation);
        drawerLayout = findViewById(R.id.addClassViewDrawer);
        toolbar = findViewById(R.id.addClassViewToolbar);
        navigationView = findViewById(R.id.navView);
        spDateOfWeekPicker = findViewById(R.id.spDateOfWeekPicker);
    }


    private void initUI(){
        appBarLayout = findViewById(R.id.appBarLayout);
        collapsingToolbarLayout = findViewById(R.id.colToolbar);
        toolbar = findViewById(R.id.timetableViewToolbar);
    }

    private void initToolbar(){
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    // picker for startTime
    private void timeStartPicker(){
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                calendar.set(0,0,0, hourOfDay, minute);
                txtStartTimePicker.setText("Start - " + simpleDateFormat.format(calendar.getTime()));

            }
        }, hour,minute, true);
        timePickerDialog.show();
    }

    // picker for endTime
    private void timeEndPicker(){
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                calendar.set(0,0,0, hourOfDay, minute);
                txtEndTimePicker.setText("End - " + simpleDateFormat.format(calendar.getTime()));

            }
        }, hour,minute, true);
        timePickerDialog.show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
//        Toast.makeText(parent.getContext(),text, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onNothingSelected (AdapterView < ? > parent){

    }

    public void onBackBtnClick(View view) {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void onClickAddSessionBtn(View view) {
        txtFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TimetableAddSession.this, TimetableViewActivity.class);
                startActivity(intent);

            }
        });
    }

    public void onClickCancel(View view) {
        txtCancel = findViewById(R.id.txtCancel);
        txtCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void createSession(View view) {
        String name = sessionNamePicker.getSelectedItem().toString();
        String des = edtSessionDesc.getText().toString();
        String sessionLocation = edtLocation.getText().toString();
        String dateOfWeek = spDateOfWeekPicker.getSelectedItem().toString();
        String startTime = txtStartTimePicker.getText().toString();
        String endTime = txtEndTimePicker.getText().toString();

         if(TextUtils.isEmpty(des)) {
            edtSessionDesc.setError("Please enter the description");
        } else if(TextUtils.isEmpty(sessionLocation)) {
            edtLocation.setError("Please enter the location");
        } else if(TextUtils.isEmpty(startTime)) {
             txtStartTimePicker.setError("Please pick the start time");
        }else if(TextUtils.isEmpty(endTime)) {
             txtEndTimePicker.setError("Please pick the end time");
        } else{
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", name);
            contentValues.put("des", des);
            contentValues.put("sessionLocation", sessionLocation);
            contentValues.put("dateOfWeek", dateOfWeek);
            contentValues.put("startTime", startTime);
            contentValues.put("endTime", endTime);
            HomeActivity.myDatabase.insertTask(TimetableViewActivity.TABLE_SESION, null, contentValues);

        }
    }



}