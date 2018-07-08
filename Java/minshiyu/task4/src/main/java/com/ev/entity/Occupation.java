package com.ev.entity;

public class Occupation {

    //职业名称
    private String name;
    //方向
    private String direction;
    //详细信息
    private String descriptionDetailed;
    //简要信息
    private String descriptionGeneral;
    //门槛
    private int threshold;
    //难度
    private int difficulty;
    //成长周期
    private String growthCycle;
    //前景
    private int scarcity;
    //初期薪酬
    private String salaryFreshman;
    //中期薪酬
    private String salaryJunior;
    //后期薪酬
    private String salarySenior;
    //在学人数
    private int isLearning;
    //补充说明
    private String tips;
    //数据库id
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

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDescriptionDetailed() {
        return descriptionDetailed;
    }

    public void setDescriptionDetailed(String descriptionDetailed) {
        this.descriptionDetailed = descriptionDetailed;
    }

    public String getDescriptionGeneral() {
        return descriptionGeneral;
    }

    public void setDescriptionGeneral(String descriptionGeneral) {
        this.descriptionGeneral = descriptionGeneral;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getGrowthCycle() {
        return growthCycle;
    }

    public void setGrowthCycle(String growthCycle) {
        this.growthCycle = growthCycle;
    }

    public int getScarcity() {
        return scarcity;
    }

    public void setScarcity(int scarcity) {
        this.scarcity = scarcity;
    }

    public String getSalaryFreshman() {
        return salaryFreshman;
    }

    public void setSalaryFreshman(String salaryFreshman) {
        this.salaryFreshman = salaryFreshman;
    }

    public String getSalaryJunior() {
        return salaryJunior;
    }

    public void setSalaryJunior(String salaryJunior) {
        this.salaryJunior = salaryJunior;
    }

    public String getSalarySenior() {
        return salarySenior;
    }

    public void setSalarySenior(String salarySenior) {
        this.salarySenior = salarySenior;
    }

    public int getIsLearning() {
        return isLearning;
    }

    public void setIsLearning(int isLearning) {
        this.isLearning = isLearning;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
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

    @Override
    public String toString() {
        return "Occupation{" +
                "name='" + name + '\'' +
                ", direction='" + direction + '\'' +
                ", descriptionDetailed='" + descriptionDetailed + '\'' +
                ", descriptionGeneral='" + descriptionGeneral + '\'' +
                ", threshold=" + threshold +
                ", difficulty=" + difficulty +
                ", growthCycle='" + growthCycle + '\'' +
                ", scarcity=" + scarcity +
                ", salaryFreshman='" + salaryFreshman + '\'' +
                ", salaryJunior='" + salaryJunior + '\'' +
                ", salarySenior='" + salarySenior + '\'' +
                ", isLearning=" + isLearning +
                ", tips='" + tips + '\'' +
                ", id=" + id +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
