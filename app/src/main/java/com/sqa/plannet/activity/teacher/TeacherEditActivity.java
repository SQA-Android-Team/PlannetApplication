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
import com.sqa.plannet.model.Task;
import com.sqa.plannet.model.Teacher;

public class TeacherEditActivity extends AppCompatActivity implements  View.OnClickListener{

    private ImageButton backBtn;
    private Button editTeacherBtn;
    private EditText teacherNameEdt;
    private EditText teacherPhoneEdt;
    private EditText teacherEmailEdt;
    private int position;
    Teacher t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_edit);


        Intent intent = getIntent();
        position =(int) intent.getExtras().get("position");
        initUI();
        loadData();
        backBtn.setOnClickListener(this);
        editTeacherBtn.setOnClickListener(this);



    }

    /**
     * TODO: initialise all necessary UI elements
     */
    private void initUI() {
        backBtn = findViewById(R.id.backBtn);
        editTeacherBtn = findViewById(R.id.editTeacherBtn);
        teacherNameEdt = findViewById(R.id.teacherNameEdt);
        teacherPhoneEdt = findViewById(R.id.teacherPhoneEdt);
        teacherEmailEdt = findViewById(R.id.teacherEmailEdt);
    }

    /**
     * TODO: set text to all fields
     * INCOMPLETE
     */
    private void loadData(){
        Intent intent = getIntent();
        t = (Teacher) intent.getSerializableExtra("TeacherEdit");
        teacherNameEdt.setText(t.getTeacherName());
        teacherPhoneEdt.setText(t.getPhone());
        teacherEmailEdt.setText(t.getEmail());
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.backBtn:
                finish();
                break;
            case R.id.editTeacherBtn:
                // TODO: editing code
                update(editTeacherBtn);
                break;

        }
    }
    private void update(Button btnUpdate) {
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

        Intent intent = new Intent(TeacherEditActivity.this, TeacherViewActivity.class);
        startActivity(intent);
    }

}

