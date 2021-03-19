package com.sqa.plannet.activity.teacher;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.sqa.plannet.R;
import com.sqa.plannet.adapter.teacher.TeacherAdapter;
import com.sqa.plannet.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherViewActivity extends AppCompatActivity {
    private AppBarLayout appBarLayout;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Toolbar toolbar;
    private ImageButton addBtn;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private RecyclerView recyclerView;
    private TeacherAdapter teacherAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_view);

        initUI();
        initToolbar();
        initRecyclerView();


        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TeacherViewActivity.this, TeacherCreateActivity.class);
                startActivity(intent);
            }
        });

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Teachers");
        drawerLayout.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


    }

    /**
     * TODO: Initiate all necessary UI elements
     */
    private void initUI(){
        appBarLayout = findViewById(R.id.appBarLayout);
        collapsingToolbarLayout = findViewById(R.id.colToolbar);
        addBtn = findViewById(R.id.fabAdd);
        drawerLayout= findViewById(R.id.teacherViewDrawer);
        navigationView= findViewById(R.id.navView);
        toolbar = findViewById(R.id.teacherViewToolbar);
        recyclerView = findViewById(R.id.rv_teacher);

    }


    /**
     * TODO: Initiate the toolbar
     */
    private void initToolbar(){
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    /**
     * TODO: Allocate all teachers to the RecycleView
     */
    private void initRecyclerView() {
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        teacherAdapter = new TeacherAdapter();
        teacherAdapter.setData(getListTeacher());
        recyclerView.setAdapter(teacherAdapter);
    }

    /**
     * TODO: Get a list of all teachers
     * @return Either the list of teachers or null
     */
    private List<Teacher> getListTeacher() {
        List<Teacher> list = new ArrayList<>();

        list.add(new Teacher("Long NDT"));
        list.add(new Teacher("Quan DD"));
        list.add(new Teacher("Duc LM"));
        list.add(new Teacher("Ngoc TB"));

        return list;
    }


}