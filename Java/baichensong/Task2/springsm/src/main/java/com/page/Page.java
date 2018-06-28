package com.page;

public class Page {

//设置初始值
int start=0;
int count = 5;
int last = 0;

public int getStart(){
    return start;
}
public void setStart(int start){
    this.start=start;
}
public int getCount(){
    return count;
}
public void setCount(int count){
    this.count=count;
}
public int getLast(){
    return last;
}
public void setLast(int last){
    this.last=last;
}

//判断 最后一页 的起始值。
public void calast(int total){
    if(0==total % count)
        last = total - count;
    else
        last = total - total % count;
}
}
