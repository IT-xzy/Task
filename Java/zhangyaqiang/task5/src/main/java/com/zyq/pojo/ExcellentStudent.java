package com.zyq.pojo;

public class ExcellentStudent {
    private Integer id;
    private String img;
    private String position;

    private String name;
    private String description;
    private Double salary;

    private Long createAt;
    private Long updateAt;

    public ExcellentStudent() {
    }

    public ExcellentStudent(Integer id, String img, String position, String name, String description, Double salary, Long createAt, Long updateAt) {
        this.id = id;
        this.img = img;
        this.position = position;
        this.name = name;
        this.description = description;
        this.salary = salary;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
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
}
