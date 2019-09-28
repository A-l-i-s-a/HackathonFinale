package com.example.hackathonfinale.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.hackathonfinale.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserService extends SQLiteOpenHelper implements IDatabaseHandler {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "BANK";
    private static final String TABLE_NAME = "USER";
    private static final String KEY_ID = "ID";
    private static final String KEY_PHONENUMBER = "PHONENUMBER";
    private static final String KEY_NICKNAME = "NICKNAME";
    private static final String KEY_PASSWORD = "PASSWORD";
    private static final String KEY_TYPE = "TYPE";


    public UserService(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                KEY_PHONENUMBER + " TEXT," + KEY_NICKNAME + " TEXT," + KEY_PASSWORD + " TEXT," +
                KEY_TYPE + " TEXT" + ")";
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

        User currentUser = (User) object;
        ContentValues values = new ContentValues();
        values.put(KEY_PHONENUMBER, currentUser.getPhoneNumber());
        values.put(KEY_NICKNAME, currentUser.getNickname());
        values.put(KEY_PASSWORD, currentUser.getPassword());
        values.put(KEY_TYPE, currentUser.getType());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    @Override
    public Object getEntity(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[]{KEY_PHONENUMBER,
                KEY_NICKNAME, KEY_PASSWORD}, KEY_ID + "=?", new String[]{
                String.valueOf(id)}, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        User currentUser = new User(cursor.getString(0), cursor.getString(1),
                cursor.getString(2), cursor.getString(3));
        return currentUser;
    }

    @Override
    public List<Object> getAllEntity() {
        List<Object> userList = new ArrayList<Object>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(cursor.getInt(0));
                user.setPhoneNumber(cursor.getString(1));
                user.setNickname(cursor.getString(2));
                user.setPassword(cursor.getString(3));
                user.setType(cursor.getString(4));
                userList.add(user);
            } while (cursor.moveToNext());
        }
        return userList;
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

        User user = (User) object;
        ContentValues values = new ContentValues();
        values.put(KEY_PHONENUMBER, user.getPhoneNumber());
        values.put(KEY_NICKNAME, user.getNickname());
        values.put(KEY_PASSWORD, user.getPassword());
        values.put(KEY_TYPE, user.getType());

        db.update(TABLE_NAME, values, KEY_ID + " =?", new String[]{
                String.valueOf(user.getId())
        });
    }

    @Override
    public void deleteObject(Object object) {
        SQLiteDatabase db = this.getReadableDatabase();
        User user = (User) object;
        db.delete(TABLE_NAME, KEY_ID + " =?", new String[]{String.valueOf(user.getId())});
        db.close();
    }

    @Override
    public void deleteAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        db.delete(TABLE_NAME, null, null);
        db.close();
    }
}
