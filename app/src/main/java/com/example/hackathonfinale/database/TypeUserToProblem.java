package com.example.hackathonfinale.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

public class TypeUserToProblem extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "BANK";
    private static final String TABLE_NAME = "TYPEUSERTOPROBLEM";
    private static final String KEY_TYPE = "TYPE";
    private static final String KEY_PROBLEM_ID = "PROBLEM_ID";

    public TypeUserToProblem(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + KEY_TYPE + " TEXT PRIMARY KEY AUTOINCREMENT," +
                KEY_PROBLEM_ID + " INTEGER" + ")";
        db.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

}
