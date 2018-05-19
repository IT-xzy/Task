package com.ssm_yl.page;

public class Page {
    int start=0;
    int count=5;
    int last=0;

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
        //如果总数为20,每页5个,刚好能分完,则最后一页的开始为总数减去每页的个数
        if(0==total%count){
            last = total - count;
        }
        //如果不能分完,则最后一页的开始为总数减去余数
        else last = total - total%count;
   }
}
