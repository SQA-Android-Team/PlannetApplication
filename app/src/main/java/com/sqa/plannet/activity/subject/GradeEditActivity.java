package com.sqa.plannet.activity.subject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.sqa.plannet.R;

public class GradeEditActivity extends AppCompatActivity {
    private ImageButton backBtn;
    private Button editBtn;
    private EditText attendanceEdt;
    private EditText midtermEdt;
    private EditText finalEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.grade_edit);

        initUI();
        onBackBtnClick();
        onEditBtnClick();

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
    }

    /**
     * TODO: back button
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
     * TODO: edit button
     */
    private void onEditBtnClick(){
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                float attendance = Float.parseFloat(attendanceEdt.getText().toString());
                float midterm = Float.parseFloat(midtermEdt.getText().toString());
                float finalTest = Float.parseFloat(finalEdt.getText().toString());

                // TODO: update


                finish();
            }
        });
    }



}