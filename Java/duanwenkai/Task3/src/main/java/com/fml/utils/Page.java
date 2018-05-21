package com.fml.utils;

import java.util.List;

public class Page<T> {
    /**每页显示数量*/
    private int count;
    /**总记录数*/
    private int totalCount;
    /**当前页码*/
    private int currPage;
    /**总页数*/
    private int totalPage;
    /**页面数据*/
    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getTotalPage() {
        if (this.totalCount % this.count == 0){
            this.totalPage = this.totalCount/this.count;
        }else{
            this.totalPage = this.totalCount/this.count + 1;
        }
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
