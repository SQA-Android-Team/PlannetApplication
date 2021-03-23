package com.sqa.plannet.adapter.todo;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter {
    private Context context;
    private Activity activity;
    private ArrayList task_id;
    private TextView titledoes, typedoes, timedoes;
    private ImageView pic;

    public CustomAdapter(Context context, Activity activity, ArrayList task_id, TextView titledoes, TextView typedoes, TextView timedoes, ImageView pic) {
        this.context = context;
        this.activity = activity;
        this.task_id = task_id;
        this.titledoes = titledoes;
        this.typedoes = typedoes;
        this.timedoes = timedoes;
        this.pic = pic;
    }




}
