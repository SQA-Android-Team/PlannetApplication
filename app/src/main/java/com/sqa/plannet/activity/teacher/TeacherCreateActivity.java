package com.sqa.plannet.activity.teacher;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sqa.plannet.R;
import com.sqa.plannet.activity.home.HomeActivity;
import com.sqa.plannet.activity.overview.OverviewMainActivity;
import com.sqa.plannet.activity.subject.SubjectViewActivity;
import com.sqa.plannet.model.Teacher;

public class TeacherCreateActivity extends AppCompatActivity implements View.OnClickListener{

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
        backBtn.setOnClickListener(this);
        addBtn.setOnClickListener(this);
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




    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.backBtn:
                finish();
                break;
            case R.id.addBtn:
                String teacherName = teacherNameEdt.getText().toString();
                String teacherPhone = teacherPhoneEdt.getText().toString();
                String teacherEmail = teacherEmailEdt.getText().toString();

                if (teacherName == null){
                    Toast.makeText(TeacherCreateActivity.this, "Invalid name", Toast.LENGTH_SHORT).show();
                    return;
                }

                ContentValues contentValues = new ContentValues();
                contentValues.put("teacherName", teacherName);
                contentValues.put("phone", teacherPhone);
                contentValues.put("email", teacherEmail);

                HomeActivity.myDatabase.insertTask(TeacherViewActivity.TABLE_TEACHER, null, contentValues);

                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TeacherCreateActivity.this, TeacherViewActivity.class);
                startActivity(intent);

                finish();
                break;
        }

    }
}