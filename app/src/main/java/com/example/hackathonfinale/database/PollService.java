package com.example.hackathonfinale.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.hackathonfinale.entities.Poll;

import java.util.List;

public class PollService extends SQLiteOpenHelper implements IDatabaseHandler {

    private static final int DATABESE_VERSION = 1;

    private static final String DATABASE_NAME = "BANK";
    private static final String TABLE_NAME = "POLL";
    private static final String KEY_ID = "ID";
    private static final String KEY_PROBLEM_ID = "PROBLEM_ID";

    public PollService(Context context){
        super(context, DATABASE_NAME, null, DATABESE_VERSION)
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                KEY_PROBLEM_ID + " INTEGER" + ")";
        db.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    @Override
    public void addEntity(Object object) {
        SQLiteDatabase db = this.getReadableDatabase();

        Poll poll = (Poll) object;
        ContentValues values = new ContentValues();
        values.put(KEY_ID, poll.getPhoneNumber());
        values.put(KEY_NICKNAME, poll.getNickname());
        values.put(KEY_PASSWORD, poll.getPassword());
        values.put(KEY_TYPE, poll.getType());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    @Override
    public Object getEntity(int id) {
        return null;
    }

    @Override
    public List<Object> getAllEntity() {
        return null;
    }

    @Override
    public int getEntityCount() {
        return 0;
    }

    @Override
    public void updateObject(Object object) {

    }

    @Override
    public void deleteObject(Object object) {

    }

    @Override
    public void deleteAll() {

    }
}
