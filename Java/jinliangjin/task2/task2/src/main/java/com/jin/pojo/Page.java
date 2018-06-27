package com.jin.pojo;

import java.util.List;

/**
 * @ProjectName: task2
 * @Package: com.jin.pojo
 * @ClassName: Page
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/5/14 20:18
 * @UpdateUser:
 * @UpdateDate: 2018/5/14 20:18
 * @UpdateRemark:
 * @Version: 1.0
 */
public class Page {
    private int totalStudents;//查询结果总数
    private int pageSize = 5;//每页显示的数量
    private int totalPage;//总页数
    private int start;//从哪个编号开始分页
    private int end;//结束的编号
    private int currentPage;//想看的页数
    private List<Student> students;//

    public int getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(int totalStudents) {
        this.totalStudents = totalStudents;
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

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
