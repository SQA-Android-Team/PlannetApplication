package com.sqa.plannet.adapter.subject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sqa.plannet.R;
import com.sqa.plannet.model.Subject;

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

    }

    @Override
    public int getItemCount() {
        if (this.listSubject != null){
            return this.listSubject.size();
        }
        return 0;
    }

    public class SubjectViewHolder extends RecyclerView.ViewHolder{

        private TextView subjectTitle;
        public SubjectViewHolder(@NonNull View view){
            super(view);
            subjectTitle = view.findViewById(R.id.subjectTitle);

        }




    }
}
