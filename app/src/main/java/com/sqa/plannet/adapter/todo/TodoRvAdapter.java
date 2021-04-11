package com.sqa.plannet.adapter.todo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sqa.plannet.R;
import com.sqa.plannet.activity.todo.UpdateActivity;
import com.sqa.plannet.model.Task;

import java.util.List;

import static com.sqa.plannet.activity.home.HomeActivity.myDatabase;
import static com.sqa.plannet.activity.todo.TodoMainActivity.TABLE_TASK;

public class TodoRvAdapter  extends  RecyclerView.Adapter<TodoRvAdapter.TodoViewHolder>{

    List<Task> todoList;

    public void setData(List<Task> list){
        this.todoList = list;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_item_does, parent, false);

        return new TodoRvAdapter.TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        Task task = todoList.get(position);

        if (task == null){
            return;
        }
        holder.titledoes.setText(task.getTitle());
        holder.timedoes.setText(task.getTime());
        holder.typedoes.setText(task.getType());
        holder.task = task;
        holder.position =position;



        if (task.getType().equals("Homework")) {
            holder.typedoes.setBackgroundResource(R.drawable.btn_button_blue);
        }else if(task.getType().equals("Fun")){
            holder.typedoes.setBackgroundResource(R.drawable.btn_button_green);
        }else if(task.getType().equals("School")){
            holder.typedoes.setBackgroundResource(R.drawable.btn_button_orange);
        }else if(task.getType().equals("Others")){
            holder.typedoes.setBackgroundResource(R.drawable.btn_button_purple);
        }



    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    public class TodoViewHolder extends RecyclerView.ViewHolder{
        private CheckBox check ;
        private TextView titledoes ,typedoes, timedoes ;
        private ImageButton btnEdit, btnDelete;
        private LinearLayout lntask;
        private Context context;

        private int position;
        private Task task;


        public TodoViewHolder(@NonNull View view) {
            super(view);

            check = view.findViewById(R.id.check);
            titledoes =  view.findViewById(R.id.titledoes);
             typedoes =  view.findViewById(R.id.typedoes);
             timedoes = view.findViewById(R.id.timedoes);
                btnEdit =  view.findViewById(R.id.btnEdit);
             btnDelete = view.findViewById(R.id.btnDelete);
             lntask = view.findViewById(R.id.lntask);
             context = view.getContext();


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
        }

        public void dialogClick(int position) {
            AlertDialog.Builder alert = new AlertDialog.Builder(context);
            alert.setTitle("Confirm");
            alert.setMessage("Do you want to delete this task ?");
            alert.setIcon(R.drawable.ic_delete);

            alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Task task = todoList.get(position);
                    int id = task.getId();
                    todoList.remove(position);
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
}
