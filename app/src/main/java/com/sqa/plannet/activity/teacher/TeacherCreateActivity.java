package com.sqa.plannet.activity.teacher;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.sqa.plannet.R;

public class TeacherCreateActivity extends AppCompatActivity {

    ImageButton backBtn;
    Button addBtn;
    TextView teacherNameTxv;
    TextView teacherPhoneTxv;
    TextView teacherEmailTxv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_create);

        initUI();
        onBackBtnClick();
        onAddBtnClick();




    }


    /**
     * TODO: initialise all necessary UI elements
     */
    private void initUI(){
        backBtn = findViewById(R.id.backBtn);
        addBtn = findViewById(R.id.addBtn);
        teacherNameTxv = findViewById(R.id.teacherNameTxv);
        teacherPhoneTxv = findViewById(R.id.teacherPhoneTxv);
        teacherEmailTxv = findViewById(R.id.teacherEmailTxv);
    }

    /**
     * TODO: add event listener for back button
     */
    private void onBackBtnClick(){
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    /**
     * TODO: add event listener for add button
     */
    private void onAddBtnClick(){
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {






                finish();
            }
        });
    }
}