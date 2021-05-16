package com.example.a1to50;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Old_recordActivity extends AppCompatActivity {
    SQLiteDatabase db;
    DBHelper dbHelper;
    TextView new_record_text,old_record_text;
    EditText nickname_text;
    Button btn_ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.old_record_dialog);

        Intent intent = getIntent();
        String time_text = intent.getStringExtra("time_text");

        new_record_text = (TextView) findViewById(R.id.new_record_text);
        old_record_text = (TextView) findViewById(R.id.old_record_text);
        nickname_text = (EditText) findViewById(R.id.nickname_text);
        btn_ok = (Button) findViewById(R.id.btn_ok);
        old_record_text.setText(time_text);


        dbHelper = new DBHelper(this);
        db = dbHelper.getReadableDatabase();
        db.beginTransaction();

        Cursor cursor = dbHelper.loadRank();
        try{
            cursor.moveToFirst();
            new_record_text.setText(cursor.getString(2));
            db.setTransactionSuccessful();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(cursor!=null) {
                cursor.close();
                db.endTransaction();
            }
        }

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public boolean onTouchEvent(MotionEvent event) {
        //바깥레이어 클릭시 안닫히게설정
        if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
            return false;
        }
        return true;
    }

    public void onBackPressed() {
        //뒤로가기버튼막기
        return;
    }
}
