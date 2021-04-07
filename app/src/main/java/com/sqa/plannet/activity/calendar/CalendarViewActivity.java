package com.sqa.plannet.activity.calendar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.sqa.plannet.R;
import com.sqa.plannet.activity.todo.TodoMainActivity;
import com.sqa.plannet.adapter.calendar.SessionAdapter;
import com.sqa.plannet.adapter.calendar.TaskAdapter;
import com.sqa.plannet.adapter.todo.TodoTaskAdapter;
import com.sqa.plannet.database.MyDatabase;
import com.sqa.plannet.model.Session;
import com.sqa.plannet.model.Task;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static com.sqa.plannet.activity.todo.TodoMainActivity.getAllTask;

public class CalendarViewActivity extends AppCompatActivity {
    private AppBarLayout appBarLayout;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Toolbar toolbar;
    private FloatingActionButton fab;
    private RecyclerView recyclerView;
    public RecyclerView.Adapter EventsAdapter;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    public ListView rvTodayEvent;
    private ListView rvReminders;
    public String selectedDate;


    private CalendarView calendarView;

    ArrayList<Task> listTask = new ArrayList<>();
    TaskAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_view);


        initUI();
        initToolbar();
        drawerLayout = findViewById(R.id.subjectViewDrawer);
        toolbar = findViewById(R.id.subjectViewToolbar);
        navigationView = findViewById(R.id.navView);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.calendar_header);
        drawerLayout.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // chose the date
        calendarView = (CalendarView) findViewById(R.id.calendarView);

        final Context context = this;
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {


            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                Calendar calendar = Calendar.getInstance();
                selectedDate = dayOfMonth +"/" +( month +1) +"/"+ year;
            }
        });

        listTask = getAllTask();
        adapter = new TaskAdapter(CalendarViewActivity.this, R.layout.calendar_view, listTask);
        rvTodayEvent.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void initUI(){
        appBarLayout = findViewById(R.id.appBarLayout);
        collapsingToolbarLayout = findViewById(R.id.colToolbar);
        toolbar = findViewById(R.id.subjectViewToolbar);
    }


    private void initToolbar(){
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            //recycle view
            rvTodayEvent = findViewById(R.id.rvTodayEvent);
            rvReminders = findViewById(R.id.rvReminders);
        }

    }








}