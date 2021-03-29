package com.sqa.plannet.activity.subject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.sqa.plannet.R;
import com.sqa.plannet.model.Subject;

import de.hdodenhof.circleimageview.CircleImageView;

public class SubjectEditActivity extends AppCompatActivity implements View.OnClickListener{
    private Subject subject;
    private Button editBtn;
    private ImageButton backBtn;
    private EditText subjectTitleEdt, subjectCreditEdt, subjectNoteEdt;

   

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.subject_edit);
        Intent intent = getIntent();
        subject = (Subject) intent.getExtras().get("subject");


        initUI();

        loadData();

        backBtn.setOnClickListener(this);
        editBtn.setOnClickListener(this);


    }

    /**
     * TODO: initialise all necessary UI element
     */
    private void initUI(){
        backBtn = findViewById(R.id.backBtn);
        editBtn = findViewById(R.id.editBtn);
        subjectTitleEdt = findViewById(R.id.subjectTitleEdt);
        subjectCreditEdt = findViewById(R.id.subjectCreditEdt);
        subjectNoteEdt = findViewById(R.id.subjectNoteEdt);
    }

    /**
     * TODO: set text to all fields
     * INCOMPLETE
     */
    private void loadData(){
        subjectTitleEdt.setText(subject.getSubjectTitle());
        subjectCreditEdt.setText("" + subject.getSubjectCredit());
        subjectNoteEdt.setText(subject.getSubjectNote());

    }



    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.backBtn:
                finish();
                break;
            case R.id.editBtn:


                // TODO: complete this
                finish();
                break;

        }

    }
}