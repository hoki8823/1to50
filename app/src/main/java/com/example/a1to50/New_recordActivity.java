package com.example.a1to50;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class New_recordActivity extends AppCompatActivity {

    TextView new_record_text;
    Button btn_ok,btn_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_record_dialog);

        Intent intent = getIntent();
        String time_text = intent.getStringExtra("time_text");

        new_record_text=(TextView) findViewById(R.id.new_record_text);
        btn_ok=(Button)findViewById(R.id.btn_ok);
        btn_no=(Button)findViewById(R.id.btn_no);

        new_record_text.setText(time_text);
    }
    public void mOk(View v){
        finish();
    }
    public void mNo(View v){
        finish();
    }
    public boolean onTouchEvent(MotionEvent event){
        //바깥레이어 클릭시 안닫히게설정
        if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }
    public void onBackPressed() {
        //뒤로가기버튼막기
        return;
    }
}
