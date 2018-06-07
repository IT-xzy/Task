package pojo;

import java.io.Serializable;

/**
 * 职业属性
 */
public class Career implements Serializable {
    private static final long serialVersionUID = 2952187816544041648L;
    private int id;
    private String career;
    private String growthTime;
    private int wanted;
    private String phaseOneSalary;
    private String phaseTwoSalary;
    private String phaseThreeSalary;
    private String type;
    private String introduce;
    private String detail;

    @Override
    public String toString() {
        return "Career{" +
                "id=" + id +
                ", career='" + career + '\'' +
                ", growthTime='" + growthTime + '\'' +
                ", wanted=" + wanted +
                ", phaseOneSalary='" + phaseOneSalary + '\'' +
                ", phaseTwoSalary='" + phaseTwoSalary + '\'' +
                ", phaseThreeSalary='" + phaseThreeSalary + '\'' +
                ", type='" + type + '\'' +
                ", introduce='" + introduce + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }

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

    public String getGrowthTime() {
        return growthTime;
    }

    public void setGrowthTime(String growthTime) {
        this.growthTime = growthTime;
    }

    public int getWanted() {
        return wanted;
    }

    public void setWanted(int wanted) {
        this.wanted = wanted;
    }

    public String getPhaseOneSalary() {
        return phaseOneSalary;
    }

    public void setPhaseOneSalary(String phaseOneSalary) {
        this.phaseOneSalary = phaseOneSalary;
    }

    public String getPhaseTwoSalary() {
        return phaseTwoSalary;
    }

    public void setPhaseTwoSalary(String phaseTwoSalary) {
        this.phaseTwoSalary = phaseTwoSalary;
    }

    public String getPhaseThreeSalary() {
        return phaseThreeSalary;
    }

    public void setPhaseThreeSalary(String phaseThreeSalary) {
        this.phaseThreeSalary = phaseThreeSalary;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
