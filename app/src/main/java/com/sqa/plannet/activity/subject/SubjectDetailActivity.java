package com.sqa.plannet.activity.subject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.sqa.plannet.R;
import com.sqa.plannet.activity.teacher.TeacherDetailActivity;
import com.sqa.plannet.model.Subject;

import java.util.List;

public class SubjectDetailActivity extends AppCompatActivity implements  View.OnClickListener {
    private Subject subject;
    private ImageButton backBtn, deleteBtn;
    private LinearLayout editSubjectBtn,  editGradeBtn;


    private TextView subjectTitleTxv, subjectCreditTxv, subjectNoteTxv;

    private TextView attendanceTxv, midtermTxv, finalTxv,overallTxv;



    private int position;


    @Override
    protected void  onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subject_detail);

            Intent intent = getIntent();
            subject = (Subject) intent.getExtras().get("subject");
            position = (int) intent.getExtras().get("position");
            Toast.makeText(this, subject.toString(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, ""+position, Toast.LENGTH_SHORT).show();

            initUI();
            // TODO: fix the line below

//            initSpinner();
            backBtn.setOnClickListener(this);
            deleteBtn.setOnClickListener(this);
            editGradeBtn.setOnClickListener(this);
            editSubjectBtn.setOnClickListener(this);

            loadData();





    }

    /**
     * TODO: initialise all necessary UI elements
     */
    private void initUI(){
        backBtn = findViewById(R.id.backBtn);
        deleteBtn = findViewById(R.id.deleteBtn);
        editSubjectBtn = findViewById(R.id.editSubjectBtn);
        editGradeBtn = findViewById(R.id.editGradeBtn);

        subjectTitleTxv = findViewById(R.id.subjectTitleTxv);
        subjectCreditTxv = findViewById(R.id.subjectCreditTxv);
        subjectNoteTxv = findViewById(R.id.subjectNoteTxv);
        attendanceTxv = findViewById(R.id.attendanceTxv);
        midtermTxv = findViewById(R.id.midtermTxv);
        finalTxv = findViewById(R.id.finalTxv);
        overallTxv = findViewById(R.id.overallTxv);

    }




    private void loadData(){
        List<Subject> list = SubjectViewActivity.getListSubject();

        subjectTitleTxv.setText(subject.getSubjectTitle());


        subjectCreditTxv.setText("Credits: " +list.get(position).getSubjectCredit());

        subjectNoteTxv.setText("Note: "+list.get(position).getSubjectNote());

        attendanceTxv.setText("" + list.get(position).getAttendance());

        midtermTxv.setText(""+list.get(position).getMidterm());

        finalTxv.setText("" + list.get(position).getMidterm());

        float overall = (float) (list.get(position).getAttendance() * 0.1 + list.get(position).getMidterm() * 0.3 + list.get(position).getFinalTest() * 0.6);

        overallTxv.setText("" + overall);


    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.backBtn:
                finish();
                break;
            case R.id.deleteBtn:
                AlertDialog deleteConfirm = new AlertDialog.Builder(SubjectDetailActivity.this)
                        .setTitle("Confirmation")
                        .setMessage("Do you really want to delete this subject?")
                        .setIcon(R.drawable.ic_baseline_warning_24)
                        .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                // TODO: deleting code
                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                dialog.dismiss();
                            }
                        })
                        .create();
                deleteConfirm.show();
                break;
            case R.id.editSubjectBtn:
                intent = new Intent(SubjectDetailActivity.this, SubjectEditActivity.class);
                intent.putExtra("subject" , subject);
                startActivity(intent);
                break;
            case R.id.editGradeBtn:
                intent = new Intent(SubjectDetailActivity.this, GradeEditActivity.class);
                intent.putExtra("subject" , subject);
                startActivity(intent);
                break;




        }
    }
}