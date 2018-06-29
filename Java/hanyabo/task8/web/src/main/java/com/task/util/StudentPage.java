package com.task.util;

import java.io.Serializable;

public class StudentPage implements Serializable {

    int start = 0;
    int count = 8;
    int last = 0;
    int next = 0;

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public int getPrevious() {
        return previous;
    }

    public void setPrevious(int previous) {
        this.previous = previous;
    }

    int previous = 0;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
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

    public void caculateLast(int total){

        if(0 == total%count){
            last = total - last;
        }
        else
        {
            last = total - total%count;
        }

        //上一页 边界条件
        previous = start-count;
        if(previous < 0)
            previous = start;

        //下一页 边界条件
        next = start + count;
        if(next >= total){
            next = last;
        }
    }
}
