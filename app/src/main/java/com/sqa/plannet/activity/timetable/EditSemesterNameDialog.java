package com.sqa.plannet.activity.timetable;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.sqa.plannet.R;

public class EditSemesterNameDialog extends AppCompatDialogFragment {
    private EditText editSemesterName;
    private EditSemesterNameListener listener;


    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.timetable_layout_edit_semester_name, null);

        builder.setView(view)
                .setTitle("Semester Name")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                })
                .setPositiveButton("Finish", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String semesterName = editSemesterName.getText().toString();
                        listener.applyText(semesterName);

                    }
                });

        editSemesterName = view.findViewById(R.id.editSemesterName);
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try{
            listener = (EditSemesterNameListener) context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString() + "must implement EditSemesterNameListener");
        }

    }

    public interface EditSemesterNameListener{
        void applyText(String semesterName);
    }
}
