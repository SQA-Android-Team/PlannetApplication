package com.sqa.plannet.activity.teacher;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;

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
import com.sqa.plannet.activity.settings.SettingsMenuActivity;
import com.sqa.plannet.activity.subject.SubjectCreateActivity;
import com.sqa.plannet.activity.subject.SubjectViewActivity;
import com.sqa.plannet.activity.todo.DetailActivity;
import com.sqa.plannet.activity.todo.TodoMainActivity;
import com.sqa.plannet.adapter.teacher.TeacherAdapter;
import com.sqa.plannet.adapter.todo.TodoTaskAdapter;
import com.sqa.plannet.database.MyDatabase;
import com.sqa.plannet.model.Teacher;

import java.util.ArrayList;
import java.util.List;

import static com.sqa.plannet.activity.home.HomeActivity.myDatabase;

public class TeacherViewActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private AppBarLayout appBarLayout;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Toolbar toolbar;
    private FloatingActionButton addBtn;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ListView listView;
    private TeacherAdapter teacherAdapter;

    private Menu subMenu;
    private boolean isExpanded = true;

    public static ArrayList<Teacher> teacherList;

    public static String TABLE_TEACHER = "teacher" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_view);

        initUI();
        initToolbar();

        //onNavigationItemClick();
        onAddBtnClick();
        initToolbarAnimation();
        initDrawer();
        //initRecyclerView();

        teacherList = getListTeacher();
        teacherAdapter = new TeacherAdapter(TeacherViewActivity.this, R.layout.teacher_item, teacherList);
        listView.setAdapter(teacherAdapter);
        teacherAdapter.notifyDataSetChanged();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TeacherViewActivity.this, TeacherDetailActivity.class);
                intent.putExtra("Teacher", teacherList.get(position));
                startActivity(intent);
            }
        });

        navigationView.setNavigationItemSelectedListener(this::onNavigationItemSelected);
    }

    /**
     * TODO: Initiate all necessary UI elements
     */
    private void initUI(){
        appBarLayout = findViewById(R.id.appBarLayout);
        collapsingToolbarLayout = findViewById(R.id.colToolbar);
        addBtn = findViewById(R.id.fabAdd);
        drawerLayout= findViewById(R.id.teacherViewDrawer);
        navigationView= findViewById(R.id.navTeacherView);
        toolbar = findViewById(R.id.teacherViewToolbar);
        listView = findViewById(R.id.rv_teacher);

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
        getSupportActionBar().setTitle("Teachers");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }


    /**
     * TODO: Allocate all teachers to the RecycleView
     */
//    private void initRecyclerView() {
////        recyclerView.setHasFixedSize(true);
////
////        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
////        recyclerView.setLayoutManager(linearLayoutManager);
//
//        teacherAdapter = new TeacherAdapter();
//        teacherAdapter.setData(getListTeacher());
//        listView.setAdapter(teacherAdapter);
//        teacherAdapter.notifyDataSetChanged();
//    }

    /**
     * TODO: Get a list of all teachers
     * @return Either the list of teachers or null
     */
    private ArrayList<Teacher> getListTeacher() {
        teacherList = new ArrayList<>();

       String sql_select = "SELECT * FROM "  + TABLE_TEACHER;
        Cursor cs = myDatabase.rawQuery(sql_select);
        teacherList.clear();
        while (cs.moveToNext()){
            int teacherID = cs.getInt(0);
            String teacherName = cs.getString(1);
            String phone = cs.getString(2);
            String email = cs.getString(3);
            Teacher teacher = new Teacher(teacherID, teacherName, phone, email);
            teacherList.add(teacher);
        }

        return teacherList;
    }
    /**
     * TODO: add event listener for add button
     */
    private void onAddBtnClick(){
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TeacherViewActivity.this, TeacherCreateActivity.class);
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
                intent = new Intent(TeacherViewActivity.this, SettingsMenuActivity.class);
                startActivity(intent);
                return true;

        }
        if (item.getTitle().equals("Add")){
            intent = new Intent(TeacherViewActivity.this, TeacherCreateActivity.class);

            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }







    /**
     * TODO: Set menu drawer item onClick
     */


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent = null;
        switch (item.getItemId()) {
            case R.id.navHome:
                return true;
            case R.id.navTodo:
                return true;
            case R.id.navTimetable:
                return true;
            case R.id.navCalendar:
                intent = new Intent(TeacherViewActivity.this, CalendarViewActivity.class);
                startActivity(intent);
                return true;
            case R.id.navTeacher:
                intent = new Intent(TeacherViewActivity.this, TeacherViewActivity.class);
                startActivity(intent);
                return true;
            case R.id.navSubject:
                intent = new Intent(TeacherViewActivity.this, SubjectViewActivity.class);
                startActivity(intent);
                return true;
            case R.id.navSettings:
                return true;
            case R.id.navHelp:
                return true;
        }
        return true;
    }
}