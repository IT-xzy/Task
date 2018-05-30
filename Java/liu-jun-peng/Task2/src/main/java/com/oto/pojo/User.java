package com.oto.pojo;


/**
 * @author: 刘军鹏
 * @program: demo
 * @description:
 * @create: 2018/5/22 下午12:22
 */

public class User {
    private Integer id;
    private String name;
    private int QQ;
    private long rxtime;
    private Long create_at;
    private Long update_at;
    
    public Long getCreate_at() {
        return create_at;
    }
    
    public void setCreate_at(Long create_at) {
        this.create_at = create_at;
    }
    
    public Long getUpdate_at() {
        return update_at;
    }
    
    public void setUpdate_at(Long update_at) {
        this.update_at = update_at;
    }
    
    public User() {
        super();
    }
    
    public long getRxtime() {
        return rxtime;
    }
    
    public void setRxtime(long rxtime) {
        this.rxtime = rxtime;
    }
    
    public User(Integer id, String name, int QQ, long rxtime) {
        this.id = id;
        this.name = name;
        this.QQ = QQ;
        this.rxtime=rxtime;
        
        
    }
    
    public Integer  getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getQQ() {
        return QQ;
    }
    
    public void setQQ(int QQ) {
        this.QQ = QQ;
    }
    
    
    public String toString() {
        return "User [学号=" + id + ", QQ=" + QQ + ", 学生姓名=" + name
                + "]";
        
    }
}
