package com.sqa.plannet.adapter.todo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sqa.plannet.R;
import com.sqa.plannet.activity.todo.UpdateActivity;
import com.sqa.plannet.model.Task;

import java.util.ArrayList;
import java.util.List;


import static com.sqa.plannet.activity.home.HomeActivity.myDatabase;
import static com.sqa.plannet.activity.todo.TodoMainActivity.TABLE_TASK;
import static com.sqa.plannet.activity.todo.TodoMainActivity.getAllTask;

public class TodoTaskAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<Task> list ;
    Task task;

    public TodoTaskAdapter(Activity context, int todo_item_does, ArrayList<Task> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) { return list.get(position); }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.todo_item_does, null);
        CheckBox check = view.findViewById(R.id.check);
        TextView titledoes =  view.findViewById(R.id.titledoes);
        TextView done =  view.findViewById(R.id.done);
        TextView typedoes =  view.findViewById(R.id.typedoes);
        TextView timedoes = view.findViewById(R.id.timedoes);
        ImageButton btnEdit =  view.findViewById(R.id.btnEdit);
        ImageButton btnDelete = view.findViewById(R.id.btnDelete);
        LinearLayout lntask = view.findViewById(R.id.lntask);

//        LinearLayout completeTask = view.findViewById(R.id.completeTask);
//        TextView titledoes1 =  view.findViewById(R.id.titledoes1);
//        TextView typedoes1 =  view.findViewById(R.id.typedoes1);
//        TextView timedoes1 = view.findViewById(R.id.timedoes1);

        task = list.get(position);
        titledoes.setText(task.getTitle());
        timedoes.setText(task.getTime());
        typedoes.setText(task.getType());

//        titledoes1.setText(task.getTitle());
//        timedoes1.setText(task.getTime());
//        typedoes1.setText(task.getType());


        String Trang = typedoes.getText().toString();
        if (Trang.equals("Homework")) {
            typedoes.setBackgroundResource(R.drawable.btn_button_blue);
        }else if(Trang.equals("Fun")){
            typedoes.setBackgroundResource(R.drawable.btn_button_green);
        }else if(Trang.equals("School")){
            typedoes.setBackgroundResource(R.drawable.btn_button_orange);
        }else if(Trang.equals("Others")){
            typedoes.setBackgroundResource(R.drawable.btn_button_purple);
        }

//        String Trang1 = typedoes1.getText().toString();
//        if (Trang1.equals("Homework")) {
//            typedoes1.setBackgroundResource(R.drawable.btn_button_blue);
//        }else if(Trang1.equals("Fun")){
//            typedoes1.setBackgroundResource(R.drawable.btn_button_green);
//        }else if(Trang1.equals("School")){
//            typedoes1.setBackgroundResource(R.drawable.btn_button_orange);
//        }else if(Trang1.equals("Others")){
//            typedoes1.setBackgroundResource(R.drawable.btn_button_purple);
//        }

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( context, "edit" + task.getId(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("TaskEdit", task);
                context.startActivity(intent);
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogClick(position);
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check.isChecked()) {
                    check.setBackgroundResource(R.drawable.btn_complete);
                    done.setVisibility(View.VISIBLE);
                } else if(!check.isChecked()) {
                    done.setVisibility(View.GONE);
                    check.setBackgroundResource(R.drawable.btn_button_white);
                    notifyDataSetChanged();
                }
            }
        });
        return view;
    }

    public void dialogClick(int position) {
        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle("Confirm");
        alert.setMessage("Do you want to delete this task ?");
        alert.setIcon(R.drawable.ic_delete);

        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Task task = list.get(position);
                int id = task.getId();
                list.remove(position);
                String delete =  "DELETE FROM " + TABLE_TASK + " WHERE id = " + task.getId();
                myDatabase.excuteSQL(delete);

                notifyDataSetChanged();
                Toast.makeText(context, "Delete Successfull", Toast.LENGTH_SHORT).show();
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alert.show();
    }

}