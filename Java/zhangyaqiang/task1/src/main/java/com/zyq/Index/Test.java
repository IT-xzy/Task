package com.zyq.Index;

public class Test {
    public static void main(String[] args) {
        for (InsertNum insertNum:InsertNum.values()) {
            System.out.println(insertNum.getValue());
        }
        String prefix = "insert into student"+ 2 +" values";
        System.out.println(prefix);
        System.out.println((char) (0x4e00 + (int) (Math.random() * (0x9fa5 - 0x4e00 + 1))));
    }
}
