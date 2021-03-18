package com.sqa.plannet.activity.teacher;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.sqa.plannet.R;

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