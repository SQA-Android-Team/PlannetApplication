package com.sqa.plannet.activity.subject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sqa.plannet.R;
import com.sqa.plannet.model.Subject;

import de.hdodenhof.circleimageview.CircleImageView;

public class SubjectCreateActivity extends AppCompatActivity {

    Button addBtn;
    ImageButton backBtn;
    EditText subjectTitleEdt;
    EditText subjectCreditEdt;
    EditText subjectNoteEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subject_create);

        // find views by their id
        addBtn = findViewById(R.id.addBtn);
        subjectTitleEdt = findViewById(R.id.subjectTitleEdt);
        subjectCreditEdt = findViewById(R.id.subjectCreditEdt);
        subjectNoteEdt = findViewById(R.id.subjectNoteEdt);

        // add event listener for backBtn
        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });




        // add event listener for addBtn
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Subject subject = new Subject();
                String subjectTitle = subjectTitleEdt.getText().toString();

                // Get subject title from edit text; subject title must be valid
                if (subjectTitle.length()==0 || subjectTitle == null){
                    // show toast message to inform user of invalid subject title
                    Toast.makeText(SubjectCreateActivity.this, "Enter a valid title", Toast.LENGTH_SHORT).show();
                    return;
                }
                subject.setSubjectTitle(subjectTitle);

                // Get number of credit from edit text
                // if it is null, do nothing
                // else parse it into integer
                if (subjectCreditEdt.getText().toString() == null) {
                    int subjectCredit = Integer.parseInt(subjectCreditEdt.getText().toString());
                    subject.setSubjectCredit(subjectCredit);
                }

                String subjectNote = subjectNoteEdt.getText().toString();
                subject.setSubjectNote(subjectNote);

                Toast.makeText(SubjectCreateActivity.this, subject.getSubjectTitle() + "-" + subject.getSubjectCredit() + "-" +subject.getSubjectNote(), Toast.LENGTH_SHORT).show();

               // finish activity
                finish();

            }
        });

    }


    protected void onBackBtnClick(View view){
        onBackBtnClick(view);
    }
}