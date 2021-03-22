package com.sqa.plannet.activity.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.sqa.plannet.R;
import com.sqa.plannet.adapter.todo.TodoTaskAdapter;
import com.sqa.plannet.database.MyDatabase;
import com.sqa.plannet.model.Task;

import java.util.ArrayList;

public class TodoMainActivity extends AppCompatActivity implements View.OnClickListener {
    ListView lstTask;
    Button btnNew;
    public static MyDatabase myDatabase;
    public static String TABLE_NAME = "tasks";
    ArrayList<Task> listTask = new ArrayList<>();
    TodoTaskAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getSupportActionBar().hide();
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.todo_activity_main);
        mapping();

        //addControls();

        myDatabase = new MyDatabase(TodoMainActivity.this, "manageTask.sqlite", null, 1);
        String sql_create_table = "create table  if not exists tasks(id integer primary key autoincrement, " +
                "title varchar(100), " +
                "type varchar(15), " +
                "location varchar(50), " +
                "time varchar(20), " +
                "note varchar(300), " +
                "remind bit, " +
                "important bit)";
        myDatabase.excuteSQL(sql_create_table);
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", "7");
        contentValues.put("title", "readbook");
        contentValues.put("type", "funny");
        contentValues.put("location", "library");
        contentValues.put("time", "13:00");
        contentValues.put("note", "hihihi i love reading book");
        contentValues.put("remind", true);
        contentValues.put("important", true);

        listTask = getAllTask();

        adapter = new TodoTaskAdapter(TodoMainActivity.this, R.layout.todo_item_does, listTask);
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


}


