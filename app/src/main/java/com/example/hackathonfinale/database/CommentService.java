package com.example.hackathonfinale.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.hackathonfinale.entities.Comment;

import java.util.List;

public class CommentService extends SQLiteOpenHelper implements IDatabaseHandler {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "BANK";
    private static final String TABLE_NAME = "Comment";
    private static final String KEY_ID = "ID";
    private static final String KEY_AUTHOR_ID = "AUTHOR_ID";
    private static final String KEY_TEXT = "TEXT";

    public CommentService(Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                 + KEY_AUTHOR_ID + " TEXT," + KEY_TEXT  + "  TEXT" + ")";
        db.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    @Override
    public void addEntity(Object object) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        Comment currentComment =(Comment) object;
        values.put(KEY_AUTHOR_ID, currentComment.getAuthor().getId());
        values.put(KEY_TEXT, currentComment.getText());

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
