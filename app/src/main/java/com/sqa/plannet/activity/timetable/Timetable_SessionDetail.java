package com.sqa.plannet.activity.timetable;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sqa.plannet.R;

public class Timetable_SessionDetail extends AppCompatActivity{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.timetable_session_detail);
    }
}
//
//import android.content.DialogInterface;
//import android.os.Bundle;
//import android.os.PersistableBundle;
//import android.view.View;
//import android.widget.ImageButton;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AlertDialog;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.sqa.plannet.R;
//
//
//public class Timetable_SessionDetail extends AppCompatActivity {
//
//    private ImageButton btnDelete;
//    private ImageButton btnEdit;
//    private ImageButton btnBack;
//    private LinearLayout SNContainer;
//    private TextView txtSessionNameValue;
//
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
//        super.onCreate(savedInstanceState, persistentState);
//        setContentView(R.layout.timetable_session_detail);
////
////        txtSessionNameValue = txtSessionNameValue.findViewById(R.id.txtSessionNameValue);
////
////        txtSessionNameValue.setText("abc");
//        initUI();
//        onBackBtnClick();
//        onDeleteBtn();
//
//
//
//    }
//    /**
//     * TODO: initialise all necessary UI elements
//     */
//    private void initUI(){
//        btnBack = findViewById(R.id.btnBack);
//        btnDelete = findViewById(R.id.btnDelete);
//        btnEdit = findViewById(R.id.btnEdit);
//    }
//    /**
//     * TODO:  add event listener for backBtn
//     */
//    private void onBackBtnClick() {
//        btnBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        });
//    }
//    /**
//     * TODO: add event listener for delete button
//     * INCOMPLETE
//     */
//    private void onDeleteBtn(){
//        btnDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                AlertDialog deleteConfirm = new AlertDialog.Builder(Timetable_SessionDetail.this)
//                        .setTitle("Confirmation")
//                        .setMessage("Do you really want to delete this Session?")
//                        .setIcon(R.drawable.ic_baseline_delete_24)
//                        .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int i) {
//                                // deleting code
//                                dialog.dismiss();
//                            }
//                        })
//                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int i) {
//                                dialog.dismiss();
//                            }
//                        })
//                        .create();
//
//                deleteConfirm.show();
//
//            }
//        });
//    }
//}
