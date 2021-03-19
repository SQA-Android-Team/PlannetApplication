package com.sqa.plannet.activity.subject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.sqa.plannet.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class SubjectEditActivity extends AppCompatActivity {
    Button editBtn;
    ImageButton backBtn;
    EditText subjectTitleEdt;
    EditText subjectCreditEdt;
    EditText subjectNoteEdt;
   

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.subject_edit);

        // add event listener for backBtn
        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}