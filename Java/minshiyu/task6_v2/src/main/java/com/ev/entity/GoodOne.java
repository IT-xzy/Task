package com.ev.entity;

import java.io.Serializable;

public class GoodOne implements Serializable {

    //姓名
    private String name;
    //介绍
    private String introduction;
    //照片路径
    private String photoPath;
    //数据库中id
    private Long id;
    //创建时间
    private Long createAt;
    //更新时间
    private Long updateAt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    public GoodOne() {
    }

    public GoodOne(String name, String introduction, String photoPath, Long createAt, Long updateAt) {
        this.name = name;
        this.introduction = introduction;
        this.photoPath = photoPath;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "GoodOne{" +
                "name='" + name + '\'' +
                ", introduction='" + introduction + '\'' +
                ", photoPath='" + photoPath + '\'' +
                ", id=" + id +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
