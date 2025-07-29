package com.example.DistLog.models;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Log {

    private ArrayList<Record> records = new ArrayList<>();

    public Log() {}

    public Log(ArrayList<Record> records) {
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
