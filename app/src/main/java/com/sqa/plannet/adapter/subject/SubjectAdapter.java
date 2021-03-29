package com.sqa.plannet.adapter.subject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sqa.plannet.R;
import com.sqa.plannet.activity.subject.SubjectCreateActivity;
import com.sqa.plannet.activity.subject.SubjectDetailActivity;
import com.sqa.plannet.model.Subject;

import java.nio.file.LinkPermission;
import java.util.List;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder> {
    private List<Subject> listSubject;
    public void setData(List<Subject> list){
        this.listSubject = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SubjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subject_item, parent, false);

        return new SubjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectViewHolder holder, int position) {
        Subject subject = listSubject.get(position);
        if (subject == null){
            return;
        }
        holder.subjectTitle.setText(subject.getSubjectTitle());
        holder.subject = subject;
        holder.position = position;

    }

    @Override
    public int getItemCount() {
        if (this.listSubject != null){
            return this.listSubject.size();
        }
        return 0;
    }

    public class SubjectViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private Subject subject;
        private int position;
        private TextView subjectTitle;
        private final Context context;
        public SubjectViewHolder(@NonNull View view){
            super(view);
            subjectTitle = view.findViewById(R.id.subjectTitle);
            context = view.getContext();
            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            Intent intent = new Intent(context, SubjectDetailActivity.class);
            intent.putExtra("subject", subject);
            intent.putExtra("position", position);
            context.startActivity(intent);
        }
    }
}
