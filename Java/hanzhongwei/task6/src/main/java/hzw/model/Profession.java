package hzw.model;

import java.io.Serializable;

public class Profession implements Serializable {
    private Long proId;
    private String proName;
    private String proIntroduction;
    private Integer proThreshold;
    private Integer proDifficulty;
    private Integer proCompany;
    private String proSalary1;
    private String proSalary2;
    private String proSalary3;
    private String proPrompt;
    private Long create_at;
    private Long update_at;

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProIntroduction() {
        return proIntroduction;
    }

    public void setProIntroduction(String proIntroduction) {
        this.proIntroduction = proIntroduction;
    }

    public Integer getProThreshold() {
        return proThreshold;
    }

    public void setProThreshold(Integer proThreshold) {
        this.proThreshold = proThreshold;
    }

    public Integer getProDifficulty() {
        return proDifficulty;
    }

    public void setProDifficulty(Integer proDifficulty) {
        this.proDifficulty = proDifficulty;
    }

    public Integer getProCompany() {
        return proCompany;
    }

    public void setProCompany(Integer proCompany) {
        this.proCompany = proCompany;
    }

    public String getProSalary1() {
        return proSalary1;
    }

    public void setProSalary1(String proSalary1) {
        this.proSalary1 = proSalary1;
    }

    public String getProSalary2() {
        return proSalary2;
    }

    public void setProSalary2(String proSalary2) {
        this.proSalary2 = proSalary2;
    }

    public String getProSalary3() {
        return proSalary3;
    }

    public void setProSalary3(String proSalary3) {
        this.proSalary3 = proSalary3;
    }

    public String getProPrompt() {
        return proPrompt;
    }

    public void setProPrompt(String proPrompt) {
        this.proPrompt = proPrompt;
    }

    public Long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Long create_at) {
        this.create_at = create_at;
    }

    public Long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Long update_at) {
        this.update_at = update_at;
    }

    @Override
    public String toString() {
        return "Profession{" +
                "proId=" + proId +
                ", proName='" + proName + '\'' +
                ", proIntroduction='" + proIntroduction + '\'' +
                ", proThreshold=" + proThreshold +
                ", proDifficulty=" + proDifficulty +
                ", proCompany='" + proCompany + '\'' +
                ", proSalary1='" + proSalary1 + '\'' +
                ", proSalary2='" + proSalary2 + '\'' +
                ", proSalary3='" + proSalary3 + '\'' +
                ", proPrompt='" + proPrompt + '\'' +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                '}';
    }
}
