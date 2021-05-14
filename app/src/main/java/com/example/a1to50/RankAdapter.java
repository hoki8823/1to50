package com.example.a1to50;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class RankAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context mContext;
    private ArrayList<Rank_Item> ranklist;

    public RankAdapter(ArrayList<Rank_Item> items, Context context) {
        ranklist = items;
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rank_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).onBind(ranklist.get(position));
    }

    @Override
    public int getItemCount() {
        return ranklist.size(); // 데이터 개수 리턴
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mNick;
        public TextView mTime;
        public TextView mNum;

        public ViewHolder(View itemView) {
            super(itemView);
            // 화면에 표시될 View 로부터 위젯에 대한 참조 획득
            mNum = itemView.findViewById(R.id.rank_num);
            mNick = itemView.findViewById(R.id.nickname_text);
            mTime = itemView.findViewById(R.id.time_text);
        }

        public void onBind(Rank_Item item) {
            mNum.setText(String.valueOf(item.getId()));
            mNick.setText(item.getNick());
            mTime.setText(item.getRecord());
        }
    }
}