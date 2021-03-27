package com.sqa.plannet.activity.teacher;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.sqa.plannet.R;
import com.sqa.plannet.model.Teacher;

public class TeacherDetailActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton backBtn;
    ImageButton editBtn;
    ImageButton deleteBtn;
    ImageButton phoneCallBtn;
    ImageButton emailSendBtn;
    TextView teacherNameTxv;
    TextView teacherPhoneTxv;
    TextView teacherEmailTxv;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_detail);

        initUI();

        backBtn.setOnClickListener(this);
        editBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);
        phoneCallBtn.setOnClickListener(this);
        emailSendBtn.setOnClickListener(this);







    }

    /**
     * TODO: initiate all necessary UI elements
     */
    private void initUI(){
        backBtn = findViewById(R.id.backBtn);
        editBtn = findViewById(R.id.editBtn);
        deleteBtn = findViewById(R.id.deleteBtn);
        phoneCallBtn = findViewById(R.id.teacherPhoneBtn);
        emailSendBtn = findViewById(R.id.teacherEmailBtn);
        teacherNameTxv = findViewById(R.id.teacherNameTxv);
        teacherPhoneTxv = findViewById(R.id.teacherPhoneTxv);
        teacherEmailTxv = findViewById(R.id.teacherEmailTxv);
    }










    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.backBtn:
                finish();
                break;
            case R.id.editBtn:
                Intent intent = new Intent(TeacherDetailActivity.this, TeacherEditActivity.class);
                intent.putExtra("teacher", "");
                startActivity(intent);
                // TODO: INCOMPLETE
                break;
            case R.id.teacherPhoneBtn:
                String phoneNumber = teacherPhoneTxv.getText().toString();
                Toast.makeText(TeacherDetailActivity.this, phoneNumber, Toast.LENGTH_SHORT).show();
                Uri call = Uri.parse("tel:" + phoneNumber);
                Intent intent1 = new Intent(Intent.ACTION_DIAL);
                intent1.setData(call);
                startActivity(intent1);
                break;
            case R.id.teacherEmailBtn:
                String mailAddress = teacherEmailTxv.getText().toString();
                Intent intent2 = new Intent(Intent.ACTION_SENDTO);
                intent2.setData(Uri.parse("mailto:"+Uri.encode(mailAddress)));
                startActivity(intent2);
                break;
            case R.id.deleteBtn:
                AlertDialog deleteConfirm = new AlertDialog.Builder(TeacherDetailActivity.this)
                        .setTitle("Confirmation")
                        .setMessage("Do you really want to delete this teacher?")
                        .setIcon(R.drawable.ic_baseline_delete_24)
                        .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                // deleting code
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

        }

    }
}