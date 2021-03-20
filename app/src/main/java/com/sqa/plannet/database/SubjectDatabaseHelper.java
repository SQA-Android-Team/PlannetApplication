package com.sqa.plannet.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SubjectDatabaseHelper  extends SQLiteOpenHelper {

        private Context context;

        private static final String DATABASE_NAME = "MyDatabase.db";
        private static final int DATABASE_VERSION = 1;
        private static final String TABLE_NAME = "subject";
        private static final String COL_ID = "subjectID";
        private static final String COL_TITLE = "subjectTitle";
        private static final String COL_CREDIT = "subjectCredit";
        private static final String COL_NOTE = "subjectNote";
        private static final String COL_ATT = "attendance";
        private static final String COL_MID = "midterm";
        private static final String COL_FIN = "final";
        private static final String COL_OBJ = "objective";


        public SubjectDatabaseHelper(@Nullable Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            String sql = "CREATE TABLE " + TABLE_NAME
                    + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_TITLE + " TEXT, "
                    + COL_CREDIT + " INTEGER, "
                    + COL_NOTE + " TEXT, "
                    + COL_ATT + " REAL, "
                    + COL_MID + " REAL, "
                    + COL_FIN + " REAL, "
                    + COL_OBJ + " TEXT);";

            db.execSQL(sql);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }

