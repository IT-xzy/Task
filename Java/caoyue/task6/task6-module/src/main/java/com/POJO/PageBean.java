package com.POJO;

import java.util.List;

public class PageBean<T> {
    private int currentPage;//当前页数
    private int totalCount;//数据总数
    private int pageSize;//每页显示的数目
    private int totalPage;//总页数
    private List<T> lists;//每页显示的数据
    private String name;//模糊查询
    
    public PageBean() {
        super();
    }
    
    public int getCurrentPage() {
        return currentPage;
    }
    
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    
    public int getTotalCount() {
        return totalCount;
    }
    
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
    
    public int getPageSize() {
        return pageSize;
    }
    
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
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
    
    public void setName(String name) {
        this.name = name;
    }
}
