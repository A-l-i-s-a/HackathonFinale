package com.example.hackathonfinale.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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


    public UserService(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onCreate(Object object) {

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
