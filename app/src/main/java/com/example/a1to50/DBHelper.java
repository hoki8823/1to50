package com.example.a1to50;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {


    private Context context;
    private static final String DATABASE_NAME = "Practice.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "rank";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NICK= "nick";
    private static final String COLUMN_TIME = "time";

    public DBHelper(@Nullable Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String query = "CREATE TABLE " + TABLE_NAME
                + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NICK + " TEXT, "
                + COLUMN_TIME + " TEXT); ";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addRank(String nick, String time) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NICK, nick);
        cv.put(COLUMN_TIME, time);
        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1)
        {
            Toast.makeText(context, "기록 등록 실패", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(context, "기록 등록 성공", Toast.LENGTH_SHORT).show();
        }
    }
    public Cursor loadRank() {
        SQLiteDatabase db = this.getReadableDatabase();
        db.beginTransaction();
        // Select All Query
        String selectQuery = "SELECT _id,nick,time FROM " + TABLE_NAME + " order by time asc";
        Cursor cursor = null;
        try {
            cursor = db.rawQuery(selectQuery, null);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
        return cursor;
    }
}
