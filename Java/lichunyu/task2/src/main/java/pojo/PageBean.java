package pojo;

/**
 * 分页查询
 */

public class PageBean {
    int start =0;//开始行，从零开始
    int count =8;//每页显示数
    int last=0;//最后一页开始行
    int pageNum=1;//页码
    int total=0;//总数据

    public PageBean() { }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    //计算last
    public void calculateLast(int total){
        //能整除时，最后一页初始行为总数减去每页数
        if(total%count==0)
            last=total-count;
        else//不能整除时，末页初始行为总数减去余数
            last=total-total%count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }




}
