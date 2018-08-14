package com.zyq.pojo;

import java.util.List;

public class Page<T> {
    private Integer currPage;
    private static Integer pageSize;
    private Integer totalNum;

    private Integer totalPage;
    private List<T> list;

    public Page() {
    }

    public Page(Integer currPage, Integer pageSize, Integer totalNum, List<T> list) {
        this.currPage = currPage;
        this.pageSize = pageSize;
        this.totalNum = totalNum;
        this.list = list;
    }

    public Integer getCurrPage() {
        return currPage;
    }

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize){
        this.pageSize = pageSize;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getTotalPage() {
        return totalNum%pageSize == 0 ? totalNum / pageSize : totalNum/pageSize + 1;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
