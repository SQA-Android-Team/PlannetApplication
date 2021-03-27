package com.sqa.plannet.activity.teacher;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sqa.plannet.R;
import com.sqa.plannet.model.Subject;
import com.sqa.plannet.model.Teacher;

public class TeacherEditActivity extends AppCompatActivity implements  View.OnClickListener{

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
    private void setEdtText(Teacher teacher) {
        teacherNameEdt.setText(teacher.getTeacherName());
        teacherPhoneEdt.setText(teacher.getPhone());
        teacherEmailEdt.setText(teacher.getEmail());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.backBtn:
                finish();
                break;
            case R.id.editBtn:
                // TODO: editing code
                Toast.makeText(this, "Edit a teacher", Toast.LENGTH_SHORT).show();

                finish();
                break;

        }
    }
}

