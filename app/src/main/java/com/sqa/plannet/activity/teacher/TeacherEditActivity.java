package com.sqa.plannet.activity.teacher;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.sqa.plannet.R;
import com.sqa.plannet.model.Subject;
import com.sqa.plannet.model.Teacher;

public class TeacherEditActivity extends AppCompatActivity {

    private ImageButton backBtn;
    private Button editBtn;
    private EditText teacherNameEdt;
    private EditText teacherPhoneEdt;
    private EditText teacherEmailEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_edit);

        initUI();
        onBackBtnClick();
        onEditBtnClick();


    }

    /**
     * TODO: initialise all necessary UI elements
     */
    private void initUI(){
        backBtn = findViewById(R.id.backBtn);
        editBtn = findViewById(R.id.addBtn);
        teacherNameEdt = findViewById(R.id.teacherNameEdt);
        teacherPhoneEdt = findViewById(R.id.teacherPhoneEdt);
        teacherEmailEdt = findViewById(R.id.teacherEmailEdt);
    }

    /**
     * TODO: set text to all fields
     * INCOMPLETE
     */
    private void setEdtText(Teacher teacher){
        teacherNameEdt.setText(teacher.getTeacherName());
        teacherPhoneEdt.setText(teacher.getPhone());
        teacherEmailEdt.setText(teacher.getEmail());

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
     * TODO: add event listener for edit button INCOMPLETE
     *
     */
    private void onEditBtnClick(){
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {






                finish();
            }
        });
    }
}