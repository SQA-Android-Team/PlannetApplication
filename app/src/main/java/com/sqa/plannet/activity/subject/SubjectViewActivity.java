package com.sqa.plannet.activity.subject;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

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


        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubjectViewActivity.this, SubjectCreateActivity.class);
                intent.putExtra("parent_class", SubjectViewActivity.class);
                startActivity(intent);
            }
        });

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Subjects");
        drawerLayout.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

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
        }
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


}