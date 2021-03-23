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
    public static MyDatabase myDatabase;
    public static String TABLE_NAME = "tasks";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_view);
        initUI();
        initToolbar();
        myDatabase = new MyDatabase(CalendarViewActivity.this, "manageTask.sqlite", null, 1);
        String sql_create_table = "create table  if not exists tasks(id integer primary key autoincrement, " +
                "title varchar(100), " +
                "type varchar(15), " +
                "location varchar(50), " +
                "time varchar(20), " +
                "note varchar(300), " +
                "remind bit, " +
                "important bit)";
        myDatabase.excuteSQL(sql_create_table);

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
    public static ArrayList<Task> getAllTask() {
        ArrayList<Task> list = new ArrayList<>();
        String sql_select = "SELECT * FROM " + TABLE_NAME;
        Cursor cs = myDatabase.rawQuery(sql_select);
        list.clear();
        while (cs.moveToNext()) {
            int id = cs.getInt(0);
            String title = cs.getString(1);
            String type = cs.getString(2);
            String location = cs.getString(3);
            String time = cs.getString(4);
            String note = cs.getString(5);
            boolean remind = cs.getString(6).equals("0");
            boolean important = cs.getString(7).equals("0");
            Task task = new Task(id, title, type, location, time, note, remind, important);
            list.add(task);
        }
        return list;
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