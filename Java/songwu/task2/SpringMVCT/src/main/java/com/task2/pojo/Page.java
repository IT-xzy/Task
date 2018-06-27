package com.task2.pojo;

public class Page {

    /*
    * currentPage 当前页
    *  pageSize 每页记录数
    * count 总数
    * countPage 总页数
    * nextPage 下一页
    * prePage 上一页
    * */

    private int currentPage=1;
    private int pageSize=5;
    private int count;
    private int countPage;
    private int prePage;
    private int nextPage;


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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCountPage() {
        countPage=count%pageSize==0?count/pageSize:count/pageSize+1;
        return countPage;
    }

    public void setCountPage(int countPage) {

        this.countPage = countPage;
    }

    public int getPrePage() {
        if (currentPage > 1) {
            prePage=currentPage-1;
        }else{
            prePage=1;
        }
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        if (currentPage < count) {
            nextPage=currentPage+1;
        }else{
            nextPage=countPage;
        }
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }
}
