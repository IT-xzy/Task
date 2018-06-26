package task2.util;

public class Page {
    int start=0;
    int count = 25;
    int last = 0;
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

    public void caculateLast(int total) {
        // 假设总数是100，是能够被25整除的，那么最后一页的开始就是75
        if (0 == total % count)
            last = total - count;
            // 假设总数是101，不能够被25整除的，那么最后一页的开始就是100
        else
            last = total - total % count;
    }

}

