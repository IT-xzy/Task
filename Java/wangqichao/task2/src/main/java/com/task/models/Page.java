package com.task.models;

import java.util.List;

public class Page<T> {
    //当前页
    private int currentPage;
    //每页记录数,默认为20条，可改
    private int pageSize=20;
    //总记录数
    private int totalCount;
    //总页数
    private int totalPage;
    //每页显示的数据
    private List<T> lists;
    //构造方法
    public Page(){
        super();
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
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
   //将查询到结果放到page中
    public void setLists(List<T> lists) {
        this.lists = lists;
    }
}
