package com.example.hackathonfinale.database;

import android.app.Service;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.hackathonfinale.entities.Comment;
import com.example.hackathonfinale.entities.User;

import java.util.ArrayList;
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
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[]{KEY_AUTHOR_ID,
                KEY_TEXT}, KEY_ID + "=?", new String[]{
                String.valueOf(id)}, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        Comment currentComment = new Comment(getUserById(cursor.getInt(0)), cursor.getString(1));
        return currentComment;
    }

    @Override
    public List<Object> getAllEntity() {
        List<Object> commentList = new ArrayList<Object>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                Comment comment = new Comment(user, "text");

                comment.setId(cursor.getInt(0));
                comment.setAuthor(getUserById(cursor.getInt(1)));
                comment.setText(cursor.getString(2));
                commentList.add(comment);
            } while (cursor.moveToNext());
        }
        return commentList;
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

        Comment comment = (Comment) object;
        ContentValues values = new ContentValues();
        values.put(KEY_AUTHOR_ID, String.valueOf(comment.getAuthor()));
        values.put(KEY_TEXT, comment.getText());


        db.update(TABLE_NAME, values, KEY_ID + " =?", new String[]{
                String.valueOf(comment.getId())
        });

    }

    @Override
    public void deleteObject(Object object) {
        SQLiteDatabase db = this.getReadableDatabase();
        Comment comment = (Comment) object;
        db.delete(TABLE_NAME, KEY_ID + " =?", new String[]{String.valueOf(comment.getId())});
        db.close();
    }

    @Override
    public void deleteAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        db.delete(TABLE_NAME, null, null);
        db.close();
    }

    private User getUserById(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query("USER", new String[]{"PHONENUMBER",
                "NICKNAME", "PASSWORD"}, "ID" + "=?", new String[]{
                String.valueOf(id)}, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        User currentUser = new User(cursor.getString(0), cursor.getString(1),
                cursor.getString(2), cursor.getString(3));
        return currentUser;
    }
}
