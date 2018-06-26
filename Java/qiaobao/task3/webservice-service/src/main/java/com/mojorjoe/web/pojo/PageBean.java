package com.mojorjoe.web.pojo;

import java.util.List;

public class PageBean {

        //    对数据库分页查询时的下标
        private long startIndex;

        //    每页显示的记录条数，分页查询limit的标记
        private int pageSize;

        //    总记录数，由对数据库的查询得到，通过set方法注入
        private long totalRecord;

        //    总页数，在bean类中由 每页行数和总记录计算得到
        private long totalPage;

        //    当前页数，通过set方法注入，对应关系：startIndex=(pageNum-1)*pagesize
        private long pageNum;

        //    显示页数，比如总共有5页，1.2.3.4.5，这里1就是start  5就是end
        private int start;
        private int end;

        //    分页显示的数据List接收
        private List<Student> list;

        //    根据当前页pageNum，每页显示个数pageSize，和总记录totalRecord，算出totalpage、startIndex、
        public PageBean(int pageSize, long totalRecord, long pageNum) {
            this.pageSize = pageSize;
            this.totalRecord = totalRecord;
            this.pageNum = pageNum;

//        总页数算法
            this.totalPage=(totalRecord-1)/pageSize+1;

//        分页查询的下标
            this.startIndex=(pageNum-1)*pageSize;

//        显示页数的算法,默认显示5页，总页数小于5页的时候显示总页数
            this.start=1;
            this.end=5;
            if(totalPage <= 5 ){
                this.end= (int) totalPage;
            }else{
//            总页数大于5，那么就要根据当前页是第几页来判断start和end是多少
                this.start= (int) (pageNum-2);
                this.end= (int) (pageNum+2);

                if (start<0) {
//                如果当前页是第一页，或者第二页，就不符合规则
                    this.start = 1;
                    this.end = 5;
                }
                if(end>this.totalPage){
//                当前页是第二页或最后一页时候
                    this.end= (int) totalPage;
                    this.start= (int) (end-5);
                }
            }
        }

    public PageBean() {
    }

    @Override
        public String toString() {
            return "PageBean{" +
                    "startIndex=" + startIndex +
                    ", pageSize=" + pageSize +
                    ", totalRecord=" + totalRecord +
                    ", totalPage=" + totalPage +
                    ", pageNum=" + pageNum +
                    ", start=" + start +
                    ", end=" + end +
                    ", list=" + list +
                    '}';
        }

    public long getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(long startIndex) {
        this.startIndex = startIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(long totalRecord) {
        this.totalRecord = totalRecord;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public long getPageNum() {
        return pageNum;
    }

    public void setPageNum(long pageNum) {
        this.pageNum = pageNum;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }
}

