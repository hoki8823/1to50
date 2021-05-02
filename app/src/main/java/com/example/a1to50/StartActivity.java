package com.example.a1to50;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.Random;

public class StartActivity extends AppCompatActivity {
    RelativeLayout[] btn = new RelativeLayout[25];
    TextView[] btn_text = new TextView[25];
    Button btn_back,btn_regame;
    TextView time_text,new_record_text;
    EditText nickname_text;

    private Thread timeThread = null;
    boolean isRunning = true;

    View dialogView1,dialogView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        fv();   //findview 꼴보기싫으니 따로 만듬

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        btn_regame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),StartActivity.class);
                startActivity(intent);
            }
        });
        timeThread = new Thread(new timeThread());
        timeThread.start(); //스탑워치실행
        game(); //번호를 랜덤하게 집어넣는 역할
        btn_click();    //숫자클릭시 이벤트
    }

    int num_page, page_num;

    private void game() {
        for (num_page = 1; num_page <= 2; num_page++) {
            for (page_num = 1; page_num <= 25; page_num++) {
                random();
            }
        }
        for (int print_btn_num = 0; print_btn_num <= 24; print_btn_num++) {
            btn_text[print_btn_num].setText(Integer.toString(btn_num_01[print_btn_num]));
        }
    }

    int match_num_int = 1;  //눌러야되는 숫자
    int random_btn_num_int; //랜덤한 숫자를 갖고있을 변수
    int[] btn_num_01 = new int[25]; //1~25
    int[] btn_num_02 = new int[25]; //26~50

    private void random() {
        Random random = new Random();
        random_btn_num_int = random.nextInt(25);
        if (num_page == 1 && btn_num_01[random_btn_num_int] == 0) {
            btn_num_01[random_btn_num_int] = page_num;
        } else if (num_page == 1 && page_num <= 25) {
            random();   //숫자가 배열에 저장될때까지 랜덤함수 재실행
        }
        if (num_page == 2 && btn_num_02[random_btn_num_int] == 0) {
            btn_num_02[random_btn_num_int] = page_num + 25;
        } else if (num_page == 2 && page_num <= 25) {
            random();   //숫자가 배열에 저장될때까지 랜덤함수 재실행
        }
    }

    private void btn_click() {
        for (int i = 0; i < 25; i++) {
            final int j = i;
            btn[j].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (match_num_int == 1) {  //게임이 종료됬을때 이벤트 지정
                        isRunning=!isRunning;

                        new_record();

                    }
                    if (match_num_int == btn_num_01[j]) {
                        match_num_int++;
                        btn_text[j].setText(Integer.toString(btn_num_02[j]));
                    }
                    if (match_num_int == btn_num_02[j]) {
                        match_num_int++;
                        btn_text[j].setVisibility(View.GONE);
                    }
                }
            });
        }
    }

    private void fv() {
        time_text=(TextView)findViewById(R.id.time_text);
        btn_back=(Button)findViewById(R.id.btn_back);
        btn_regame=(Button)findViewById(R.id.btn_regame);


        btn[0] = (RelativeLayout) findViewById(R.id.btn_page_1);
        btn[1] = (RelativeLayout) findViewById(R.id.btn_page_2);
        btn[2] = (RelativeLayout) findViewById(R.id.btn_page_3);
        btn[3] = (RelativeLayout) findViewById(R.id.btn_page_4);
        btn[4] = (RelativeLayout) findViewById(R.id.btn_page_5);
        btn[5] = (RelativeLayout) findViewById(R.id.btn_page_6);
        btn[6] = (RelativeLayout) findViewById(R.id.btn_page_7);
        btn[7] = (RelativeLayout) findViewById(R.id.btn_page_8);
        btn[8] = (RelativeLayout) findViewById(R.id.btn_page_9);
        btn[9] = (RelativeLayout) findViewById(R.id.btn_page_10);
        btn[10] = (RelativeLayout) findViewById(R.id.btn_page_11);
        btn[11] = (RelativeLayout) findViewById(R.id.btn_page_12);
        btn[12] = (RelativeLayout) findViewById(R.id.btn_page_13);
        btn[13] = (RelativeLayout) findViewById(R.id.btn_page_14);
        btn[14] = (RelativeLayout) findViewById(R.id.btn_page_15);
        btn[15] = (RelativeLayout) findViewById(R.id.btn_page_16);
        btn[16] = (RelativeLayout) findViewById(R.id.btn_page_17);
        btn[17] = (RelativeLayout) findViewById(R.id.btn_page_18);
        btn[18] = (RelativeLayout) findViewById(R.id.btn_page_19);
        btn[19] = (RelativeLayout) findViewById(R.id.btn_page_20);
        btn[20] = (RelativeLayout) findViewById(R.id.btn_page_21);
        btn[21] = (RelativeLayout) findViewById(R.id.btn_page_22);
        btn[22] = (RelativeLayout) findViewById(R.id.btn_page_23);
        btn[23] = (RelativeLayout) findViewById(R.id.btn_page_24);
        btn[24] = (RelativeLayout) findViewById(R.id.btn_page_25);

        btn_text[0] = (TextView) findViewById(R.id.btn_1);
        btn_text[1] = (TextView) findViewById(R.id.btn_2);
        btn_text[2] = (TextView) findViewById(R.id.btn_3);
        btn_text[3] = (TextView) findViewById(R.id.btn_4);
        btn_text[4] = (TextView) findViewById(R.id.btn_5);
        btn_text[5] = (TextView) findViewById(R.id.btn_6);
        btn_text[6] = (TextView) findViewById(R.id.btn_7);
        btn_text[7] = (TextView) findViewById(R.id.btn_8);
        btn_text[8] = (TextView) findViewById(R.id.btn_9);
        btn_text[9] = (TextView) findViewById(R.id.btn_10);
        btn_text[10] = (TextView) findViewById(R.id.btn_11);
        btn_text[11] = (TextView) findViewById(R.id.btn_12);
        btn_text[12] = (TextView) findViewById(R.id.btn_13);
        btn_text[13] = (TextView) findViewById(R.id.btn_14);
        btn_text[14] = (TextView) findViewById(R.id.btn_15);
        btn_text[15] = (TextView) findViewById(R.id.btn_16);
        btn_text[16] = (TextView) findViewById(R.id.btn_17);
        btn_text[17] = (TextView) findViewById(R.id.btn_18);
        btn_text[18] = (TextView) findViewById(R.id.btn_19);
        btn_text[19] = (TextView) findViewById(R.id.btn_20);
        btn_text[20] = (TextView) findViewById(R.id.btn_21);
        btn_text[21] = (TextView) findViewById(R.id.btn_22);
        btn_text[22] = (TextView) findViewById(R.id.btn_23);
        btn_text[23] = (TextView) findViewById(R.id.btn_24);
        btn_text[24] = (TextView) findViewById(R.id.btn_25);
    }

    // 마지막으로 뒤로 가기 버튼을 눌렀던 시간 저장
    private long backKeyPressedTime = 0;
    // 첫 번째 뒤로 가기 버튼을 누를 때 표시
    private Toast toast;

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        // 기존 뒤로 가기 버튼의 기능을 막기 위해 주석 처리 또는 삭제

        // 마지막으로 뒤로 가기 버튼을 눌렀던 시간에 2.5초를 더해 현재 시간과 비교 후
        // 마지막으로 뒤로 가기 버튼을 눌렀던 시간이 2.5초가 지났으면 Toast 출력
        // 2500 milliseconds = 2.5 seconds
        if (System.currentTimeMillis() > backKeyPressedTime + 2500) {
            backKeyPressedTime = System.currentTimeMillis();
            toast = Toast.makeText(this, "한 번 더 누르시면 메인화면으로 이동합니다.", Toast.LENGTH_LONG);
            toast.show();
            return;
        }
        // 마지막으로 뒤로 가기 버튼을 눌렀던 시간에 2.5초를 더해 현재 시간과 비교 후
        // 마지막으로 뒤로 가기 버튼을 눌렀던 시간이 2.5초가 지나지 않았으면 종료
        if (System.currentTimeMillis() <= backKeyPressedTime + 2500) {
            finish();
            toast.cancel();

            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            int mSec = msg.arg1 % 100;
            int sec = (msg.arg1 / 100) % 60;
            int min = (msg.arg1 / 100) / 60;
            //1000이 1초 1000*60 은 1분 1000*60*10은 10분 1000*60*60은 한시간
            @SuppressLint("DefaultLocale")
            String result = String.format("%02d:%02d:%02d", min, sec, mSec);
            time_text.setText(result);
        }
    };
    public class timeThread implements Runnable {
        @Override
        public void run() {
            int i = 0;
            while (true) {
                while (isRunning) {
                    Message msg = new Message();
                    msg.arg1 = i++;
                    handler.sendMessage(msg);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        runOnUiThread(new Runnable(){
                            @Override
                            public void run() {
                                time_text.setText("");
                                time_text.setText("00:00:00");
                            }
                        });
                        return; // 인터럽트 받을 경우 return
                    }
                }
            }
        }
    }

    private void new_record() {
        Intent intent=new Intent(StartActivity.this,New_recordActivity.class);
        intent.putExtra("time_text",time_text.getText().toString());
        startActivity(intent);
    }
}
