package com.ptteng.model;

import java.io.Serializable;

/**
 * @ClassName Temp
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/2/14  16:55
 * @Version 1.0
 **/
public class Temp implements Serializable{

    private static final long serialVersionUID = 8638379448158795130L;
    private String name;
    private int total;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Temp{" +
                "name='" + name + '\'' +
                ", total=" + total +
                '}';
    }
}
