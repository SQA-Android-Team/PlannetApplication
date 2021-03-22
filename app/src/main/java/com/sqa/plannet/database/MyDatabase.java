package com.sqa.plannet.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabase extends SQLiteOpenHelper {


    public MyDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
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

    public int updateTask(String table, ContentValues values, String whereClause, String[] whereArgs){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.update(table, values, whereClause, whereArgs);
    }

    public int deleteTask(String table, String whereClause, String[] whereArgs){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.delete(table, whereClause, whereArgs);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
