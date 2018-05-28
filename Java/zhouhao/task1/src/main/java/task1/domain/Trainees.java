package task1.domain;

import java.util.Date;
/**
 *@Author: Zhou Hao
 *@Date: 2018-5-19 12:00
 *@Description: 描述学员信息
 *@Modify:
 */

public class Trainees {
    private int id;
    private long line_id;
    private String name;
    private String qq;
    private int couseType;//'前端工程师','JAVA工程师','运维工程师','iOS工程师','Android工程师','UI设计师','产品经理'
    private String senior;//师兄
    private String noturl;//日报链接
    private Date enroll_time;//入学时间
    private long creat_at;
    private long updata_at;

    public Trainees() {

    }

    public Trainees(String name, String senior, String noturl) {
        this.name = name;
//      this.id = id;
        this.senior = senior;
        this.noturl = noturl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLine_id(long line_id) {
        this.line_id = line_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQQ(String qq) {
        this.qq = qq;
    }

    public void setCouseType(int couseType) {
        this.couseType = couseType;
    }

    public void setSenior(String senior) {
        this.senior = senior;
    }

    public void setNoturl(String noturl) {
        this.noturl = noturl;
    }

    public void setEnroll_time(Date enroll_time) {
        this.enroll_time = enroll_time;
    }

    public void setCreat_at(long creat_at) {
        this.creat_at = creat_at;
    }

    public void setUpdata_at(long updata_at) {
        this.updata_at = updata_at;
    }

    public long getId() {

        return id;
    }

    public long getLine_id() {
        return line_id;
    }

    public String getName() {
        return name;
    }

    public String getqq() {
        return qq;
    }

    public int getCouseType() {
        return couseType;
    }

    public String getSenior() {
        return senior;
    }

    public String getNoturl() {
        return noturl;
    }

    public Date getEnroll_time() {
        return enroll_time;
    }

    public long getCreat_at() {
        return creat_at;
    }

    public long getUpdata_at() {
        return updata_at;
    }

    @Override
    public String toString() {
        return new String(this.name + "\n" + this.id + "\n" + this.qq);
    }

    @Override
    public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + id;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            return result;

    }
}
