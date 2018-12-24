package com.suger.pojo;

import java.io.Serializable;

/**
 * 分页工具
 *
 * @author suger
 * @date 2018-10-03
 */
public class Page implements Serializable {
    private static final long serialVersionUID = 8086716095236452856L;
    // 除最后一页，每页开始的记录数
    int start = 0;
    // 每页中记录总数
    int count = 10;
    // 最后一页开始·的记录数
    int last = 0;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        if (start <= 0) {
            start = 0;
        }
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

    /**
     * 计算最后一页开始的记录数
     * @param total 总记录数
     */
    public void calculateLast(int total) {
        // 假设总数是50，是能够被5整除的，那么最后一页的开始就是45
        if (0 == total % count) {
            last = total - count;
        }
        // 假设总数是51，不能够被5整除的，那么最后一页的开始就是50
        else {
            last = total - total % count;
        }
    }
}
