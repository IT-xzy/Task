//package com.jnshu.model;
//
//public class Page {
//    //    当前页
//    private int pageNow;
//    //    每页的行数
//    private int pageSize = 10;
//    //    总页数
//    private int totalPages;
//    //    总行数
//    private int totalRow;
//    //    上一页
//    private int prePage;
//    //    下一页
//    private int nextPage;
//
//    public Page(int pageNow, int totalRow) {
//        this.pageNow = pageNow;
//        this.totalRow = totalRow;
//        this.setTotalPages(this.getTotalPages());
//        this.setNextPage(this.getNextPage());
//        this.setPrePage(this.getPrePage());
//
//    }
//
//    public int getPageNow() {
//        return pageNow;
//    }
//
//    public void setPageNow(int pageNow) {
//        this.pageNow = pageNow;
//    }
//
//    public int getPageSize() {
//        return pageSize;
//    }
//
//    public void setPageSize(int pageSize) {
//        this.pageSize = pageSize;
//    }
//
//    public int getTotalPages() {
////        如果总页数=总行数余每页的行数=0，则总页数 = 总行数除每页的行数 否则 总页数 =总行数除每页的行数+1
//        totalPages = totalRow % pageSize == 0 ? totalRow / pageSize : totalRow / pageSize + 1;
//        return totalPages;
//    }
//
//    public void setTotalPages(int totalPages) {
//        this.totalPages = totalPages;
//    }
//
//    public int getTotalRow() {
//        return totalRow;
//    }
//
//    public void setTotalRow(int totalRow) {
//        this.totalRow = totalRow;
//    }
//
//    public int getPrePage() {
////        如果当前页-1大于等于1，那么前一页就等于当前页-1，否则前一页就等于当前页
//        if (pageNow - 1 >= 1) {
//            prePage = pageNow - 1;
//        } else {
//            prePage = pageNow;
//        }
//        return prePage;
//    }
//
//    public void setPrePage(int prePage) {
//        this.prePage = prePage;
//    }
//
//    public int getNextPage() {
////        如果总页数大于等于当前页+1，下一页就等于当前页+1，否则，下一页等于当前页
//        if (totalPages>=pageNow+1){
//            nextPage = pageNow+1;
//        }else{
//            nextPage = pageNow;
//        }
//        return nextPage;
//    }
//
//    public void setNextPage(int nextPage) {
//        this.nextPage = nextPage;
//    }
//
//    @Override
//    public String toString() {
//        return "Page{" +
//                "pageNow=" + pageNow +
//                ", pageSize=" + pageSize +
//                ", totalPages=" + totalPages +
//                ", totalRow=" + totalRow +
//                ", prePage=" + prePage +
//                ", nextPage=" + nextPage +
//                '}';
//    }
//}