package com.sqa.plannet.activity.subject;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.sqa.plannet.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class SubjectEditActivity extends AppCompatActivity {
    Button addBtn;
    EditText subjectTitleEdt;
    EditText subjectCreditEdt;
    EditText subjectNoteEdt;
   

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.subject_edit);


    }
}