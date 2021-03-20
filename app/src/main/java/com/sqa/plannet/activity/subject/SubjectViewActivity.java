package com.sqa.plannet.activity.subject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.sqa.plannet.R;
import com.sqa.plannet.activity.calendar.CalendarViewActivity;
import com.sqa.plannet.activity.teacher.TeacherViewActivity;
import com.sqa.plannet.adapter.subject.SubjectAdapter;
import com.sqa.plannet.model.Subject;

import java.util.ArrayList;
import java.util.List;

public class SubjectViewActivity extends AppCompatActivity {
    private AppBarLayout appBarLayout;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Toolbar toolbar;
    private FloatingActionButton addBtn;
    private RecyclerView recyclerView;
    private SubjectAdapter subjectAdapter;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    private Menu menu;

    private boolean isExpanded = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subject_view);
        initUI();
        initToolbar();
        initRecycleView();
        onAddBtnClick();
        onNavigationItemClick();
        initDrawer();
    }

    /**
     * TODO: Initiate all necessary UI elements
     */
    private void initUI(){
        drawerLayout = findViewById(R.id.subjectViewDrawer);
        toolbar = findViewById(R.id.subjectViewToolbar);
        navigationView = findViewById(R.id.navView);
        addBtn = findViewById(R.id.fabAdd);
        appBarLayout = findViewById(R.id.appBarLayout);
        collapsingToolbarLayout = findViewById(R.id.colToolbar);
        recyclerView = findViewById(R.id.rv_subject);

    }


    /**
     * TODO: Initiate the toolbar
     */
    private void initToolbar(){
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Subjects");
        }
    }

    /**
     * TODO: Intitialise drawer menu
     */
    private void initDrawer(){
        drawerLayout.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }


    /**
     * TODO: Allocate all subjects to the RecycleView
     */
    private void initRecycleView() {
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        subjectAdapter = new SubjectAdapter();
        subjectAdapter.setData(getListSubject());
        recyclerView.setAdapter(subjectAdapter);
    }

    /**
     * TODO: Get a list of all subjects
     * @return Either the list of subjects or null
     */
    private List<Subject> getListSubject(){

        List<Subject> list = new ArrayList<Subject>();
        list.add(new Subject("System Analysis and Design"));
        list.add(new Subject("System Analysis and Design"));
        list.add(new Subject("System Analysis and Design"));
        list.add(new Subject("System Analysis and Design"));
        list.add(new Subject("System Analysis and Design"));

        return list;
    }

    /**
     * TODO: Add event listener for add button
     */
    private void onAddBtnClick(){
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubjectViewActivity.this, SubjectCreateActivity.class);
                intent.putExtra("parent_class", SubjectViewActivity.class);
                startActivity(intent);
            }
        });
    }


    /**
     * TODO: Initialise Toolbar animation
     */
    private void initToolbarAnimation(){

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.subject_theme);
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@Nullable Palette palette) {
               // TODO: https://www.youtube.com/watch?v=-WIp6uNpWcE&t=1615s 32:56
            }
        });
    }

    /**
     * TODO: Set menu drawer item onClick
     */
    private void onNavigationItemClick(){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent = null;
                switch (item.getItemId()){
                    case R.id.navHome:
                        return true;
                    case R.id.navTodo:
                        return true;
                    case R.id.navTimetable:
                        return true;
                    case R.id.navCalendar:
                        intent = new Intent(SubjectViewActivity.this, CalendarViewActivity.class);
                        startActivity(intent);
                        return true;
                    case R.id.navTeacher:
                        intent = new Intent(SubjectViewActivity.this, TeacherViewActivity.class);
                        startActivity(intent);
                        return true;
                    case R.id.navSubject:
                         intent = new Intent(SubjectViewActivity.this, SubjectViewActivity.class);
                        startActivity(intent);
                        return true;
                    case R.id.navSettings:
                        return true;
                    case R.id.navHelp:
                        return true;







                }
                return false;
            }
        });
    }



}