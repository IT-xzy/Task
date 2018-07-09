package com.yxpStu.page;

public class Page
{
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
//    获得最后一页的开始条数
    public int finalLast(int total)
    {
        if(total%count==0)
        {return last=total-count;}
        else
        {return last=total-total%count;}

    }
}
