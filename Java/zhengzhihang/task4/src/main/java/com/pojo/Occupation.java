package com.pojo;

import org.springframework.stereotype.Repository;

@Repository
public class Occupation {
    private int id;
    private String career;
    private String introduction;
    private String pic;
    private int threshold;
    private int complexity;
    private String growthCycle;
    private String requirement;
    private String skillRelated;
    private String eSalary;
    private String mSalary;


    @Override
    public String toString() {
        return "Occupation{" +
                "id=" + id +
                ", career='" + career + '\'' +
                ", introduction='" + introduction + '\'' +
                ", pic='" + pic + '\'' +
                ", threshold=" + threshold +
                ", complexity=" + complexity +
                ", growthCycle='" + growthCycle + '\'' +
                ", requirement='" + requirement + '\'' +
                ", skillRelated='" + skillRelated + '\'' +
                ", eSalary='" + eSalary + '\'' +
                ", mSalary='" + mSalary + '\'' +
                ", lSalary='" + lSalary + '\'' +
                '}'+"\n";
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    private String lSalary;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }



    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public int getComplexity() {
        return complexity;
    }

    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }

    public String getGrowthCycle() {
        return growthCycle;
    }

    public void setGrowthCycle(String growthCycle) {
        this.growthCycle = growthCycle;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getSkillRelated() {
        return skillRelated;
    }

    public void setSkillRelated(String skillRelated) {
        this.skillRelated = skillRelated;
    }

    public String geteSalary() {
        return eSalary;
    }

    public void seteSalary(String eSalary) {
        this.eSalary = eSalary;
    }

    public String getmSalary() {
        return mSalary;
    }

    public void setmSalary(String mSalary) {
        this.mSalary = mSalary;
    }

    public String getlSalary() {
        return lSalary;
    }

    public void setlSalary(String lSalary) {
        this.lSalary = lSalary;
    }
}
