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
import com.sqa.plannet.activity.overview.OverviewMainActivity;
import com.sqa.plannet.activity.timetable.TimetableViewActivity;
import com.sqa.plannet.activity.todo.CreateActivity;
import com.sqa.plannet.activity.todo.TodoMainActivity;
import com.sqa.plannet.database.MyDatabase;

import static com.sqa.plannet.activity.teacher.TeacherViewActivity.TABLE_TEACHER;
import static com.sqa.plannet.activity.timetable.Timetable_SessionDetail.TABLE_SESSION;
import static com.sqa.plannet.activity.todo.TodoMainActivity.TABLE_TASK;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnTimetable, btnTodo, btnOverview, btnCalendar;
    private ImageButton btnExitApp;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    public static MyDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_view);
        mapping();

        myDatabase = new MyDatabase(this, "manage_app.sqlite", null, 1);
        String table_session = "create table  if not exists " + TABLE_SESSION +"(id integer primary key autoincrement NOT NULL, " +
                "title varchar(100) NOT NULL, " +
                "type varchar(15) NOT NULL, " +
                "location varchar(50) NOT NULL, " +
                "timeStart varchar(20) NOT NULL, " +
                "timeEnd varchar(20), " +
                "day varchar(10))";
        myDatabase.excuteSQL(table_session);

        String table_todo = "create table if not exists " + TABLE_TASK + "(id integer primary key autoincrement NOT NULL, " +
                "title varchar(100) NOT NULL, " +
                "type varchar(15) NOT NULL, " +
                "location varchar(50) NOT NULL, " +
                "time varchar(20) NOT NULL, " +
                "date varchar(20) NOT NULL, " +
                "note varchar(300), " +
                "remind integer, " +
                "important integer)";
        myDatabase.excuteSQL(table_todo);

        String table_teacher = "create table if not exists " + TABLE_TEACHER + "(teacherID integer primary key autoincrement," +
                "teacherName varchar(50), " +
                "phone varchar(15), " +
                "email varchar(50))";
        myDatabase.excuteSQL(table_teacher);

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
                Intent i = new Intent(HomeActivity.this, OverviewMainActivity.class);
                startActivity(i);
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