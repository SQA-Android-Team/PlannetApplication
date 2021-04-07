package com.sqa.plannet.activity.timetable;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.navigation.NavigationView;
import com.sqa.plannet.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimetableAddSession extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private TextView txtStartTimePicker, txtEndTimePicker, txtDateOfWeekPicker;
    private AppBarLayout appBarLayout;
    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Spinner spDateOfWeekPicker;
    private ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timetable_add_session);
        mapping();
        initUI();
        initToolbar();


        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Add Class");
        drawerLayout.bringToFront();



        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.dateOfWeek, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDateOfWeekPicker.setAdapter(adapter);
        spDateOfWeekPicker.setOnItemSelectedListener(this);



        txtStartTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeStartPicker();
            }
        });


        txtEndTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeEndPicker();
            }
        });
    }

    private void mapping() {
        spDateOfWeekPicker = findViewById(R.id.spDateOfWeekPicker);
        drawerLayout = findViewById(R.id.addClassViewDrawer);
        toolbar = findViewById(R.id.addClassViewToolbar);
        navigationView = findViewById(R.id.navView);
        txtStartTimePicker = findViewById(R.id.txtStartTimePicker);
        txtEndTimePicker = findViewById(R.id.txtEndTimePicker);
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
        Toast.makeText(parent.getContext(),text, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onNothingSelected (AdapterView < ? > parent){

        }


    public void onBackBtnClick(View view) {
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}