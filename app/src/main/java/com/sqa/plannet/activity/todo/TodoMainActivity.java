package com.sqa.plannet.activity.todo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.sqa.plannet.R;
import com.sqa.plannet.activity.calendar.CalendarViewActivity;
import com.sqa.plannet.activity.helpAndFeedbacks.HelpAndFeedbacksActivity;
import com.sqa.plannet.activity.home.HomeActivity;
import com.sqa.plannet.activity.overview.OverviewMainActivity;
import com.sqa.plannet.activity.settings.SettingsMenuActivity;
import com.sqa.plannet.activity.subject.SubjectViewActivity;
import com.sqa.plannet.activity.teacher.TeacherViewActivity;
import com.sqa.plannet.activity.timetable.TimetableViewActivity;
import com.sqa.plannet.adapter.todo.TodoTaskAdapter;
import com.sqa.plannet.database.MyDatabase;
import com.sqa.plannet.model.Task;

import java.util.ArrayList;

import static com.sqa.plannet.activity.calendar.CalendarViewActivity.selectedDate;
import static com.sqa.plannet.activity.home.HomeActivity.myDatabase;

public class TodoMainActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {
    ListView lstTask;
    Button btnNew;
    ArrayList<Task> listTask = new ArrayList<>();
    TodoTaskAdapter adapter;
    public static String TABLE_TASK = "tasks" ;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo_activity_main);
        mapping();
        initDrawer();

        listTask = getAllTask();
        adapter = new TodoTaskAdapter(TodoMainActivity.this, R.layout.todo_item_does, listTask);
        lstTask.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        btnNew.setOnClickListener(this);

        lstTask.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TodoMainActivity.this, DetailActivity.class);
                intent.putExtra("Tasks", listTask.get(position));
                startActivity(intent);
            }
        });

        navigationView.setNavigationItemSelectedListener(this::onNavigationItemSelected);
    }

    private void mapping() {
        btnNew = findViewById(R.id.btnNew);
        lstTask = findViewById(R.id.lstTask);
        drawerLayout = findViewById(R.id.homeViewDrawer);
        navigationView = findViewById(R.id.nav_home);
        toolbar = findViewById(R.id.homeToolbar);
    }
    private void initDrawer(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

    }



    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnNew :
                Intent intent = new Intent(TodoMainActivity.this, CreateActivity.class);
                startActivity(intent);
                break;
            default:
        }
    }

    public static ArrayList<Task> getAllTask() {
        ArrayList<Task> list = new ArrayList<>();
        String sql_select = "SELECT * FROM " + TABLE_TASK ;
        Cursor cs = myDatabase.rawQuery(sql_select);
        list.clear();
        while (cs.moveToNext()) {
            int id = cs.getInt(0);
            String title = cs.getString(1);
            String type = cs.getString(2);
            String location = cs.getString(3);
            String time = cs.getString(4);
            String date = cs.getString(5);
            String note = cs.getString(6);
            int remind = cs.getInt(7);
            int important = cs.getInt(8);
            Task task = new Task(id, title, type, location, time, date, note, remind, important);
            list.add(task);
        }
        return list;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navHome:
                Intent intent = new Intent(TodoMainActivity.this, HomeActivity.class);
                startActivity(intent);
                break;
            case R.id.navOverview:
                Intent i2 = new Intent(TodoMainActivity.this, OverviewMainActivity.class);
                startActivity(i2);
                break;
            case R.id.navTodo:
                Intent i3 = new Intent(TodoMainActivity.this, TodoMainActivity.class);
                startActivity(i3);
                break;
            case R.id.navTimetable:
                Intent i4 = new Intent(TodoMainActivity.this, TimetableViewActivity.class);
                startActivity(i4);
                break;
            case R.id.navCalendar:
                Intent i5 = new Intent(TodoMainActivity.this, CalendarViewActivity.class);
                startActivity(i5);
                break;
            case R.id.navSubject:
                Intent i6 = new Intent(TodoMainActivity.this, SubjectViewActivity.class);
                startActivity(i6);
                break;
            case R.id.navTeacher:
                Intent i7 = new Intent(TodoMainActivity.this, TeacherViewActivity.class);
                startActivity(i7);
                break;
            case R.id.navSettings:
                Intent i8 = new Intent(TodoMainActivity.this, SettingsMenuActivity.class);
                startActivity(i8);
                break;
            case R.id.navHelp:
                Intent i9 = new Intent(TodoMainActivity.this, HelpAndFeedbacksActivity.class);
                startActivity(i9);
                break;
            default:
        }
        return true;
    }

}


