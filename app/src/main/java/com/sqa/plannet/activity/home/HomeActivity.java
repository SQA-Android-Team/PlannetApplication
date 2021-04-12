package com.sqa.plannet.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.sqa.plannet.R;
import com.sqa.plannet.activity.calendar.CalendarViewActivity;
import com.sqa.plannet.activity.helpAndFeedbacks.HelpAndFeedbacksActivity;
import com.sqa.plannet.activity.overview.OverviewMainActivity;
import com.sqa.plannet.activity.settings.SettingsAboutActivity;
import com.sqa.plannet.activity.settings.SettingsMenuActivity;
import com.sqa.plannet.activity.subject.SubjectViewActivity;
import com.sqa.plannet.activity.teacher.TeacherViewActivity;
import com.sqa.plannet.activity.timetable.TimetableViewActivity;
import com.sqa.plannet.activity.todo.TodoMainActivity;
import com.sqa.plannet.database.MyDatabase;

import static com.sqa.plannet.activity.subject.SubjectViewActivity.TABLE_SUBJECT;
import static com.sqa.plannet.activity.teacher.TeacherViewActivity.TABLE_TEACHER;
import static com.sqa.plannet.activity.timetable.Timetable_SessionDetail.TABLE_SESSION;
import static com.sqa.plannet.activity.todo.TodoMainActivity.TABLE_TASK;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {
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
        initDrawer();

        myDatabase = new MyDatabase(this, "manage_app.sqlite", null, 1);

        String  table_session = "create table if not exists " + TABLE_SESSION +"(sessionID integer primary key autoincrement NOT NULL, " +
                "name varchar(100) NOT NULL, " +
                "des varchar(20), "+
                "sessionLocation varchar(20), " +
                "dateOfWeek varchar(10) NOT NULL, " +
                "startTime varchar(50) NOT NULL, " +
                "endTime varchar(50) NOT NULL, " +
                "color varchar(10))";
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

        String sql_create_table = "create table if not exists " + TABLE_SUBJECT + "(subjectID integer primary key autoincrement, " +
                "subjectTitle varchar(50), " +
                "subjectNote varchar(300), " +
                "subjectCredit integer, " +
                "attendance float, " +
                "midterm float, " +
                "finalTest float)";
        myDatabase.excuteSQL(sql_create_table);

        btnCalendar.setOnClickListener(this);
        btnExitApp.setOnClickListener(this);
        btnOverview.setOnClickListener(this);
        btnTimetable.setOnClickListener(this);
        btnTodo.setOnClickListener(this);

        navigationView.setNavigationItemSelectedListener(this);
    }



    private void mapping() {
        btnTimetable = findViewById(R.id.btnTimetable);
        btnTodo = findViewById(R.id.btnTodo);
        btnOverview = findViewById(R.id.btnOverview);
        btnCalendar = findViewById(R.id.btnCalendar);
        btnExitApp = findViewById(R.id.btnExitApp);
        drawerLayout = findViewById(R.id.homeViewDrawer);
        navigationView = findViewById(R.id.nav_home);
        toolbar = findViewById(R.id.homeToolbar);
    }

    private void initDrawer() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navHome:
                Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
                startActivity(intent);
                break;
            case R.id.navOverview:
                Intent i2 = new Intent(HomeActivity.this, OverviewMainActivity.class);
                startActivity(i2);
                break;
            case R.id.navTodo:
                Intent i3 = new Intent(HomeActivity.this, TodoMainActivity.class);
                startActivity(i3);
                break;
            case R.id.navTimetable:
                Intent i4 = new Intent(HomeActivity.this, TimetableViewActivity.class);
                startActivity(i4);
                break;
            case R.id.navCalendar:
                Intent i5 = new Intent(HomeActivity.this, CalendarViewActivity.class);
                startActivity(i5);
                break;
            case R.id.navSubject:
                Intent i6 = new Intent(HomeActivity.this, SubjectViewActivity.class);
                startActivity(i6);
                break;
            case R.id.navTeacher:
                Intent i7 = new Intent(HomeActivity.this, TeacherViewActivity.class);
                startActivity(i7);
                break;
            case R.id.navSettings:
                Intent i8 = new Intent(HomeActivity.this, SettingsMenuActivity.class);
                startActivity(i8);
                break;
            case R.id.navHelp:
                Intent i9 = new Intent(HomeActivity.this, HelpAndFeedbacksActivity.class);
                startActivity(i9);
                break;
            default:
        }
                return true;
        }
    }
