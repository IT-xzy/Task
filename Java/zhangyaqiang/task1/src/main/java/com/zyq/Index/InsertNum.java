package com.zyq.Index;

public enum InsertNum {
    NUM1(1),NUM2(10),NUM3(100),NUM4(500);

    private int value;
    InsertNum(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}

