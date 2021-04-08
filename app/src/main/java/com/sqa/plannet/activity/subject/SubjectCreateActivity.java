package com.sqa.plannet.activity.subject;

import android.content.ContentValues;
import android.content.Intent;
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

        initUI();
        onBackBtnClick();
        onAddBtnClick();
    }

    private void initUI(){
        // find views by their id
        addBtn = findViewById(R.id.addBtn);
        subjectTitleEdt = findViewById(R.id.subjectTitleEdt);
        subjectCreditEdt = findViewById(R.id.subjectCreditEdt);
        subjectNoteEdt = findViewById(R.id.subjectNoteEdt);
        backBtn = findViewById(R.id.backBtn);
    }

    private void onBackBtnClick(){
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void onAddBtnClick(){
        // add event listener for addBtn
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String subjectTitle = subjectTitleEdt.getText().toString();

                // Get subject title from edit text; subject title must be valid
                if (subjectTitle.length()==0 || subjectTitle == null){
                    // show toast message to inform user of invalid subject title
                    Toast.makeText(SubjectCreateActivity.this, "Enter a valid title", Toast.LENGTH_SHORT).show();
                    return;
                }

                int subjectCredit = 0;
                // Get number of credit from edit text
                // if it is null, do nothing
                // else parse it into integer
                if (subjectCreditEdt.getText().toString() != null) {
                    subjectCredit = Integer.parseInt(subjectCreditEdt.getText().toString());

                }

                String subjectNote = subjectNoteEdt.getText().toString();


                Toast.makeText(SubjectCreateActivity.this, subjectTitle + "-" + subjectCredit + "-" +subjectNote, Toast.LENGTH_SHORT).show();


                ContentValues contentValues = new ContentValues();
                contentValues.put("subjectTitle", subjectTitle);
                contentValues.put("subjectCredit", subjectCredit);
                contentValues.put("subjectNote", subjectNote);

                SubjectViewActivity.myDatabase.insertTask(SubjectViewActivity.TABLE_NAME, null, contentValues);

                Intent intent = new Intent(SubjectCreateActivity.this, SubjectViewActivity.class);
                startActivity(intent);
                // finish activity
                finish();

            }
        });
    }



}