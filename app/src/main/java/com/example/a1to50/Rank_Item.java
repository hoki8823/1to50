package com.example.a1to50;

public class Rank_Item {
    private int id;
    private String nick;
    private String record;

    public Rank_Item(int id, String nick, String record) {
        this.id = id;
        this.nick = nick;
        this.record = record;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }
}
