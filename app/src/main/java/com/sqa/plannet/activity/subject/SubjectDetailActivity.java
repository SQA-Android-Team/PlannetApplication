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

public class SubjectDetailActivity extends AppCompatActivity implements  View.OnClickListener {
    private Subject subject;
    private ImageButton backBtn;
    private ImageButton deleteBtn;
    private LinearLayout editSubjectBtn;
    private LinearLayout editGradeBtn;
    private Spinner rangeSpinner;

    private TextView subjectTitleTxv;
    private TextView subjectCreditTxv;
    private TextView subjectNoteTxv;

    private TextView attendanceTxv;
    private TextView midtermTxv;
    private TextView finalTxv;

    private TextView overallTxv;
    private TextView rangeDecimalTxv;

    private String[] range = {"A+" , "A", "B+", "B", "C+", "C"};



    @Override
    protected void  onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subject_detail);



            initUI();
            // TODO: fix the line below
//        setText(null);
//            initSpinner();
            backBtn.setOnClickListener(this);
            deleteBtn.setOnClickListener(this);
            editGradeBtn.setOnClickListener(this);
            editSubjectBtn.setOnClickListener(this);






    }

    /**
     * TODO: initialise all necessary UI elements
     */
    private void initUI(){
        backBtn = findViewById(R.id.backBtn);
        deleteBtn = findViewById(R.id.deleteBtn);
        editSubjectBtn = findViewById(R.id.editSubjectBtn);
        editGradeBtn = findViewById(R.id.editGradeBtn);
        rangeSpinner = findViewById(R.id.rangeSpinner);
        subjectTitleTxv = findViewById(R.id.subjectTitleTxv);
        subjectCreditTxv = findViewById(R.id.subjectCreditTxv);
        subjectNoteTxv = findViewById(R.id.subjectNoteTxv);
        attendanceTxv = findViewById(R.id.attendanceTxv);
        midtermTxv = findViewById(R.id.midtermTxv);
        finalTxv = findViewById(R.id.finalTxv);
        overallTxv = findViewById(R.id.overallTxv);
        rangeDecimalTxv = findViewById(R.id.rangeDecimalTxv);
    }


    /**
     * TODO: set Text
     */
    private void setText(Subject subject){
        subjectTitleTxv.setText(subject.getSubjectTitle());

        subjectCreditTxv.setText(subject.getSubjectCredit());

        subjectNoteTxv.setText(subject.getSubjectNote());

        attendanceTxv.setText("" +subject.getAttendance());

        midtermTxv.setText(""+subject.getMidterm());

        finalTxv.setText("" + subject.getFinalTest());

        float overall = (float) (subject.getAttendance() * 0.1 + subject.getMidterm() * 0.3 + subject.getFinalTest() * 0.6);

        overallTxv.setText("" + overall);


    }

    /**
     * TODO: grade range spinner
     */
//    private void initSpinner(){
//
//
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.range, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        rangeSpinner.setAdapter(adapter);
//        rangeSpinner.setOnItemClickListener(this::onItemSelected);
//
//
//    }

//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        String text = parent.getItemAtPosition(position).toString();
//        Toast.makeText(parent.getContext(),text, Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> adapterView) {
//
//    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.backBtn:
                finish();
                break;
            case R.id.deleteBtn:
                AlertDialog deleteConfirm = new AlertDialog.Builder(SubjectDetailActivity.this)
                        .setTitle("Confirmation")
                        .setMessage("Do you really want to delete this subject?")
                        .setIcon(R.drawable.ic_baseline_delete_24)
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
                Intent intent = new Intent(SubjectDetailActivity.this, SubjectEditActivity.class);
                startActivity(intent);
                break;
            case R.id.editGradeBtn:
                Intent intent1 = new Intent(SubjectDetailActivity.this, GradeEditActivity.class);
                startActivity(intent1);
                break;




        }
    }
}