package com.example.a1to50;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RankActivity extends AppCompatActivity {
    Context context;

    SQLiteDatabase db;
    DBHelper dbHelper;

    private RecyclerView recyclerView;
    private ArrayList<Rank_Item> rankItemList = new ArrayList<>();
    RecyclerView.Adapter rankAdapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);


        context = this.getBaseContext();

        recyclerView = (RecyclerView)findViewById(R.id.rank_recycler);
        recyclerView.setHasFixedSize(true);

        rankItemList.clear();
        dbHelper = new DBHelper(this);
        db = dbHelper.getReadableDatabase();
        db.beginTransaction();

        Cursor cursor = dbHelper.loadRank();
        try{
            int i = 1;
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                addGroupItem(i++,cursor.getString(1),cursor.getString(2));
                cursor.moveToNext();
            }
            db.setTransactionSuccessful();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(cursor!=null) {
                cursor.close();
                db.endTransaction();
            }
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        rankAdapter = new RankAdapter(rankItemList, this); // Adapter 생성
        recyclerView.setAdapter(rankAdapter); // 어댑터를 리스트뷰에 세팅
    }
    public void addGroupItem(int i,String nick, String time){
        Rank_Item item = new Rank_Item();
        item.setId(i);
        item.setNick(nick);
        item.setRecord(time);
        rankItemList.add(item);
    }
}
