package com.sqa.plannet.activity.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.sqa.plannet.R;

public class StartedView extends AppCompatActivity {
    private static int SPLASH_SCREEN = 2900;
    private Animation amin_turn_around;
    private ImageView stared_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_started_view);

        amin_turn_around = AnimationUtils.loadAnimation(this, R.anim.amin_turn_around);
        stared_icon =findViewById(R.id.stared_icon);

        stared_icon.setAnimation(amin_turn_around);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(StartedView.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN);

    }
}