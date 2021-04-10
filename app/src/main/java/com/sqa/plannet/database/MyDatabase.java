package com.sqa.plannet.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.sqa.plannet.activity.todo.TodoMainActivity;

public class MyDatabase extends SQLiteOpenHelper {

Context context;
    public MyDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    //create, update, delete
    public void excuteSQL(String sql){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        sqLiteDatabase.execSQL(sql);
    }
    //read
    public Cursor rawQuery(String sql){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Cursor c = sqLiteDatabase.rawQuery(sql, null);
        return c;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    public long insertTask(String table, String nullColumnHack, ContentValues values){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.insert(table, nullColumnHack, values);
    }

    public  void  updateTask(String row_id, String title, String type, String location, String time, String date, String note, int remind, int important){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
                contentValues.put("title", title);
                contentValues.put("type", type);
                contentValues.put("location", location);
                contentValues.put("time", time);
                contentValues.put("date", date);
                contentValues.put("note", note);
                contentValues.put("remind", remind);
                contentValues.put("important", important);
        long result = sqLiteDatabase.update("tasks", contentValues, "id=?", new String[]{row_id});
        if (result == -1) {
            Toast.makeText(context, "Fail", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Successfull", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
