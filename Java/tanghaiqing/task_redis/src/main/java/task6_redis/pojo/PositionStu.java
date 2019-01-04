package task6_redis.pojo;

import java.io.Serializable;

public class PositionStu implements Serializable {
    private static final long serialVersionUID = -2548997988413425846L;
    private Integer posId;
    private String name;
    private String position;
    private String intro;
    private String image;
    private Double salary;
    private Long createTime;
    private Long updateTime;


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getPosId() {
        return posId;
    }

    public void setPosId(Integer posId) {
        this.posId = posId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "PositionStu{" +
                "posId=" + posId +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", intro='" + intro + '\'' +
                ", image='" + image + '\'' +
                ", salary=" + salary +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
