package com.example.DistLog.models;

import java.util.ArrayList;

public class Log {

    private ArrayList<Record> records;

    Log() {}

    Log(ArrayList<Record> records) {
        this.records = records;
    }

    public ArrayList<Record> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<Record> records) {
        this.records = records;
    }

    public void append(Record record) {
        records.add(record);
    }
}
