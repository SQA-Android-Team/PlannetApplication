package com.sqa.plannet.activity.teacher;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sqa.plannet.R;
import com.sqa.plannet.activity.home.HomeActivity;
import com.sqa.plannet.model.Subject;
import com.sqa.plannet.model.Teacher;

public class TeacherEditActivity extends AppCompatActivity implements  View.OnClickListener{

    private ImageButton backBtn;
    private Button editBtn;
    private EditText teacherNameEdt;
    private EditText teacherPhoneEdt;
    private EditText teacherEmailEdt;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_edit);


        Intent intent = getIntent();
        position =(int) intent.getExtras().get("position");
        initUI();
        loadData();
        backBtn.setOnClickListener(this);
        editBtn.setOnClickListener(this);



    }

    /**
     * TODO: initialise all necessary UI elements
     */
    private void initUI() {
        backBtn = findViewById(R.id.backBtn);
        editBtn = findViewById(R.id.editTeacherBtn);
        teacherNameEdt = findViewById(R.id.teacherNameEdt);
        teacherPhoneEdt = findViewById(R.id.teacherPhoneEdt);
        teacherEmailEdt = findViewById(R.id.teacherEmailEdt);
    }

    /**
     * TODO: set text to all fields
     * INCOMPLETE
     */
    private void loadData(){
        teacherNameEdt.setText(TeacherViewActivity.teacherList.get(position).getTeacherName());
        teacherPhoneEdt.setText(TeacherViewActivity.teacherList.get(position).getPhone());
        teacherEmailEdt.setText(TeacherViewActivity.teacherList.get(position).getEmail());


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.backBtn:
                finish();
                break;
            case R.id.editTeacherBtn:
                // TODO: editing code
                Teacher teacher = TeacherViewActivity.teacherList.get(position);

                String teacherName = teacherNameEdt.getText().toString();
                String teacherPhone = teacherPhoneEdt.getText().toString();
                String teacherEmail = teacherEmailEdt.getText().toString();

                if (teacherName == null){
                    Toast.makeText(TeacherEditActivity.this, "Invalid name", Toast.LENGTH_SHORT).show();
                    return;
                }

                HomeActivity.myDatabase.updateTeacher(String.valueOf(teacher.getTeacherID()), teacherName, teacherPhone, teacherEmail);



                Toast.makeText(this, "Edit a teacher", Toast.LENGTH_SHORT).show();

                finish();
                break;

        }
    }
}

