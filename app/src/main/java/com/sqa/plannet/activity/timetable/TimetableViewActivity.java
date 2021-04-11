package com.sqa.plannet.activity.timetable;

import android.content.Intent;
import android.database.Cursor;
import android.icu.text.CaseMap;
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
import com.sqa.plannet.model.Session;
import com.sqa.plannet.model.Task;

import java.util.ArrayList;

import static com.sqa.plannet.activity.home.HomeActivity.myDatabase;

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
    private LinearLayout sessionDetail;
    public static String TABLE_SESSION = "sessions";
    ArrayList<Session> listSesion = new ArrayList<>();
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
        listSesion = getAllSession();


        sessionDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TimetableViewActivity.this, TimetableSessionView.class) );
            }
        });

        btnAddClass = findViewById(R.id.btnAddClass);
        btnAddClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i1 = new Intent(TimetableViewActivity.this, TimetableAddSession.class);
               startActivity(i1);
            }
        });



//        Session s = listSesion.get(0);
//        String t = s.getType();
//        Toast.makeText(this, "ok " , Toast.LENGTH_SHORT).show();



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
        sessionDetail= findViewById(R.id.sessionDetail);
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

    public static ArrayList<Session> getAllSession() {
        ArrayList<Session> list = new ArrayList<>();
        String sql_select = "SELECT * FROM " + TABLE_SESSION ;
        Cursor cs = myDatabase.rawQuery(sql_select);
        list.clear();
        while (cs.moveToNext()) {
            int sessionID = cs.getInt(0);
            String name = cs.getString(1);
            String des = cs.getString(2);
            String sessionLocation = cs.getString(3);
            String dateOfWeek = cs.getString(4);
            String startTime = cs.getString(5);
            String endTime = cs.getString(6);
            String color = cs.getString(7);
            Session session = new Session(sessionID, name,des, sessionLocation, dateOfWeek, startTime, endTime, color);
            list.add(session);
        }
        return list;
    }



}