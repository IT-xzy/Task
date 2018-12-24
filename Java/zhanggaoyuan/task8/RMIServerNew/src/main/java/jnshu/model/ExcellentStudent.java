package jnshu.model;

import java.io.Serializable;

public class ExcellentStudent implements Serializable {

    private static final long serialVersionUID = 8303863385577113299L;

    private Long id;

    private String img;

    private String position;

    private String name;

    private String description;

    private String salary;

    private Long creatTime;

    private Long updateTime;
    private boolean ifExcellent;

    public boolean isIfExcellent() {
        return ifExcellent;
    }

    public void setIfExcellent(boolean ifExcellent) {
        this.ifExcellent = ifExcellent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary == null ? null : salary.trim();
    }

    public Long getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Long creatTime) {
        this.creatTime = creatTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}