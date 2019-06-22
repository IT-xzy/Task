package cn.wp.model;

import java.io.Serializable;

/** @author 老王 */
public class Profession implements Serializable {
  private static final long serialVersionUID = -97144351813827622L;
  private Long id;

  private String name;

  private String introduction;

  private Long threshold;

  private Long difficult;

  private String growthCycle;

  private Long scarcity;

  private Long stageOne;

  private Long stageTwo;

  private Long stageThree;

  private String picture;

  private Long count;

  private Long createAt;

  private Long updateAt;

  private String createBy;

  private String updateBy;

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
    this.name = name == null ? null : name.trim();
  }

  public String getIntroduction() {
    return introduction;
  }

  public void setIntroduction(String introduction) {
    this.introduction = introduction == null ? null : introduction.trim();
  }

  public Long getThreshold() {
    return threshold;
  }

  public void setThreshold(Long threshold) {
    this.threshold = threshold;
  }

  public Long getDifficult() {
    return difficult;
  }

  public void setDifficult(Long difficult) {
    this.difficult = difficult;
  }

  public String getGrowthCycle() {
    return growthCycle;
  }

  public void setGrowthCycle(String growthCycle) {
    this.growthCycle = growthCycle == null ? null : growthCycle.trim();
  }

  public Long getScarcity() {
    return scarcity;
  }

  public void setScarcity(Long scarcity) {
    this.scarcity = scarcity;
  }

  public Long getStageOne() {
    return stageOne;
  }

  public void setStageOne(Long stageOne) {
    this.stageOne = stageOne;
  }

  public Long getStageTwo() {
    return stageTwo;
  }

  public void setStageTwo(Long stageTwo) {
    this.stageTwo = stageTwo;
  }

  public Long getStageThree() {
    return stageThree;
  }

  public void setStageThree(Long stageThree) {
    this.stageThree = stageThree;
  }

  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture == null ? null : picture.trim();
  }

  public Long getCount() {
    return count;
  }

  public void setCount(Long count) {
    this.count = count;
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

  public String getCreateBy() {
    return createBy;
  }

  public void setCreateBy(String createBy) {
    this.createBy = createBy == null ? null : createBy.trim();
  }

  public String getUpdateBy() {
    return updateBy;
  }

  public void setUpdateBy(String updateBy) {
    this.updateBy = updateBy == null ? null : updateBy.trim();
  }

  @Override
  public String toString() {
    return "Profession{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", introduction='"
        + introduction
        + '\''
        + ", threshold="
        + threshold
        + ", difficult="
        + difficult
        + ", growthCycle='"
        + growthCycle
        + '\''
        + ", scarcity="
        + scarcity
        + ", stageOne="
        + stageOne
        + ", stageTwo="
        + stageTwo
        + ", stageThree="
        + stageThree
        + ", picture='"
        + picture
        + '\''
        + ", count="
        + count
        + ", createAt="
        + createAt
        + ", updateAt="
        + updateAt
        + ", createBy='"
        + createBy
        + '\''
        + ", updateBy='"
        + updateBy
        + '\''
        + "}\r\n";
  }
}
