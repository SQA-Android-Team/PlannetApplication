package com.sqa.plannet.activity.overview;

import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
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
import com.sqa.plannet.R;
import com.sqa.plannet.activity.home.HomeActivity;
import com.sqa.plannet.adapter.overview.PendingEventAdapter;
import com.sqa.plannet.adapter.overview.ScheduleAdapter;
import com.sqa.plannet.model.ScheduleData;
import com.sqa.plannet.model.Task;

import java.util.ArrayList;
import java.util.List;


public class OverviewMainActivity extends AppCompatActivity implements OnChartValueSelectedListener {
    private PieChart mChart;
    RecyclerView recentRecycler;
    ScheduleAdapter scheduleAdapter;
    PendingEventAdapter pendingEventAdapter;
    RecyclerView PendingEvent;
    ArrayList<Task> eventList;

    public static String TABLE_TASK = "tasks";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.overview_view);

        List<ScheduleData> scheduleDataList = new ArrayList<>();
        scheduleDataList.add(new ScheduleData("SE2", "N.T.D.Long", "801C"));
        scheduleDataList.add(new ScheduleData("IWS", "L.T.Trang", "801C"));
        scheduleDataList.add(new ScheduleData("MPR", "N.V.Cong", "801C"));


        setRecentRecycler(scheduleDataList);

        PendingEvent= (RecyclerView)findViewById(R.id.event_recycler);
        PendingEvent.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Task> eventList = new ArrayList<>();
        String sql_select = "SELECT * FROM " + TABLE_TASK ;
        Cursor cs = HomeActivity.myDatabase.rawQuery(sql_select);
        eventList.clear();
        while (cs.moveToNext()) {
            Task ev = new Task(cs.getInt(0),cs.getString(1), cs.getString(2), cs.getString(3),cs.getString(4),cs.getString(5),cs.getString(6),cs.getInt(7),cs.getInt(7));
            eventList.add(ev);

        }
        PendingEventAdapter adapter=new PendingEventAdapter(eventList);
        PendingEvent.setAdapter(adapter);


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

//    private void pendingEventRecycler(List<PendingEventData> pendingEventDataList) {
//
//        pendingEventRecycler = findViewById(R.id.event_recycler);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
//        pendingEventRecycler.setLayoutManager(layoutManager);
//        pendingEventAdapter = new PendingEventAdapter(this, pendingEventDataList);
//        pendingEventRecycler.setAdapter(pendingEventAdapter);
//
//    }

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
