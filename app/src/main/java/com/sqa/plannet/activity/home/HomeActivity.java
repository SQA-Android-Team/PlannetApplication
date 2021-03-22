package com.sqa.plannet.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.sqa.plannet.R;
import com.sqa.plannet.activity.calendar.CalendarViewActivity;
import com.sqa.plannet.activity.timetable.TimetableViewActivity;
import com.sqa.plannet.activity.todo.CreateActivity;
import com.sqa.plannet.activity.todo.TodoMainActivity;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnTimetable, btnTodo, btnOverview, btnCalendar;
    private ImageButton btnExitApp;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_view);
        mapping();

        btnCalendar.setOnClickListener(this);
        btnExitApp.setOnClickListener(this);
        btnOverview.setOnClickListener(this);
        btnTimetable.setOnClickListener(this);
        btnTodo.setOnClickListener(this);

    }

    private void mapping() {
        btnTimetable = findViewById(R.id.btnTimetable);
        btnTodo = findViewById(R.id.btnTodo);
        btnOverview = findViewById(R.id.btnOverview);
        btnCalendar = findViewById(R.id.btnCalendar);
        btnExitApp = findViewById(R.id.btnExitApp);
        drawerLayout = findViewById(R.id.homeViewDrawer);
        navigationView = findViewById(R.id.navView);
        toolbar = findViewById(R.id.toolbar);
    }

    private void initDrawer(){
        setSupportActionBar(toolbar);
        drawerLayout.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnTimetable:
                startActivity(new Intent(HomeActivity.this, TimetableViewActivity.class));
                break;
            case R.id.btnTodo:
                Intent intent = new Intent(HomeActivity.this, TodoMainActivity.class);
                startActivity(intent);
                break;
            case R.id.btnOverview:
                break;
            case R.id.btnCalendar:
                startActivity(new Intent(HomeActivity.this, CalendarViewActivity.class));
                break;
            case R.id.btnExitApp:
                finish();
                System.exit(0);
                break;
            default:
        }
    }
}