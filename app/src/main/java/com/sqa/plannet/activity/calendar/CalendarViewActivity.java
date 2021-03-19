package com.sqa.plannet.activity.calendar;

import android.content.Context;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

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
import com.sqa.plannet.adapter.calendar.SessionAdapter;
import com.sqa.plannet.adapter.calendar.TaskAdapter;
import com.sqa.plannet.model.Session;
import com.sqa.plannet.model.Task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class CalendarViewActivity extends AppCompatActivity {
    private AppBarLayout appBarLayout;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Toolbar toolbar;
    private FloatingActionButton fab;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter EventsAdapter;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private RecyclerView rvTodayEvent;
    private RecyclerView rvReminders;
    public String selectedDate;

    private CalendarView calendarView;
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
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        final Context context = this;
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {


            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                Calendar calendar = Calendar.getInstance();
                selectedDate = dayOfMonth +"/" +( month +1) +"/"+ year;

//                try {
//                    Date date = simpleDateFormat.parse(selectedDate);
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//
////
////               if(chDate.after(events.))
//                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
//
//                Toast.makeText(context, "" + selectedDate, Toast.LENGTH_LONG ).show();
//
//
//
//
//                //recycle view
//                rvTodayEvent= findViewById(R.id.rvTodayEvent);
//                rvReminders = findViewById(R.id.rvReminders);
                
            }
        });



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
            rvTodayEvent= findViewById(R.id.rvTodayEvent);
            rvReminders = findViewById(R.id.rvReminders);

            //demo data
            List<Session> classes = new ArrayList<>();
            //TODO: thêm constructor cho session + sửa list bên dưới

           classes.add(new Session(1,3,5,"MPR", "10:00","12:00", "23/08/1993","Mon", "801C", "Lecture"));
            classes.add(new Session(1,3,5,"SQA", "10:00","12:00", "23/08/1993","Mon", "801C", "Lecture"));
            classes.add(new Session(1,3,5,"SE2", "10:00","12:00", "23/08/1993","Mon", "801C", "Lecture"));
            // setup recycle view
            // adapter
            SessionAdapter sessionAdapter = new SessionAdapter(classes);
            rvReminders.setAdapter(sessionAdapter);
            //layout manager
            rvReminders.setLayoutManager(new LinearLayoutManager(this));



            // demo data
            List<Task> events = new ArrayList<>();
            //TODO: thêm constructor cho task + sửa list bên dưới

            events.add(new Task(1,"NHCam","20/8/2000","abc", "Homework"));
            events.add(new Task(2,"Seo Hyerin","23/8/1993","Idle", "Project"));
            events.add(new Task(4,"Nothing","23/8/1993","OMG", "Assignment"));


            // setup recycle view
            // adapter
            TaskAdapter taskAdapter;
            taskAdapter = new TaskAdapter(events);
            rvTodayEvent.setAdapter(taskAdapter);
            //layout manager
            rvTodayEvent.setLayoutManager(new LinearLayoutManager(this));



        }

    }








}