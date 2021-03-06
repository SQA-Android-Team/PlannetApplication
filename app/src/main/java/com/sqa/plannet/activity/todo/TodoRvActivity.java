package com.sqa.plannet.activity.todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sqa.plannet.R;
import com.sqa.plannet.adapter.teacher.TeacherAdapter;
import com.sqa.plannet.adapter.todo.TodoRvAdapter;
import com.sqa.plannet.adapter.todo.TodoTaskAdapter;
import com.sqa.plannet.model.Task;

import java.util.ArrayList;
import java.util.List;

import static com.sqa.plannet.activity.home.HomeActivity.myDatabase;

public class TodoRvActivity extends AppCompatActivity {
    RecyclerView lstTask;
    Button btnNew;
    public static List<Task> listTask ;
    TodoRvAdapter adapter;
    public static String TABLE_TASK = "tasks" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo_activity_main);
        mapping();
        initRecyclerView();

    }

    private void mapping() {
        btnNew = findViewById(R.id.btnNew);
        lstTask = findViewById(R.id.tasksRecyclerView);
    }

    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnNew :
                Intent intent = new Intent(TodoRvActivity.this, CreateActivity.class);
                startActivity(intent);
                break;
            default:
        }
    }

    private void initRecyclerView() {
        lstTask.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        lstTask.setLayoutManager(linearLayoutManager);

        adapter = new TodoRvAdapter();
        adapter.setData(getAllTask());
        lstTask.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public static List<Task> getAllTask() {
        listTask = new ArrayList<>();
        String sql_select = "SELECT * FROM " + TABLE_TASK ;
        Cursor cs = myDatabase.rawQuery(sql_select);
        listTask.clear();
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
            listTask.add(task);
        }
        return listTask;
    }
}