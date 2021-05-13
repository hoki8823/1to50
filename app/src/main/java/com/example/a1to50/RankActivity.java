package com.example.a1to50;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RankActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ArrayList<Rank_Item> rankItemList= new ArrayList<>();
    RecyclerView.Adapter rvAdapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);

        rv = (RecyclerView)findViewById(R.id.rank_recycler);
        rv.setHasFixedSize(true);

        layoutManager=new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);

        rvAdapter = new RankAdapter(rankItemList, this); // Adapter 생성
        rv.setAdapter(rvAdapter);
    }
}
