package com.example.DistLog.models;

public class Record {

    private String value;
    private Long offset;

    public Record() {}
    public Record(String value, long offset) {
        this.value = value;
        this.offset = offset;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }
}
