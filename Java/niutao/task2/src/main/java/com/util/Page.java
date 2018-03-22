package com.util;


public class Page {
    //每一页，从第一列开始，数5条
    private int start=0;
    private int count = 5;
    private int last = 0;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        if(start<0){
            this.start = 0;
        }
        else {this.start = start;}
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

    //总条数, count一页展示数
    public void caculateLast(int total){
        if(0 == total % count) {
            last = total - count;
        } else {
            last = total - total % count;
        }
    }
}
