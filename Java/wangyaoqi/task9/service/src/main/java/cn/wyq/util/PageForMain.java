package cn.wyq.util;

import java.io.Serializable;

public class PageForMain implements Serializable {
    private static final long serialVersionUID = 1883838732853579826L;

    int start = 0;
    int count = 4;
    int last = 0;
    public int getStart(){
        return start;
    }
    public void setStart(int start){
        this.start = start;
    }
    public int getCount(){
        return count;
    }
    public void setCount(int count){
        this.count = count;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }
    public void caculateLast(int total){
        if(0==total%count){
            last = total-count;
        }else {
            last = total-total%count;
        }
    }

}
