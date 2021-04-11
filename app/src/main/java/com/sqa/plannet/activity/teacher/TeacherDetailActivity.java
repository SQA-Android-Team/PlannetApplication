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
import com.sqa.plannet.activity.home.HomeActivity;
import com.sqa.plannet.activity.todo.DetailActivity;
import com.sqa.plannet.activity.todo.TodoMainActivity;
import com.sqa.plannet.activity.todo.UpdateActivity;
import com.sqa.plannet.model.Task;
import com.sqa.plannet.model.Teacher;

import static com.sqa.plannet.activity.home.HomeActivity.myDatabase;
import static com.sqa.plannet.activity.todo.TodoMainActivity.TABLE_TASK;

public class TeacherDetailActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton backBtn;
    ImageButton editBtn;
    ImageButton deleteBtn;
    ImageButton phoneCallBtn;
    ImageButton emailSendBtn;
    TextView teacherNameTxv;
    TextView teacherPhoneTxv;
    TextView teacherEmailTxv;
    Teacher t;

    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_detail);

        Intent intent = getIntent();
        position =(int) intent.getExtras().get("position");

        initUI();
        loadData();
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


    private void loadData(){
        Intent intent = getIntent();
        t = (Teacher) intent.getSerializableExtra("Teacher");
        teacherNameTxv.setText(t.getTeacherName());
        teacherPhoneTxv.setText(t.getPhone());
        teacherEmailTxv.setText(t.getEmail());
    }




    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.backBtn:
                finish();
                break;
            case R.id.editBtn:
                Intent intent1 = new Intent(TeacherDetailActivity.this, TeacherEditActivity.class);
                intent1.putExtra("TeacherEdit", t);
                // TODO: INCOMPLETE
                break;
            case R.id.deleteBtn:
                AlertDialog deleteConfirm = new AlertDialog.Builder(TeacherDetailActivity.this)
                        .setTitle("Confirmation")
                        .setMessage("Do you really want to delete this teacher?")
                        .setIcon(R.drawable.ic_baseline_warning_24)
                        .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                Teacher teacher = TeacherViewActivity.teacherList.get(position);
                                TeacherViewActivity.teacherList.remove(position);
                                String delete =  "DELETE FROM " + TeacherViewActivity.TABLE_TEACHER + " WHERE id = " + teacher.getTeacherID();
                                myDatabase.excuteSQL(delete);

                                dialog.dismiss();
                                Toast.makeText(TeacherDetailActivity.this, "Delete Successfull", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(TeacherDetailActivity.this, TeacherViewActivity.class);
                                startActivity(intent);


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