package com.sqa.plannet.activity.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.navigation.NavigationView;
import com.sqa.plannet.R;

public class SettingsMenuActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private AppBarLayout appBarLayout;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Toolbar toolbar;
    private Button generalBtn;
    private Button notificationsBtn;
    private Button ratingAppBtn;
    private Button aboutBtn;
    private Button backUpBtn;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_menu);
        initUI();

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen


        onRatingAppBtnClick();
        onAboutBtnClick();
    }
    /**
     * TODO: Initiate all necessary UI elements
     */
    private void initUI() {
        drawerLayout = findViewById(R.id.settingsViewDrawer);
        toolbar = findViewById(R.id.settingsViewToolBar);
        appBarLayout = findViewById(R.id.appBarLayout);
        navigationView = findViewById(R.id.navView);
        ratingAppBtn.findViewById(R.id.ratingAppBtn);
        aboutBtn.findViewById(R.id.aboutBtn);
        collapsingToolbarLayout = findViewById(R.id.colToolBar);
    }


    /**
     * TODO: Add event listener for rate app button
     */
    private void onRatingAppBtnClick() {
        ratingAppBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingsMenuActivity.this, SettingsRatingActivity.class);
                intent.putExtra("parent_class",SettingsMenuActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * TODO: Add event listener for about button
     */
    private void onAboutBtnClick() {
        ratingAppBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingsMenuActivity.this, SettingsAboutActivity.class);
                intent.putExtra("parent_class", SettingsMenuActivity.class);
                startActivity(intent);
            }
        });
    }

}
