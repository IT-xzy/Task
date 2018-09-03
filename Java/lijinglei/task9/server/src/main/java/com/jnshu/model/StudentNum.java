package com.jnshu.model;

public class StudentNum implements java.io.Serializable {
    private static final long serialVersionUID = 4077329331699640331L;

    private Integer id;

    private Integer cumulativeNum;

    private Integer findJobNum;

    private Long creatTime;

    private Long modificationTime;

    public StudentNum(Integer id, Integer cumulativeNum, Integer findJobNum, Long creatTime, Long modificationTime) {
        this.id = id;
        this.cumulativeNum = cumulativeNum;
        this.findJobNum = findJobNum;
        this.creatTime = creatTime;
        this.modificationTime = modificationTime;
    }

    public StudentNum() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCumulativeNum() {
        return cumulativeNum;
    }

    public void setCumulativeNum(Integer cumulativeNum) {
        this.cumulativeNum = cumulativeNum;
    }

    public Integer getFindJobNum() {
        return findJobNum;
    }

    public void setFindJobNum(Integer findJobNum) {
        this.findJobNum = findJobNum;
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