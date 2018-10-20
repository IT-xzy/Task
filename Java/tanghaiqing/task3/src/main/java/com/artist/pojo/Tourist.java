package com.artist.pojo;

public class Tourist {
    private Integer touristId;
    private String touristName;
    private Long createTime;
    private Long exitTime;

    public Tourist() {
    }

    public Tourist(Integer touristId, String touristName, Long createTime, Long exitTime) {
        this.touristId = touristId;
        this.touristName = touristName;
        this.createTime = createTime;
        this.exitTime = exitTime;
    }

    public Integer getTouristId() {
        return touristId;
    }

    public void setTouristId(Integer touristId) {
        this.touristId = touristId;
    }

    public String getTouristName() {
        return touristName;
    }

    public void setTouristName(String touristName) {
        this.touristName = touristName;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getExitTime() {
        return exitTime;
    }

    public void setExitTime(Long exitTime) {
        this.exitTime = exitTime;
    }

    @Override
    public String toString() {
        return "Tourist{" +
                "touristId=" + touristId +
                ", touristName='" + touristName + '\'' +
                ", createTime=" + createTime +
                ", exitTime=" + exitTime +
                '}';
    }
}
