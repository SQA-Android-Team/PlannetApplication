package com.sqa.plannet.activity.teacher;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sqa.plannet.R;
import com.sqa.plannet.model.Teacher;

public class TeacherCreateActivity extends AppCompatActivity {

    ImageButton backBtn;
    Button addBtn;
    TextView teacherNameEdt;
    TextView teacherPhoneEdt;
    TextView teacherEmailEdt;

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
        teacherNameEdt= findViewById(R.id.teacherNameEdt);
        teacherPhoneEdt= findViewById(R.id.teacherPhoneEdt);
        teacherEmailEdt = findViewById(R.id.teacherEmailEdt);
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

                String teacherName = teacherNameEdt.getText().toString();
                String teacherPhone = teacherPhoneEdt.getText().toString();
                String teacherEmail = teacherEmailEdt.getText().toString();

                if (teacherName == null){
                    Toast.makeText(TeacherCreateActivity.this, "Invalid name", Toast.LENGTH_SHORT).show();
                    return;
                }

                Teacher teacher = new Teacher(teacherName, teacherPhone, teacherEmail);


                //TODO: incomplete






                finish();
            }
        });
    }
}