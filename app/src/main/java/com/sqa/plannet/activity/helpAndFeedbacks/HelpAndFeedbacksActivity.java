package com.sqa.plannet.activity.helpAndFeedbacks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.sqa.plannet.R;


public class HelpAndFeedbacksActivity extends AppCompatActivity {
    EditText subjectFb;
    EditText emailFb;
    EditText questionFb;
    Button sendFb_Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
//        getSupportActionBar().hide(); // hide the title bar
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen

        setContentView(R.layout.help_and_feedbacks);

        subjectFb = findViewById(R.id.subjectFb);
        emailFb = findViewById(R.id.emailFb);
        questionFb = findViewById(R.id.questionFb);
        sendFb_Btn = findViewById(R.id.sendFb_Btn);
        sendFb_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Intent.ACTION_SEND);
                it.putExtra(Intent.EXTRA_EMAIL, new String[]{"thanhcongvnqn1310@gamil.com"});
                it.putExtra(Intent.EXTRA_SUBJECT, subjectFb.getText().toString());
                it.putExtra(Intent.EXTRA_TEXT, questionFb.getText());
                it.setType("message/rfc822"); //it.setType("plain/text");
                startActivity(Intent.createChooser(it, "Choose Mail App"));
            }
        });
    }
}

