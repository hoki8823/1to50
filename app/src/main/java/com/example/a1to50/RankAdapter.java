package com.example.a1to50;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RankAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context mContext;
    private ArrayList<Rank_Item> IvList;
    int Position;

    public RankAdapter(ArrayList<Rank_Item> items, Context context) {
        IvList = items;
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rank_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        // Rank의 getView 부분을 담당하는 메소드
        ((ViewHolder) holder).onBind(IvList.get(position));
    }

    @Override
    public int getItemCount() {
        return IvList.size(); // 데이터 개수 리턴
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mnick;
        public TextView mrecord;

        public ViewHolder(View itemView) {
            super(itemView);
            // 화면에 표시될 View 로부터 위젯에 대한 참조 획득
            mnick = itemView.findViewById(R.id.nickname_text);
            mrecord = itemView.findViewById(R.id.time_text);
        }

        public void onBind(Rank_Item item) {
            mnick.setText(item.getNick());
            mrecord.setText(item.getRecord());
        }
    }
}