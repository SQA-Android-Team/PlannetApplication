package com.sqa.plannet.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.sqa.plannet.R;
import com.sqa.plannet.activity.calendar.CalendarViewActivity;
import com.sqa.plannet.activity.timetable.TimetableViewActivity;

public class HomeActivity extends AppCompatActivity {
    private Button btnTimetable, btnTodo, btnOverview, btnCalendar;
    private ImageButton btnExitApp;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_view);
        initDrawer();
    }

    private void initDrawer(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.homeViewDrawer);
        navigationView = findViewById(R.id.navView);
        drawerLayout.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }

    /**
     * TODO: Add event listener for choose activity button
     */
    public void btnChooseActivity(View view) {

        btnTimetable = findViewById(R.id.btnTimetable);
        btnTodo = findViewById(R.id.btnTodo);
        btnOverview = findViewById(R.id.btnOverview);
        btnCalendar = findViewById(R.id.btnCalendar);

        btnCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, CalendarViewActivity.class));
            }
        });

        btnTimetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, TimetableViewActivity.class));
            }
        });

    }

    /**
     * TODO: Add event listener for exit button
     */
    public void exitApp(View view) {
        btnExitApp = findViewById(R.id.btnExitApp);
        btnExitApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

    }
}