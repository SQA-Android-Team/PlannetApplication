package com.sqa.plannet.activity.todo;

import android.content.Intent;;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sqa.plannet.R;
import com.sqa.plannet.activity.todo.TodoMainActivity;
import com.sqa.plannet.model.Task;

import java.util.List;

public class DetailActivity extends AppCompatActivity  {
    ImageButton btnBack;
    TextView titledoes, txtvType, txtvimportant,txtvTime, txtvLocation, txtvNote, txtvRemind, txtvNotRemind ;

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
        txtvNotRemind = findViewById(R.id.txtvNotRemind);
    }

    private  void loadData(){
        List<Task> list = TodoMainActivity.getAllTask();
        titledoes.setText( "Title: " +list.get(0).getTitle());
        txtvType.setText("" +list.get(0).getType()+ "");
        txtvTime.setText("Time: " +list.get(0).getTime()+ "");
        txtvLocation.setText("Location: " +list.get(0).getLocation()+ "");
        txtvimportant.setText("Important: " +list.get(0).isImportant()+ "");
        txtvRemind.setText("Remind: " +list.get(0).isRemind() + "");
        txtvNote.setText("" +list.get(0).getNote()+ "");
    }
}
