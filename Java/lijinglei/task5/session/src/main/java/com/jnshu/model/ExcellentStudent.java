package com.jnshu.model;

public class ExcellentStudent {
    private Integer id;

    private String name;

    private String describe;

    private String image;

    private Long creatTime;

    private Long modificationTime;

    public ExcellentStudent(Integer id, String name, String describe, String image, Long creatTime, Long modificationTime) {
        this.id = id;
        this.name = name;
        this.describe = describe;
        this.image = image;
        this.creatTime = creatTime;
        this.modificationTime = modificationTime;
    }

    public ExcellentStudent() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Long getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Long creatTime) {
        this.creatTime = creatTime;
    }

    public Long getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(Long modificationTime) {
        this.modificationTime = modificationTime;
    }
}