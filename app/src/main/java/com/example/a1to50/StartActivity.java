package com.example.a1to50;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {
    RelativeLayout[] btn = new RelativeLayout[25];
    TextView[] btn_text = new TextView[25];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        btn[0] = (RelativeLayout)findViewById(R.id.btn_page_1);
        btn[1] = (RelativeLayout)findViewById(R.id.btn_page_2);
        btn[2] = (RelativeLayout)findViewById(R.id.btn_page_3);
        btn[3] = (RelativeLayout)findViewById(R.id.btn_page_4);
        btn[4] = (RelativeLayout)findViewById(R.id.btn_page_5);
        btn[5] = (RelativeLayout)findViewById(R.id.btn_page_6);
        btn[6] = (RelativeLayout)findViewById(R.id.btn_page_7);
        btn[7] = (RelativeLayout)findViewById(R.id.btn_page_8);
        btn[8] = (RelativeLayout)findViewById(R.id.btn_page_9);
        btn[9] = (RelativeLayout)findViewById(R.id.btn_page_10);
        btn[10] = (RelativeLayout)findViewById(R.id.btn_page_11);
        btn[11] = (RelativeLayout)findViewById(R.id.btn_page_12);
        btn[12] = (RelativeLayout)findViewById(R.id.btn_page_13);
        btn[13] = (RelativeLayout)findViewById(R.id.btn_page_14);
        btn[14] = (RelativeLayout)findViewById(R.id.btn_page_15);
        btn[15] = (RelativeLayout)findViewById(R.id.btn_page_16);
        btn[16] = (RelativeLayout)findViewById(R.id.btn_page_17);
        btn[17] = (RelativeLayout)findViewById(R.id.btn_page_18);
        btn[18] = (RelativeLayout)findViewById(R.id.btn_page_19);
        btn[19] = (RelativeLayout)findViewById(R.id.btn_page_20);
        btn[20] = (RelativeLayout)findViewById(R.id.btn_page_21);
        btn[21] = (RelativeLayout)findViewById(R.id.btn_page_22);
        btn[22] = (RelativeLayout)findViewById(R.id.btn_page_23);
        btn[23] = (RelativeLayout)findViewById(R.id.btn_page_24);
        btn[24] = (RelativeLayout)findViewById(R.id.btn_page_25);

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
}
