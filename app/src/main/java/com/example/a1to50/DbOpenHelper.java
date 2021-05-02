package com.example.a1to50;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbOpenHelper {
    private static final String DATABASE_NAME = "InnerDatabase(SQLite).db";
    private static final int DATABASE_VERSION = 1;
    public static SQLiteDatabase mDB;
    private DatabaseHelper mDBHelper;
    private Context mCtx;

    private class DatabaseHelper extends SQLiteOpenHelper{

        public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,int version) {
            super(context,name,factory,version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(DataBases.CreateDB._CREATE0);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+DataBases.CreateDB._TABLENAME0);
            onCreate(sqLiteDatabase);
        }
    }
    public DbOpenHelper(Context context) {
        this.mCtx = context;
    }
    public DbOpenHelper open() throws SQLException {
        mDBHelper = new DatabaseHelper(mCtx,DATABASE_NAME,null,DATABASE_VERSION);
        mDB = mDBHelper.getWritableDatabase();
        return this;
    }
    public void create() {
        mDBHelper.onCreate(mDB);
    }
    public void close() {
        mDB.close();
    }


    public long insertColumn(String nickname,String time) {
        ContentValues values = new ContentValues();
        values.put(DataBases.CreateDB.NICKNAME,nickname);
        values.put(DataBases.CreateDB.TIME,time);
        return mDB.insert(DataBases.CreateDB._TABLENAME0,null,values);
    }

    public Cursor selectColumns() {
        return mDB.query(DataBases.CreateDB._TABLENAME0,null,null,null,null,null,null);
    }
}
