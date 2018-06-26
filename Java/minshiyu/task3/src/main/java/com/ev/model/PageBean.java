package com.ev.model;

import java.util.List;

public class PageBean<T> {

    //分页实体类
    //当前页面
    private int currPage;
    //每页显示记录数
    private int pageSize;
    //总记录数
    private int totalCount;
    //总页数
    private int totalPage;
    //总记录的列表
    private List<T> lists;
    //名称
    private String name;

    public PageBean() {
        super();
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getLists() {
        return lists;
    }

    public void setLists(List<T> lists) {
        this.lists = lists;
    }

    public String getName() {
        return name;
    }

}
