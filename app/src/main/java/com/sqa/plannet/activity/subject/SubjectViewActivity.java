package com.sqa.plannet.activity.subject;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
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
import com.sqa.plannet.activity.helpAndFeedbacks.HelpAndFeedbacksActivity;
import com.sqa.plannet.activity.home.HomeActivity;
import com.sqa.plannet.activity.overview.OverviewMainActivity;
import com.sqa.plannet.activity.settings.SettingsAboutActivity;
import com.sqa.plannet.activity.settings.SettingsMenuActivity;
import com.sqa.plannet.activity.teacher.TeacherViewActivity;
import com.sqa.plannet.activity.timetable.TimetableViewActivity;
import com.sqa.plannet.activity.todo.TodoMainActivity;
import com.sqa.plannet.adapter.subject.SubjectAdapter;
import com.sqa.plannet.model.Subject;

import java.util.ArrayList;
import java.util.List;

public class SubjectViewActivity extends AppCompatActivity implements View.OnClickListener , NavigationView.OnNavigationItemSelectedListener{
    private AppBarLayout appBarLayout;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Toolbar toolbar;
    private FloatingActionButton addBtn;
    private RecyclerView recyclerView;
    private SubjectAdapter subjectAdapter;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    public static String TABLE_SUBJECT = "subject";



    private Menu subMenu;
    private boolean isExpanded = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subject_view);
        initUI();
//        initToolbar();

        initDrawer();
        initToolbarAnimation();
        addBtn.setOnClickListener(this);
        navigationView.setNavigationItemSelectedListener(this);


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
        navigationView = findViewById(R.id.nav_home);

    }


    /**
     * TODO: Initiate the toolbar
     */
//    private void initToolbar(){
//
//    }

    /**
     * TODO: Intitialise drawer menu
     */
    private void initDrawer(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setTitle("Subjects");
//        drawerLayout.bringToFront();
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
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
    public static List<Subject> getListSubject(){

        List<Subject> list = new ArrayList<Subject>();
        String sql_select = "SELECT * FROM " + TABLE_SUBJECT;
        Cursor cs = HomeActivity.myDatabase.rawQuery(sql_select);
        list.clear();
        while (cs.moveToNext()){
            int subjectID = cs.getInt(0);
            String subjectTitle = cs.getString(1);
            String subjectNote = cs.getString(2);
            int subjectCredit = cs.getInt(3);
            float attendance = cs.getFloat(4);
            float midterm = cs.getFloat(5);
            float finalTest = cs.getFloat(6);
            Subject subject = new Subject(subjectID, subjectTitle, subjectNote, subjectCredit, attendance, midterm, finalTest);
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
        Intent intent;
        switch (item.getItemId()){
            case R.id.subMenuSetting:
                intent = new Intent(SubjectViewActivity.this, SettingsMenuActivity.class);
                startActivity(intent);
                return true;
            case R.id.navHome:
                intent = new Intent(SubjectViewActivity.this, HomeActivity.class);
                startActivity(intent);
        }
        if (item.getTitle().equals("Add")){
            intent = new Intent(SubjectViewActivity.this, SubjectCreateActivity.class);

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


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navHome:
                Intent intent = new Intent(SubjectViewActivity.this, HomeActivity.class);
                startActivity(intent);
                break;
            case R.id.navOverview:
                Intent i2 = new Intent(SubjectViewActivity.this, OverviewMainActivity.class);
                startActivity(i2);
                break;
            case R.id.navTodo:
                Intent i3 = new Intent(SubjectViewActivity.this, TodoMainActivity.class);
                startActivity(i3);
                break;
            case R.id.navTimetable:
                Intent i4 = new Intent(SubjectViewActivity.this, TimetableViewActivity.class);
                startActivity(i4);
                break;
            case R.id.navCalendar:
                Intent i5 = new Intent(SubjectViewActivity.this, CalendarViewActivity.class);
                startActivity(i5);
                break;
            case R.id.navSubject:
                Intent i6 = new Intent(SubjectViewActivity.this, SubjectViewActivity.class);
                startActivity(i6);
                break;
            case R.id.navTeacher:
                Intent i7 = new Intent(SubjectViewActivity.this, TeacherViewActivity.class);
                startActivity(i7);
                break;
            case R.id.navSettings:
                Intent i8 = new Intent(SubjectViewActivity.this, SettingsAboutActivity.class);
                startActivity(i8);
                break;
            case R.id.navHelp:
                Intent i9 = new Intent(SubjectViewActivity.this, HelpAndFeedbacksActivity.class);
                startActivity(i9);
                break;
            default:
        }
        return true;
    }
}