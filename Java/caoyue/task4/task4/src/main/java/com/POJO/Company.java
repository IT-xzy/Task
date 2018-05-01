package com.POJO;

/**
 * @author: 曹樾
 * @program: task4
 * @description: 推荐企业
 * @create: 2018/4/25 下午8:41
 */

public class Company {
    private Integer ID;
    private String name;
    private String picture;
    private String introduce;
    
    public Integer getID() {
        return ID;
    }
    
    public void setID(Integer ID) {
        this.ID = ID;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPicture() {
        return picture;
    }
    
    public void setPicture(String picture) {
        this.picture = picture;
    }
    
    public String getIntroduce() {
        return introduce;
    }
    
    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
