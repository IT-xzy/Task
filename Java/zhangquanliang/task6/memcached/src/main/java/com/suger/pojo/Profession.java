package com.suger.pojo;

import java.io.Serializable;

/**
 * @author tiles
 * @date 2018/11/16 22:21
 * 职业实体类
 */
public class Profession implements Serializable {


    private static final long serialVersionUID = 615195114238735121L;
    Long id;
    // 职业名称:
    String name;
    Integer onlineCount;
    String img;
    // 职业方向：前端,后端
    String type;
    String description;

    Integer difficulty;
    //职业门槛
    Integer threshold;
    //  成长周期
    String cycle;
    Integer company;
    String payOne;
    String payTwo;
    String payThree;
    // 需要的基础
    String base;
    Long createAt;
    Long updateAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOnlineCount() {
        return onlineCount;
    }

    public void setOnlineCount(Integer onlineCount) {
        this.onlineCount = onlineCount;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public Integer getCompany() {
        return company;
    }

    public void setCompany(Integer company) {
        this.company = company;
    }

    public String getPayOne() {
        return payOne;
    }

    public void setPayOne(String payOne) {
        this.payOne = payOne;
    }

    public String getPayTwo() {
        return payTwo;
    }

    public void setPayTwo(String payTwo) {
        this.payTwo = payTwo;
    }

    public String getPayThree() {
        return payThree;
    }

    public void setPayThree(String payThree) {
        this.payThree = payThree;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Profession{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", onlineCount=").append(onlineCount);
        sb.append(", img='").append(img).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", difficulty=").append(difficulty);
        sb.append(", threshold=").append(threshold);
        sb.append(", cycle='").append(cycle).append('\'');
        sb.append(", company=").append(company);
        sb.append(", payOne='").append(payOne).append('\'');
        sb.append(", payTwo='").append(payTwo).append('\'');
        sb.append(", payThree='").append(payThree).append('\'');
        sb.append(", base='").append(base).append('\'');
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append('}');
        return sb.toString();
    }
}
