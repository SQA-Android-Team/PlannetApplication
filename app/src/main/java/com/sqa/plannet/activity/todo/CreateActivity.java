package com.sqa.plannet.activity.todo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.sqa.plannet.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class CreateActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvType, tvDate, tvTime;
    EditText edtDo, edtLocation, edtNote;
    Switch swRemind, swImportant;
    Button btnCreate;
    ImageButton    btnBack;
    boolean[] selectedType;
    ArrayList<Integer> typeList = new ArrayList<>();
    String[] typeArray = {"Homework", "Fun", "School", "Others"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getSupportActionBar().hide();
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.todo_create);
        mapping();

        //Initialze selected type array
        selectedType = new boolean[typeArray.length];

        tvType.setOnClickListener(this);
        tvDate.setOnClickListener(this);
        tvTime.setOnClickListener(this);
        btnCreate.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        btnCreate.setOnClickListener(this);
    }

    private void mapping() {
        tvType = findViewById(R.id.tvType);
        tvDate = findViewById(R.id.tvDate);
        tvTime = findViewById(R.id.tvTime);
        edtDo = findViewById(R.id.edtDo);
        edtLocation = findViewById(R.id.edtLocation);
        edtNote = findViewById(R.id.edtNote);
        swRemind = findViewById(R.id.swRemind);
        swImportant = findViewById(R.id.swImportant);
        btnCreate = findViewById(R.id.btnCreate);
        btnBack = findViewById(R.id.btnBack);

    }

    @Override
    public void onClick(View view) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        switch (view.getId()) {
            case R.id.tvDate:
                DatePickerDialog datePickerDialog = new DatePickerDialog(CreateActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                                Calendar chooseDate = Calendar.getInstance();
                                chooseDate.set(year, month, dayOfMonth);
                                String strDate = simpleDateFormat.format(chooseDate.getTime());
                                tvDate.setText(strDate);
                            }
                        }, year, month, day
                );
                datePickerDialog.show();
                break;
            case R.id.tvTime:
                TimePickerDialog timePickerDialog = new TimePickerDialog(CreateActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                                Calendar chooseTime = Calendar.getInstance();
                                chooseTime.set(0, 0, 0, hourOfDay, minute);
                                String strTime = simpleDateFormat.format(chooseTime.getTime());
                                tvTime.setText(strTime);
                            }
                        }, hour, minute, true
                );
                timePickerDialog.show();
                break;
            case R.id.tvType:
                AlertDialog.Builder builder = new AlertDialog.Builder(CreateActivity.this);
                //set title
                builder.setTitle("Select Type");
                //set dialog non cancelable
                builder.setCancelable(false);

                builder.setMultiChoiceItems(typeArray, selectedType, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        //check condition
                        if (isChecked) {
                            //when checkbox selected
                            //add position in type list
                            typeList.add(which);
                            //sort type list
                            Collections.sort(typeList);
                        } else {
                            //when checkbox unselected
                            //remove position from type list
                            typeList.remove(which);
                        }
                    }
                });
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Initialize string builder
                        StringBuilder stringBuilder = new StringBuilder();
                        //use for loop
                        for (int j = 0; j < typeList.size(); j++) {
                            //concat array value
                            stringBuilder.append(typeArray[typeList.get(j)]);
                            //check condition
                            if (j != typeList.size() - 1) {
                                stringBuilder.append(", ");
                            }
                        }
                        //Set text on text view
                        tvType.setText(stringBuilder.toString());
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                builder.setNeutralButton("Clear All", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //use for loop
                        for (int j = 0; j < selectedType.length; j++) {
                            //remove all selection
                            selectedType[j] = false;
                            //clear type list
                            typeList.clear();
                            //clear text view value
                            tvType.setText("");
                        }
                    }
                });
                //Show dialog
                builder.show();
                break;
            case R.id.btnBack:
                cancel(btnBack);
                break;
            case R.id.btnCreate:
                create(btnCreate);
                break;
            default:
        }
    }

    public void create(View view) {
        String type = tvType.getText().toString();
        String does = edtDo.getText().toString();
        String location = edtLocation.getText().toString();
        String time = tvTime.getText().toString();
        String date = tvDate.getText().toString();
        String note = edtNote.getText().toString();
        boolean remind;
        if (swRemind.isChecked())
            remind = true;
        else
            remind = false;
        boolean important;
        if (swImportant.isChecked())
            important = true;
        else
            important = false;
        ContentValues contentValues = new ContentValues();
       // contentValues.put("id", type);
        contentValues.put("title", does);
        contentValues.put("type", type);
        contentValues.put("location", location);
        contentValues.put("time", time);
        contentValues.put("note", note);
        contentValues.put("remind", remind);
        contentValues.put("important", important);
        TodoMainActivity.myDatabase.insertTask(TodoMainActivity.TABLE_NAME, null, contentValues);
        Toast.makeText(this, "" + contentValues , Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(CreateActivity.this, TodoMainActivity.class);
        startActivity(intent);
    }

    public void cancel(View view) {
        Intent intent = new Intent(CreateActivity.this, TodoMainActivity.class);
        startActivity(intent);
    }


}



