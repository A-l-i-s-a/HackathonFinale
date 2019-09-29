package com.example.hackathonfinale.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.hackathonfinale.entities.Problem;

import java.util.ArrayList;
import java.util.List;

public class ProblemService extends SQLiteOpenHelper implements IDatabaseHandler {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "BANK";
    private static final String TABLE_NAME = "PROBLEM";
    private static final String KEY_ID = "ID";
    private static final String KEY_NAME = "NAME";
    private static final String KEY_DESCRIPTION = "DESCRIPTION";

    public ProblemService(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PROBLEM_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                KEY_NAME + " TEXT," + KEY_DESCRIPTION + " TEXT" + ")";
        db.execSQL(CREATE_PROBLEM_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    @Override
    public void addEntity(Object object) {
        SQLiteDatabase db = this.getReadableDatabase();

        Problem currentProblem = (Problem) object;
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, currentProblem.getName());
        values.put(KEY_DESCRIPTION, currentProblem.getDescription());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    @Override
    public Object getEntity(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[]{KEY_NAME,
                KEY_DESCRIPTION}, KEY_ID + "=?", new String[]{
                String.valueOf(id)}, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        Problem currentUser = new Problem(cursor.getString(0), cursor.getString(1));
        return currentUser;
    }

    @Override
    public List<Object> getAllEntity() {
        List<Object> problemList = new ArrayList<Object>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Problem problem = new Problem();
                problem.setId(cursor.getInt(0));
                problem.setName(cursor.getString(1));
                problem.setDescription(cursor.getString(2));
                problemList.add(problem);
            } while (cursor.moveToNext());
        }
        return problemList;
    }

    @Override
    public int getEntityCount() {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.close();

        return cursor.getCount();
    }

    @Override
    public void updateObject(Object object) {
        SQLiteDatabase db = this.getReadableDatabase();

        Problem problem = (Problem) object;
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, problem.getName());
        values.put(KEY_DESCRIPTION, problem.getDescription());

        db.update(TABLE_NAME, values, KEY_ID + " =?", new String[]{
                String.valueOf(problem.getId())
        });
    }

    @Override
    public void deleteObject(Object object) {
        SQLiteDatabase db = this.getReadableDatabase();
        Problem problem = (Problem) object;
        db.delete(TABLE_NAME, KEY_ID + " =?", new String[]{String.valueOf(problem.getId())});
        db.close();
    }

    @Override
    public void deleteAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        db.delete(TABLE_NAME, null, null);
        db.close();
    }
}
