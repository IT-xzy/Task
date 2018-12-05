package com.jnshu.myutils;

import com.jnshu.entity.Student4;

import java.util.ArrayList;
import java.util.List;

public class Page {
    private long pageSize=3;            //页大小
    private long pageIndex=0;           //当前页号
    private long totalPageCount=0;      //总页数
    private long record=0;              //记录总数
    private long nextPage;          //下一页
    private long prePage;           //上一页
    private List<Student4> student4list=new ArrayList<Student4>();     //房屋信息的集合



    /**
     * @author Mu Xiongxiong
     * @created 2017-3-17 下午10:04:41
     * @return type
     */

    public List<Student4> getStudent4List() {
        return student4list;
    }

    /**
     * @author Mu Xiongxiong
     * @created 2017-3-17 下午10:04:41
     * @param student4List
     */
    public void setHouseList(List<Student4> student4List) {
        this.student4list = student4List;
    }

    //得到开始记录数
    public long getStartRow(){
        return (pageIndex-1)*pageSize;
    }

    //得到结束记录数
    public long getEndRow(){
        return pageSize;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getPageIndex() {
        return pageIndex;
    }

    //得到当前页
    public void setPageIndex(long pageIndex) {
        this.pageIndex = pageIndex;
        //下一页
        setNextPage();
        //上一页
        setPrePage();
    }

    public long getTotalPageCount() {
        return totalPageCount;
    }

    //总页数
    public void setTotalPageCount() {
        long totalP = record % getPageSize() == 0 ? record / getPageSize() :
                record/ getPageSize() + 1;
        this.totalPageCount = totalP;
    }

    public long getRecord() {
        return record;
    }

    //总记录数
    public void setRecord(long record) {
        this.record = record;
        //设置总页数
        setTotalPageCount();
    }

    public long getNextPage() {
        return nextPage;
    }

    //设置下一页
    public void setNextPage() {
        this.nextPage = this.pageIndex+1;

    }

    public long getPrePage() {
        return prePage;
    }

    //设置上一页
    public void setPrePage() {
        this.prePage =this.pageIndex-1;
        if(this.prePage<1){
            this.prePage=1;
        }
    }
}
