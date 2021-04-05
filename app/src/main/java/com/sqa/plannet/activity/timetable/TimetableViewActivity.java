package com.sqa.plannet.activity.timetable;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.navigation.NavigationView;
import com.sqa.plannet.R;

public class TimetableViewActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, EditSemesterNameDialog.EditSemesterNameListener {
    private ImageButton btnAddClass;
    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private AppBarLayout appBarLayout;
    private TextView txtSemesterName;
    private RelativeLayout relMon, relTue, relWed, relThu, relFri, relSat, relSun;
    private ImageButton btnEditSemesterName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timetable_view);
        initUI();
        initToolbar();
        initDrawer();

        drawerLayout = findViewById(R.id.timetableViewDrawer);
        toolbar = findViewById(R.id.timetableViewToolbar);
        navigationView = findViewById(R.id.navView);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Timetable");
        drawerLayout.bringToFront();

//        // get the reference of RelativeLayout
//        relMon = findViewById(R.id.relMon);
//
//        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 200);
//        lp.setMargins(0, 100, 0, 0);
//        View view = getLayoutInflater().inflate(R.layout.activity_timetable_session_view, null);
//        view.setLayoutParams(lp);
//        relMon.addView(view);

//        relSun = findViewById(R.id.relSun);
//        LinearLayout.LayoutParams ll = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 200);
//        ll.setMargins(0, 100, 0, 0);
//        View v = getLayoutInflater().inflate(R.layout.session_view,null);
//        v.setLayoutParams(ll);
//        relSun.addView(v);
//
//        relTue = findViewById(R.id.relTue);
//        LinearLayout.LayoutParams ll1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 200);
//        ll1.setMargins(0, 100, 0, 0);
//        View v1 = getLayoutInflater().inflate(R.layout.session_view,null);
//        v1.setLayoutParams(ll1);
//        relTue.addView(v1);

    }

    // not done yet
    private void initDrawer(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.timetableViewDrawer);
        navigationView = findViewById(R.id.navView);
        drawerLayout.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }

    private void initUI(){
        appBarLayout = findViewById(R.id.appBarLayout);
        collapsingToolbarLayout = findViewById(R.id.colToolbar);
        toolbar = findViewById(R.id.timetableViewToolbar);
    }

    private void initToolbar(){
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void addClass(View view) {
        btnAddClass = findViewById(R.id.btnAddClass);
        btnAddClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TimetableViewActivity.this, TimetableAddSession.class));
            }
        });


    }

    public void editSemesterName(View view) {
        txtSemesterName = findViewById(R.id.txtSemesterName);
        btnEditSemesterName = findViewById(R.id.btnEditSemesterName);

        btnEditSemesterName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEditSemesterNameDialog();

            }
        });
    }

    public void openEditSemesterNameDialog(){
        EditSemesterNameDialog semesterNameDialog  = new EditSemesterNameDialog();
        semesterNameDialog.show(getSupportFragmentManager(), "Edit Semester Name Dialog");
    }


    @Override
    public void applyText(String semesterName) {
        txtSemesterName.setText(semesterName);

    }
}