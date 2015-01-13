package com.intro.introapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jesse on 2014-12-30.
 */
public class UserInfoAdapter {

    UserInfo helper;
    public UserInfoAdapter(Context context) {

        helper = new UserInfo(context);
    }

    public boolean insertUser (String user, String password){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        try {
            cv.put(UserInfo.USER, user);
            cv.put(UserInfo.PASSWORD, password);

            db.insert(UserInfo.TABLE_NAME, null, cv);

        } catch (Exception e) {
            e.getMessage();
            return false;
        }
        return true;
    }

    static class UserInfo extends SQLiteOpenHelper {
        private static final int DATABASE_VERSION = 2;
        private static final String DATABASE_NAME = "userInfo";
        private static final String TABLE_NAME = "USERS";
        private static final String USER = "_user";
        private static final String PASSWORD = "Password";
        private Context context;
        private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
                "(" + USER + " VARCHAR(20) PRIMARY KEY, "+ PASSWORD +" VARCHAR(30));";
        private static final String DELETE_TABLE = "DROP TABLE IF EXISTS "+ TABLE_NAME;

        public UserInfo(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(CREATE_TABLE);
            } catch (android.database.SQLException e) {
                e.getMessage();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                db.execSQL(DELETE_TABLE);
                onCreate(db);
            } catch (android.database.SQLException e) {
                e.getMessage();
            }
        }
    }
}
