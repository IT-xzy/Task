package com.POJO;

/**
 * @author: 曹樾
 * @program: task5-module
 * @description: 首页优秀学员
 * @create: 2018/5/7 下午5:37
 */

public class GreatStudent {
    private Integer ID;
    private String name;
    private String picture;
    private String profession;
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
    
    public String getProfession() {
        return profession;
    }
    
    public void setProfession(String profession) {
        this.profession = profession;
    }
    
    public String getIntroduce() {
        return introduce;
    }
    
    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
