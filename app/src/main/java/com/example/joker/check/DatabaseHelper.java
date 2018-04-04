package com.example.joker.check;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.IBinder;


public class DatabaseHelper extends SQLiteOpenHelper{
public static final String DATABASE_NAME="register.db";
    public static final String TABLE_NAME="register";
    public static final String COL1="ID";
    public static final String COL2="FirstName";
    public static final String COL3="LastName";
    public static final String COL4="Email";
    public static final String COL5="Phone";
    public static final String COL6="Password";
    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL("create table "+TABLE_NAME+"(ID integer primary key AUTOINCREMENT,FirstName text ,LastName text,Email text,Phone text,Password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
db.execSQL("Drop table if EXISTS "+TABLE_NAME);
onCreate(db);
    }
}
