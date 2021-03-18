package com.sqa.plannet.activity.teacher;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.sqa.plannet.R;

public class TeacherDetailActivity extends AppCompatActivity {

    ImageView editBtn;
    ImageView deleteBtn;
    ImageView phoneCallBtn;
    ImageView emailSendBtn;
    TextView teacherNameTxv;
    TextView teacherPhoneTxv;
    TextView teacherEmailTxv;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_detail);


    }
}