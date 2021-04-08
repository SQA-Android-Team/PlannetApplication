package com.sqa.plannet.activity.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.sqa.plannet.R;
import com.sqa.plannet.adapter.todo.TodoTaskAdapter;
import com.sqa.plannet.database.MyDatabase;
import com.sqa.plannet.model.Task;

import java.util.ArrayList;

import static com.sqa.plannet.activity.calendar.CalendarViewActivity.selectedDate;
import static com.sqa.plannet.activity.home.HomeActivity.myDatabase;

public class TodoMainActivity<TABLE_TASK> extends AppCompatActivity implements View.OnClickListener {
    ListView lstTask;
    Button btnNew;
    ArrayList<Task> listTask = new ArrayList<>();
    TodoTaskAdapter adapter;
    public static String TABLE_TASK = "tasks" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo_activity_main);
        mapping();

        listTask = getAllTask();
        adapter = new TodoTaskAdapter(TodoMainActivity.this, R.layout.calendar_todayevent, listTask);
        lstTask.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        btnNew.setOnClickListener(this);
    }

    private void mapping() {
        btnNew = findViewById(R.id.btnNew);
        lstTask = findViewById(R.id.lstTask);
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
            int important = cs.getInt(7);
            Task task = new Task(id, title, type, location, time, date, note, remind, important);
            list.add(task);
        }
        return list;
    }
//    public static ArrayList<Task> getTaskByDate() {
//        ArrayList<Task> list = new ArrayList<>();
//        String sql_select_taskbydate = "SELECT * FROM " + TABLE_TASK + "WHERE date ="+ selectedDate ;
//        Cursor cs = myDatabase.rawQuery(sql_select_taskbydate);
//        list.clear();
//        while (cs.moveToNext()) {
//            int id = cs.getInt(0);
//            String title = cs.getString(1);
//            String type = cs.getString(2);
//            String location = cs.getString(3);
//            String time = cs.getString(4);
//            String date = cs.getString(5);
//            String note = cs.getString(6);
//            int remind = cs.getInt(7);
//            int important = cs.getInt(7);
//            Task task = new Task(id, title, type, location, time, date, note, remind, important);
//            list.add(task);
//        }
//        return list;
//    }


}


