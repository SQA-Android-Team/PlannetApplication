package com.sqa.plannet.activity.subject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.sqa.plannet.R;
import com.sqa.plannet.model.Subject;

public class GradeEditActivity extends AppCompatActivity implements View.OnClickListener{
    private Subject subject;
    private ImageButton backBtn;
    private Button editBtn;
    private EditText attendanceEdt,  midtermEdt, finalEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.grade_edit);
        Intent intent = getIntent();
        subject = (Subject) intent.getExtras().get("subject");

        initUI();
        backBtn.setOnClickListener(this);
        editBtn.setOnClickListener(this);
    }

    /**
     * TODO: initialise all UI elements
     */
    private void initUI(){

        backBtn = findViewById(R.id.backBtn);
        editBtn = findViewById(R.id.editBtn);
        attendanceEdt = findViewById(R.id.attendanceEdt);
        midtermEdt = findViewById(R.id.midtermEdt);
        finalEdt = findViewById(R.id.finalEdt);

        attendanceEdt.setText("" + subject.getAttendance());
        midtermEdt.setText("" + subject.getMidterm());
       finalEdt.setText("" + subject.getFinalTest());
    }





    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.backBtn:
                finish();
                break;
            case R.id.editBtn:
                float attendance = Float.parseFloat(attendanceEdt.getText().toString());
                float midterm = Float.parseFloat(midtermEdt.getText().toString());
                float finalTest = Float.parseFloat(finalEdt.getText().toString());

                // TODO: complete this

                finish();
                break;
        }

    }
}