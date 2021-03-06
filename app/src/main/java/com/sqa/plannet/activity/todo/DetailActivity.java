package com.sqa.plannet.activity.todo;

import android.content.Intent;;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sqa.plannet.R;
import com.sqa.plannet.activity.calendar.CalendarViewActivity;
import com.sqa.plannet.activity.todo.TodoMainActivity;
import com.sqa.plannet.model.Task;

import java.util.List;

public class DetailActivity extends AppCompatActivity  {
    ImageButton btnBack;
    TextView titledoes, txtvType, txtvimportant, txtvTime, txtvLocation, txtvNote, txtvRemind, txtvDate ;
    Task t;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.to_detail_task);
        mapping();
        loadData();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, TodoMainActivity.class);
                startActivity(intent);
            }
        });


    }

    private void mapping() {
        btnBack = findViewById(R.id.btnBack);
        titledoes = findViewById(R.id.titledoes);
        txtvType = findViewById(R.id.txtvType);
        txtvimportant = findViewById(R.id.txtvimportant);
        txtvTime = findViewById(R.id.txtvTime);
        txtvLocation = findViewById(R.id.txtvLocation);
        txtvNote = findViewById(R.id.txtvNote);
        txtvRemind = findViewById(R.id.txtvRemind);
        txtvDate = findViewById(R.id.txtvDate);
    }

    private  void loadData(){
        Intent intent = getIntent();
        t = (Task) intent.getSerializableExtra("Tasks");
        titledoes.setText("Title : " + t.getTitle());
        txtvType.setText("" + t.getType());
        txtvTime.setText("Time : " + t.getTime());
        txtvDate.setText("Date : " + t.getDate());
        txtvLocation.setText("Location : " + t.getLocation());
        txtvNote.setText("" + t.getNote());
        txtvRemind.setText("" + t.getRemind());
        //xtvimportant.setText("" + t.getLocation());

        int important = t.getImportant();
        if (important == 1){
            txtvimportant.setVisibility(View.VISIBLE);
        }else {
            txtvimportant.setVisibility(View.INVISIBLE);

            String Trang = txtvType.getText().toString();
            if (Trang.equals("Homework")) {
                txtvType.setBackgroundResource(R.drawable.btn_button_blue);
            }else if(Trang.equals("Fun")){
                txtvType.setBackgroundResource(R.drawable.btn_button_green);
            }else if(Trang.equals("School")){
                txtvType.setBackgroundResource(R.drawable.btn_button_orange);
            }else if(Trang.equals("Others")){
                txtvType.setBackgroundResource(R.drawable.btn_button_purple);
            }
        }
    }
}
