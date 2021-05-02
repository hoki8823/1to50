package com.example.a1to50;

import android.provider.BaseColumns;

public final class DataBases {
    public static final class CreateDB implements BaseColumns{
        public static final String NICKNAME = "nickname";
        public static final String TIME = "time";
        public static final String _TABLENAME0 = "ranktable";
        public static final String _CREATE0 = "create table if not exists "+_TABLENAME0+"(" +
                _ID+" integer primary key autoincrement, " +
                NICKNAME+" text not null" +
                TIME+" text not null);";
    }
}
