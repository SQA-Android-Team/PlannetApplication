package com.sqa.plannet.adapter.todo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.sqa.plannet.R;
import com.sqa.plannet.activity.todo.CreateActivity;
import com.sqa.plannet.activity.todo.DetailActivity;
import com.sqa.plannet.activity.todo.TodoMainActivity;
import com.sqa.plannet.activity.todo.UpdateActivity;
import com.sqa.plannet.database.MyDatabase;
import com.sqa.plannet.model.Task;

import java.util.ArrayList;
import java.util.List;

import static com.sqa.plannet.activity.todo.TodoMainActivity.TABLE_NAME;
import static com.sqa.plannet.activity.todo.TodoMainActivity.getAllTask;
import static com.sqa.plannet.activity.todo.TodoMainActivity.myDatabase;

public class TodoTaskAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<Task> list ;

    public TodoTaskAdapter(Activity context, int item_does, ArrayList<Task> list) {
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
        RadioButton check = view.findViewById(R.id.check);
        TextView titledoes =  view.findViewById(R.id.titledoes);
        TextView typedoes =  view.findViewById(R.id.typedoes);
        TextView datedoes =  view.findViewById(R.id.txtvDate);
        TextView timedoes = view.findViewById(R.id.timedoes);
        ImageButton btnEdit =  view.findViewById(R.id.btnEdit);
        ImageButton btnDelete = view.findViewById(R.id.btnDelete);
        LinearLayout lntask = view.findViewById(R.id.lntask);

        Task task = list.get(position);
        titledoes.setText(task.getTitle());
        timedoes.setText(task.getTime());
        typedoes.setText(task.getType());


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

        lntask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                context.startActivity(intent);
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check.isChecked()){
                    check.setChecked(true);
                }else{
                    check.setChecked(false);
                }
            }
        });

        return view;
    }

    public void dialogClick(int id) {
        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle("Confirm");
        alert.setMessage("Do you want to delete this task ?");
        alert.setIcon(R.drawable.ic_delete);

        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Task task = list.get(id);
                int id = task.getId();
                String delete =  "DELETE FROM " + TABLE_NAME + " WHERE id = " + id;
                myDatabase.excuteSQL(delete);
                list.remove(id);
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
