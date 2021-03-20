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

public class TeacherDetailActivity extends AppCompatActivity {

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
        onBackBtnClick();
        onEditBtnClick();
        onPhoneCallBtnClick();
        onEmailSendBtn();
        onDeleteBtn();



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

    /**
     * TODO: add event listener for backBtn
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
     * TODO: add event listener for Edit btn
     */
    private void onEditBtnClick() {
        editBtn.setOnClickListener(new View.OnClickListener() {
            /**
             * TODO: PLEASE COMPLETE THE FLOW
             * @param view
             */
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TeacherDetailActivity.this, TeacherEditActivity.class);
                intent.putExtra("teacher", "");
                startActivity(intent);
                // INCOMPLETE
            }
        });
    }

    /**
     * TODO: add event for Phone call button
     *          open android dialer
     */
    private void onPhoneCallBtnClick(){

        phoneCallBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = teacherPhoneTxv.getText().toString();
                Toast.makeText(TeacherDetailActivity.this, phoneNumber, Toast.LENGTH_SHORT).show();
                Uri call = Uri.parse("tel:" + phoneNumber);
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(call);
                startActivity(intent);

            }
        });

    }

    /**
     * TODO: add event for Email send button
     */
    private void onEmailSendBtn() {
        emailSendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mailAddress = teacherEmailTxv.getText().toString();
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"+Uri.encode(mailAddress)));
                startActivity(intent);
            }
        });

    }

    /**
     * TODO: add event for Delete button
     */
    private void onDeleteBtn() {
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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

            }
        });
    }








}