package com.sqa.plannet.activity.subject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.sqa.plannet.R;
import com.sqa.plannet.model.Subject;

import de.hdodenhof.circleimageview.CircleImageView;

public class SubjectEditActivity extends AppCompatActivity {
    private Button editBtn;
    private ImageButton backBtn;
    private EditText subjectTitleEdt;
    private EditText subjectCreditEdt;
    private EditText subjectNoteEdt;

   

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.subject_edit);

        initUI();
        onBackBtnClick();
        onEditBtnClick();
        // INCOMPLETE
//        setEdtText();



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
    private void setEdtText(Subject subject){
        subjectTitleEdt.setText(subject.getSubjectTitle());
        subjectCreditEdt.setText(subject.getSubjectCredit());
        subjectNoteEdt.setText(subject.getSubjectNote());

    }


    /**
     * TODO:
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
     * TODO: INCOMPLETE
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