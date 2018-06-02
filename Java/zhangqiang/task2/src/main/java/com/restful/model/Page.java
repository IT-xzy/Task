package com.restful.model;

import java.util.List;

public class Page<T> {

//    当前页
    private int currPage;

//    开始页
    private int start;

//    每页数据（每页显示的记录数）
    private int pageSize;

//    总记录数
    private int totalConut;

//    总页数
    private int totalPage;

//    每页显示的数据
    private List<T> pages;

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalConut() {
        return totalConut;
    }

    public void setTotalConut(int totalConut) {
        this.totalConut = totalConut;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getPages() {
        return pages;
    }

    public void setPages(List<T> pages) {
        this.pages = pages;
    }


    @Override
    public String toString() {
        return "Page{" +
                "currPage=" + currPage +
                ", start=" + start +
                ", pageSize=" + pageSize +
                ", totalConut=" + totalConut +
                ", totalPage=" + totalPage +
                ", pages=" + pages +
                '}';
    }
}

