package com.sqa.plannet.activity.overview;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.sqa.plannet.R;
import com.sqa.plannet.activity.teacher.TeacherViewActivity;
import com.sqa.plannet.activity.timetable.Timetable_SessionDetail;
import com.sqa.plannet.activity.todo.TodoMainActivity;
import com.sqa.plannet.adapter.overview.PendingEventAdapter;
import com.sqa.plannet.adapter.overview.ScheduleAdapter;
import com.sqa.plannet.database.MyDatabase;
import com.sqa.plannet.model.PendingEventData;
import com.sqa.plannet.model.ScheduleData;

import java.util.ArrayList;
import java.util.List;


public class OverviewMainActivity extends AppCompatActivity implements OnChartValueSelectedListener {
    private PieChart mChart;
    RecyclerView recentRecycler, pendingEventRecycler;
    ScheduleAdapter scheduleAdapter;
    PendingEventAdapter pendingEventAdapter;
    public static MyDatabase myDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.overview_view);

        myDatabase = new MyDatabase(OverviewMainActivity.this, "manage_app.sqlite", null, 1);
        String table_session = "create table  if not exists sessions(id integer primary key autoincrement NOT NULL, " +
                "title varchar(100) NOT NULL, " +
                "type varchar(15) NOT NULL, " +
                "location varchar(50) NOT NULL, " +
                "timeStart varchar(20) NOT NULL, " +
                "timeEnd varchar(20), " +
                "day varchar(10))";
        myDatabase.excuteSQL(table_session);

        String table_todo = "create table if not exists tasks(id integer primary key autoincrement NOT NULL, " +
                "title varchar(100) NOT NULL, " +
                "type varchar(15) NOT NULL, " +
                "location varchar(50) NOT NULL, " +
                "time varchar(20) NOT NULL, " +
                "date varchar(20) NOT NULL, " +
                "note varchar(300), " +
                "remind integer, " +
                "important integer)";
        myDatabase.excuteSQL(table_todo);

        String table_teacher = "create table if not exists teachers(teacherID integer primary key autoincrement," +
                "teacherName varchar(50), " +
                "phone varchar(15), " +
                "email varchar(50))";
        myDatabase.excuteSQL(table_teacher);

        List<ScheduleData> scheduleDataList = new ArrayList<>();
        scheduleDataList.add(new ScheduleData("SE2", "N.T.D.Long", "801C"));
        scheduleDataList.add(new ScheduleData("IWS", "L.T.Trang", "801C"));
        scheduleDataList.add(new ScheduleData("MPR", "N.V.Cong", "801C"));


        setRecentRecycler(scheduleDataList);

        List<PendingEventData> pendingEventDataList = new ArrayList<>();
        pendingEventDataList.add(new PendingEventData("12", "Mar", "IWS Assigment 1"));
        pendingEventDataList.add(new PendingEventData("13", "Apr", "Midterm SE2"));
        pendingEventDataList.add(new PendingEventData("14", "May", "Presentation SQA"));

        pendingEventRecycler(pendingEventDataList);

        mChart = (PieChart) findViewById(R.id.piechart);
        mChart.setRotationEnabled(true);
        mChart.setHoleRadius(85f);
        mChart.setCenterTextSize(50);
        mChart.setDrawEntryLabels(false);
        mChart.setCenterText("85%");
        mChart.setCenterTextColor(Color.parseColor("#A680EA"));

        addDataSet(mChart);

        mChart.setOnChartValueSelectedListener(this);
    }
    private void setRecentRecycler(List<ScheduleData> scheduleDataList) {

        recentRecycler = findViewById(R.id.recent_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recentRecycler.setLayoutManager(layoutManager);
        scheduleAdapter = new ScheduleAdapter(this, scheduleDataList);
        recentRecycler.setAdapter(scheduleAdapter);

    }

    private void pendingEventRecycler(List<PendingEventData> pendingEventDataList) {

        pendingEventRecycler = findViewById(R.id.event_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        pendingEventRecycler.setLayoutManager(layoutManager);
        pendingEventAdapter = new PendingEventAdapter(this, pendingEventDataList);
        pendingEventRecycler.setAdapter(pendingEventAdapter);

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

}
