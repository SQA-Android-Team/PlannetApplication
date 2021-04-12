package com.sqa.plannet.activity.overview;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.google.android.material.navigation.NavigationView;
import com.sqa.plannet.R;
import com.sqa.plannet.activity.calendar.CalendarViewActivity;
import com.sqa.plannet.activity.helpAndFeedbacks.HelpAndFeedbacksActivity;
import com.sqa.plannet.activity.home.HomeActivity;
import com.sqa.plannet.activity.settings.SettingsMenuActivity;
import com.sqa.plannet.activity.subject.SubjectViewActivity;
import com.sqa.plannet.activity.teacher.TeacherViewActivity;
import com.sqa.plannet.activity.timetable.TimetableViewActivity;
import com.sqa.plannet.activity.todo.TodoMainActivity;
import com.sqa.plannet.adapter.overview.PendingEventAdapter;
import com.sqa.plannet.adapter.overview.ScheduleAdapter;
import com.sqa.plannet.model.ScheduleData;
import com.sqa.plannet.model.Session;
import com.sqa.plannet.model.Task;

import java.util.ArrayList;
import java.util.List;


public class OverviewMainActivity extends AppCompatActivity implements OnChartValueSelectedListener, NavigationView.OnNavigationItemSelectedListener  {
    private PieChart mChart;
    RecyclerView resentSession;

    RecyclerView pendingEvent;
    ArrayList<Task> eventList;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    public static String TABLE_TASK = "tasks";
    public static String TABLE_SESSION = "sessions";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.overview_view);
        mapping();
        initDrawer();

        resentSession = (RecyclerView) findViewById((R.id.recent_recycler)) ;
        resentSession.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Session> listSession = new ArrayList<>();
        String select_sess = "SELECT * FROM " + TABLE_SESSION;
        Cursor cursor = HomeActivity.myDatabase.rawQuery(select_sess);
        listSession.clear();
        while (cursor.moveToNext()){
            Session sess = new Session(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7));

            listSession.add(sess);
        }
        ScheduleAdapter scheduleAdapter = new ScheduleAdapter(listSession);
        resentSession.setAdapter(scheduleAdapter);

        pendingEvent= (RecyclerView)findViewById(R.id.event_recycler);
        pendingEvent.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Task> eventList = new ArrayList<>();
        String sql_select = "SELECT * FROM " + TABLE_TASK ;
        Cursor cs = HomeActivity.myDatabase.rawQuery(sql_select);
        eventList.clear();
        while (cs.moveToNext()) {
            Task ev = new Task(
                    cs.getInt(0),
                    cs.getString(1),
                    cs.getString(2),
                    cs.getString(3),
                    cs.getString(4),
                    cs.getString(5),
                    cs.getString(6),
                    cs.getInt(7),
                    cs.getInt(8));
            eventList.add(ev);

        }
        PendingEventAdapter adapter=new PendingEventAdapter(eventList);
        pendingEvent.setAdapter(adapter);


        mChart = (PieChart) findViewById(R.id.piechart);
        mChart.setRotationEnabled(true);
        mChart.setHoleRadius(85f);
        mChart.setCenterTextSize(50);
        mChart.setDrawEntryLabels(false);
        mChart.setCenterText("85%");
        mChart.setCenterTextColor(Color.parseColor("#A680EA"));

        addDataSet(mChart);

        mChart.setOnChartValueSelectedListener(this);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void mapping() {
        drawerLayout = findViewById(R.id.homeViewDrawer);
        navigationView = findViewById(R.id.nav_home);
        toolbar = findViewById(R.id.homeToolbar);
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {
        Toast.makeText(this, "Value: "
                + e.getY()
                + ", index: "
                + h.getX()
                + ", DataSet index: "
                + h.getDataSetIndex(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected() {

    }

    private static void addDataSet(PieChart pieChart) {
        ArrayList<PieEntry> yEntrys = new ArrayList<>();
        ArrayList<String> xEntrys = new ArrayList<>();
        float[] yData = { 85,15 };
        String[] xData = { "done", "doing" };


        for (int i = 0; i < yData.length;i++){
            yEntrys.add(new PieEntry(yData[i],i));
        }
        for (int i = 0; i < xData.length;i++){
            xEntrys.add(xData[i]);
        }

        PieDataSet pieDataSet=new PieDataSet(yEntrys,"Weekly Progress");
        pieDataSet.setSliceSpace(2);


        ArrayList<Integer> colors=new ArrayList<>();
        colors.add(R.color.gradient);
        colors.add(R.color.White_smoke);


        pieDataSet.setColors(new int[]{Color.parseColor("#A680EA"),
                Color.parseColor("#F595B8")});


        Legend legend=pieChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);

        PieData pieData=new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();
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

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navHome:
                Intent intent = new Intent(OverviewMainActivity.this, HomeActivity.class);
                startActivity(intent);
                break;
            case R.id.navOverview:
                Intent i2 = new Intent(OverviewMainActivity.this, OverviewMainActivity.class);
                startActivity(i2);
                break;
            case R.id.navTodo:
                Intent i3 = new Intent(OverviewMainActivity.this, TodoMainActivity.class);
                startActivity(i3);
                break;
            case R.id.navTimetable:
                Intent i4 = new Intent(OverviewMainActivity.this, TimetableViewActivity.class);
                startActivity(i4);
                break;
            case R.id.navCalendar:
                Intent i5 = new Intent(OverviewMainActivity.this, CalendarViewActivity.class);
                startActivity(i5);
                break;
            case R.id.navSubject:
                Intent i6 = new Intent(OverviewMainActivity.this, SubjectViewActivity.class);
                startActivity(i6);
                break;
            case R.id.navTeacher:
                Intent i7 = new Intent(OverviewMainActivity.this, TeacherViewActivity.class);
                startActivity(i7);
                break;
            case R.id.navSettings:
                Intent i8 = new Intent(OverviewMainActivity.this, SettingsMenuActivity.class);
                startActivity(i8);
                break;
            case R.id.navHelp:
                Intent i9 = new Intent(OverviewMainActivity.this, HelpAndFeedbacksActivity.class);
                startActivity(i9);
                break;
            default:
        }
        return true;
    }
}
