package com.sqa.plannet.activity.subject;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
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
import com.sqa.plannet.database.MyDatabase;
import com.sqa.plannet.model.Subject;

import java.util.ArrayList;
import java.util.List;

public class SubjectViewActivity extends AppCompatActivity implements View.OnClickListener {
    private AppBarLayout appBarLayout;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Toolbar toolbar;
    private FloatingActionButton addBtn;
    private RecyclerView recyclerView;
    private SubjectAdapter subjectAdapter;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;


    public static MyDatabase myDatabase;
    public static String TABLE_NAME = "subject";



    private Menu subMenu;
    private boolean isExpanded = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subject_view);
        initUI();
        initToolbar();

        initDrawer();
        initToolbarAnimation();
        addBtn.setOnClickListener(this);


        myDatabase = new MyDatabase(SubjectViewActivity.this, "manageTask.sqlite", null, 1);
        String sql_create_table = "create table if not exists subject(subjectID integer primary key autoincrement, " +
                "subjectTitle varchar(100), " +
                "subjectNote varchar(2000), " +
                "subjectCredit integer, " +
                "attendance float, " +
                "midterm float, " +
                "finalTest float, " +
                "objective varchar(10))";
        myDatabase.excuteSQL(sql_create_table);


        initRecycleView();

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
     * TODO: Intitialise drawer menu
     */
    private void initDrawer(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Subjects");
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
        subjectAdapter.notifyDataSetChanged();
    }

    /**
     * TODO: Get a list of all subjects
     * @return Either the list of subjects or null
     */
    private List<Subject> getListSubject(){

        List<Subject> list = new ArrayList<Subject>();
        String sql_select = "SELECT * FROM " + TABLE_NAME;
        Cursor cs = myDatabase.rawQuery(sql_select);
        list.clear();
        while (cs.moveToNext()){
            int subjectID = cs.getInt(0);
            String subjectTitle = cs.getString(1);
            String subjectNote = cs.getString(2);
            int subjectCredit = cs.getInt(3);
            float attendance = cs.getFloat(4);
            float midterm = cs.getFloat(5);
            float finalTest = cs.getFloat(6);
            String objective = cs.getString(7);
            Subject subject = new Subject(subjectID, subjectTitle, subjectNote, subjectCredit, attendance, midterm, finalTest, objective);
            list.add(subject);
        }

        return list;
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
                int collapsedColor = palette.getVibrantColor(getResources().getColor(R.color.cutie_pink));
                collapsingToolbarLayout.setContentScrimColor(collapsedColor);
                collapsingToolbarLayout.setStatusBarScrimColor(getResources().getColor(R.color.black_trans));

            }
        });

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (Math.abs(verticalOffset) > 180){
                    isExpanded = false;
                } else {
                    isExpanded = true;
                }
                invalidateOptionsMenu();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        subMenu = menu;
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (subMenu != null & ( !isExpanded || subMenu.size() != 1)){
            subMenu.add("Add").setIcon(R.drawable.round_add_white_36dp).setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        } else {

        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.subMenuSetting:
                // INCOMPLETE
                return true;

        }
        if (item.getTitle().equals("Add")){
            Intent intent = new Intent(SubjectViewActivity.this, SubjectCreateActivity.class);
            intent.putExtra("parent_class", SubjectViewActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fabAdd:
                Intent intent = new Intent(SubjectViewActivity.this, SubjectCreateActivity.class);
                startActivity(intent);
                break;

        }

    }
}